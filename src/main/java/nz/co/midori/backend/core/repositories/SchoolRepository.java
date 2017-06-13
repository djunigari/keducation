package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.School;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by djunigari on 22/05/17.
 */
@Repository
@Transactional
public class SchoolRepository {
    @PersistenceContext
    private EntityManager em;

    public List<School> findBySchoolName(String schoolName, int first, int pageSize){
        return em.createNamedQuery(School.FIND_BY_SCHOOL_NAME, School.class)
                .setParameter("schoolName", "%"+schoolName+"%")
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long countBySchoolName(String schoolName) {
        return em.createNamedQuery(School.COUNT_BY_SCHOOL_NAME, Long.class)
                .setParameter("schoolName", "%"+schoolName+"%")
                .getSingleResult();
    }

    public School findBySchoolId(long schoolId){
        List<School> list = em.createNamedQuery(School.FIND_BY_SCHOOL_ID, School.class)
                .setParameter("schoolId", schoolId)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public List<School> findByRegionAndSchoolName(String region, String schoolName, int first, int pageSize) {
        return em.createNamedQuery(School.FIND_BY_REGION_AND_SCHOOL_NAME, School.class)
                .setParameter("region", region)
                .setParameter("schoolName", "%"+schoolName+"%")
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long countByRegionAndSchoolName(String region, String schoolName) {
        return em.createNamedQuery(School.COUNT_BY_REGION_AND_SCHOOL_NAME, Long.class)
                .setParameter("region", region)
                .setParameter("schoolName", "%"+schoolName+"%")
                .getSingleResult();
    }

    public List<School> findByRegion(String region, int first, int pageSize) {
        return em.createNamedQuery(School.FIND_BY_REGION, School.class)
                .setParameter("region", region)
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long countByRegion(String region) {
        return em.createNamedQuery(School.COUNT_BY_REGION, Long.class)
                .setParameter("region", region)
                .getSingleResult();
    }

    public List<School> findAll(int first, int pageSize) {
        return em.createNamedQuery(School.FIND_ALL, School.class)
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long countAll() {
        return em.createNamedQuery(School.COUNT_ALL, Long.class)
                .getSingleResult();
    }
}

