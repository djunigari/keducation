package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.model.FacebookUser;
import nz.co.midori.backend.core.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by djunigari on 10/05/17.
 */
@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void createFacebookUser(FacebookUser user){
        user.setActivated(true);
        em.persist(user);
    }

    public void createUser(User user) {
        user.setActivated(false);
        em.persist(user);
    }

    public User updateUser(User user) {
        user = em.merge(user);
        return user;
    }

    public ApplicationUser findUserByUserName(String userName){
        List<ApplicationUser> list = em.createNamedQuery(ApplicationUser.FIND_BY_USER_NAME, ApplicationUser.class)
                .setParameter("userName", userName)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public ApplicationUser findByToken(String token){
        List<ApplicationUser> list = em.createNamedQuery(ApplicationUser.FIND_BY_TOKEN, ApplicationUser.class)
                .setParameter("token", token)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public ApplicationUser findUserByUserNameAndToken(String userName, String token) {
        List<ApplicationUser> list = em.createNamedQuery(ApplicationUser.FIND_BY_USER_NAME, ApplicationUser.class)
                .setParameter("userName", userName)
                .setParameter("token", token)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public ApplicationUser finUserByEmail(String email) {
        List<ApplicationUser> list = em.createNamedQuery(ApplicationUser.FIND_BY_EMAIL, ApplicationUser.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public ApplicationUser finUserByEmailAndPassword(String email, String password) {
        List<ApplicationUser> list = em.createNamedQuery(ApplicationUser.FIND_BY_EMAIL_AND_PASSWORD, ApplicationUser.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public FacebookUser findByFacebookId(String facebookId) {
        List<FacebookUser> list = em.createNamedQuery(FacebookUser.FIND_BY_FACEBOOK_ID, FacebookUser.class)
                .setParameter("facebookId", facebookId)
                .setMaxResults(1)
                .getResultList();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }
}
