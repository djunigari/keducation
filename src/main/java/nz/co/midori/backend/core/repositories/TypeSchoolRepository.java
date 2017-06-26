package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.TypeSchool;
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
public class TypeSchoolRepository {
    @PersistenceContext
    private EntityManager em;

    public List<TypeSchool> getAll() {
        return em.createNamedQuery(TypeSchool.FIND_ALL, TypeSchool.class)
                .getResultList();
    }
}
