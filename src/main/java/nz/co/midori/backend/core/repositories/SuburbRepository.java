package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.Suburb;
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
public class SuburbRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Suburb> getAll() {
        return em.createNamedQuery(Suburb.FIND_ALL, Suburb.class)
                .getResultList();
    }
}
