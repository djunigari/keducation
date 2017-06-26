package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.AuthoritySchool;
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
public class AuthoritySchoolRepository {
    @PersistenceContext
    private EntityManager em;

    public List<AuthoritySchool> getAll() {
        return em.createNamedQuery(AuthoritySchool.FIND_ALL, AuthoritySchool.class)
                .getResultList();
    }
}
