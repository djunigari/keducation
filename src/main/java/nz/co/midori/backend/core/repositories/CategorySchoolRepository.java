package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.CategorySchool;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alexandreigari on 17/06/17.
 */
@Repository
@Transactional
public class CategorySchoolRepository {
    @PersistenceContext
    private EntityManager em;

    public List<CategorySchool> getAll() {
        return em.createNamedQuery(CategorySchool.FIND_ALL, CategorySchool.class)
                .getResultList();
    }
}
