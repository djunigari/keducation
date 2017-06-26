package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.TerritorialAuthority;
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
public class TerritorialAuthorityRepository {

    @PersistenceContext
    private EntityManager em;

    public List<TerritorialAuthority> getAll() {
        return em.createNamedQuery(TerritorialAuthority.FIND_ALL, TerritorialAuthority.class)
                .getResultList();
    }
}
