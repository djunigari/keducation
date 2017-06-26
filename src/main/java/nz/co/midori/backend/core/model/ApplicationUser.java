package nz.co.midori.backend.core.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by djunigari on 9/06/17.
 */
@Entity
@Table(name = "APPLICATION_USER")
@NamedQueries({
        @NamedQuery(name = ApplicationUser.FIND_BY_USER_NAME, query = "From ApplicationUser u where u.userName = :userName"),
        @NamedQuery(name = ApplicationUser.FIND_BY_EMAIL, query = "From ApplicationUser u where u.email = :email"),
        @NamedQuery(name = ApplicationUser.FIND_BY_EMAIL_AND_PASSWORD, query = "From ApplicationUser u where u.email = :email and u.password = :password and u.activated = true"),
})
public class ApplicationUser extends User {
    public static final String FIND_BY_USER_NAME ="ApplicationUser.findByUserName";
    public static final String FIND_BY_EMAIL = "ApplicationUser.findByEmail";
    public static final String FIND_BY_EMAIL_AND_PASSWORD = "ApplicationUser.findByEmailAndPassword";
}
