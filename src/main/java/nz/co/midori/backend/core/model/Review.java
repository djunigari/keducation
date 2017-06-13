package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by djunigari on 20/05/17.
 */
@Entity
@Table(name="REVIEW")
@NamedQueries({
        @NamedQuery(name = Review.FIND_BY_SCHOOL_AND_USER, query = "From Review r where r.reviewPK.userId = :userId and r.reviewPK.schoolId = :schoolId"),
        @NamedQuery(name = Review.FIND_BY_SCHOOL_WITH_COMMENTARIES, query = "From Review r where r.reviewPK.schoolId = :schoolId and r.commentary != null"),
})
public class Review{
    public static final String FIND_BY_SCHOOL_AND_USER = "Review.findBySchoolAndUser";
    public static final String FIND_BY_SCHOOL_WITH_COMMENTARIES = "Review.findBySchoolWithCommentaries";

    @EmbeddedId
    private ReviewPK reviewPK;
    @Column(name = "SCORE")
    private double score = 3;
    @Column(name = "QUALITY_SCORE")
    private int qualityScore = 3;
    @Column(name = "COMFORT_SCORE")
    private int comfortScore = 3;
    @Column(name = "LOCATION_SCORE")
    private int locationScore = 3;
    @Column(name = "PRICE_SCORE")
    private int priceScore = 3;
    @Column(name = "SUPPORT_SCORE")
    private int supportScore = 3;
    @Column(name = "COMMENTARY")
    private String commentary = null;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_REVIEW")
    private Calendar dataReview;
    @Column(name = "RECOMMENDATION")
    private boolean recommendation = true;
    @ManyToOne
    @JoinColumn(name="USER_ID", insertable = false, updatable = false)
    private User user;

    public Review() {
        this.reviewPK = new ReviewPK();
    }

    public ReviewPK getReviewPK() {
        return reviewPK;
    }

    public void setReviewPK(ReviewPK reviewPK) {
        this.reviewPK = reviewPK;
    }

    public double getScore() {
        return score;
    }

    public void setScore() {
        this.score = (qualityScore+comfortScore+locationScore+priceScore+supportScore)/5;
    }

    public int getSupportScore() {
        return supportScore;
    }

    public void setSupportScore(int supportScore) {
        this.supportScore = supportScore;
        setScore();
    }

    public int getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
        setScore();
    }

    public int getComfortScore() {
        return comfortScore;
    }

    public void setComfortScore(int comfortScore) {
        this.comfortScore = comfortScore;
        setScore();
    }

    public int getLocationScore() {
        return locationScore;
    }

    public void setLocationScore(int locationScore) {
        this.locationScore = locationScore;
        setScore();
    }

    public int getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(int priceScore) {
        this.priceScore = priceScore;
        setScore();
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Calendar getDataReview() {
        return dataReview;
    }

    public void setDataReview(Calendar dataReview) {
        this.dataReview = dataReview;
    }

    public boolean isRecommendation() {
        return recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.reviewPK.setUserId(user.getUserId());
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewPK=" + reviewPK +
                ", score=" + score +
                ", qualityScore=" + qualityScore +
                ", comfortScore=" + comfortScore +
                ", locationScore=" + locationScore +
                ", priceScore=" + priceScore +
                ", supportScore=" + supportScore +
                ", commentary='" + commentary + '\'' +
                ", dataReview=" + dataReview +
                ", recommendation=" + recommendation +
                ", user=" + user +
                '}';
    }
}
