package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.Review;
import nz.co.midori.backend.core.model.School;
import nz.co.midori.backend.core.model.SchoolReview;
import nz.co.midori.backend.core.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by djunigari on 20/05/17.
 */
@Repository
@Transactional
public class ReviewRepository {
    @PersistenceContext
    private EntityManager em;

    public Review createReview(Review review){
        if(review.getCommentary() == null || review.getCommentary().trim().isEmpty()){
            review.setCommentary(null);
        }
        return em.merge(review);
    }

    public Review findBySchoolAndUser(School school,User user){
        List<Review> list = em.createNamedQuery(Review.FIND_BY_SCHOOL_AND_USER, Review.class)
                .setParameter("userId", user.getUserId())
                .setParameter("schoolId", school.getSchoolId())
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public SchoolReview findSchoolReview(School school){
        String jpql = "SELECT AVG(r.score), AVG(r.qualityScore)," +
                "AVG(r.comfortScore), AVG(r.locationScore)," +
                "AVG(r.priceScore), AVG(r.supportScore), " +
                "count(*) FROM Review r WHERE r.reviewPK.schoolId = :schoolId";
        Object[] results = (Object[]) em.createQuery(jpql)
                .setParameter("schoolId", school.getSchoolId())
                .getSingleResult();
        double score = 0.0;
        double qualityScore = 0.0;
        double comfortScore = 0.0;
        double locationScore = 0.0;
        double priceScore = 0.0;
        double supportScore = 0.0;

        long total = (Long)results[6];

        if(results[0] != null){
            score = (Double)results[0];
            qualityScore = (Double)results[1];
            comfortScore = (Double)results[2];
            locationScore = (Double)results[3];
            priceScore = (Double)results[4];
            supportScore = (Double)results[5];
        }

        SchoolReview schoolReview = new SchoolReview(school,score,total);
        schoolReview.setQualityScore(qualityScore);
        schoolReview.setComfortScore(comfortScore);
        schoolReview.setLocationScore(locationScore);
        schoolReview.setPriceScore(priceScore);
        schoolReview.setSupportScore(supportScore);
        long count = countReccomendation(school);
        schoolReview.setRecommendation(count > 0 ? total/count : 0.0);
        schoolReview.setReviewList(getReviewsBySchoolWithCommentaries(school));
        return schoolReview;
    }

    public long countReccomendation(School school) {
        String jpql = "SELECT count(r) FROM Review r WHERE r.reviewPK.schoolId = :schoolId and r.recommendation = true";
        return (long) em.createQuery(jpql)
                .setParameter("schoolId", school.getSchoolId())
                .getSingleResult();
    }

    public List<Review> getReviewsBySchoolWithCommentaries(School school){
        return em.createNamedQuery(Review.FIND_BY_SCHOOL_WITH_COMMENTARIES, Review.class)
                .setParameter("schoolId", school.getSchoolId())
                .getResultList();
    }
}
