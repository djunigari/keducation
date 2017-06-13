package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.RegionalCouncil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by djunigari on 7/06/17.
 */
@Repository
@Transactional
public class RegionalCouncilRepository {
    @PersistenceContext
    private EntityManager em;

    public List<RegionalCouncil> getAll() {
        return em.createNamedQuery(RegionalCouncil.FIND_ALL, RegionalCouncil.class)
                .getResultList();
    }
}
