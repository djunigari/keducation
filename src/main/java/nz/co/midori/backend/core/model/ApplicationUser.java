package nz.co.midori.backend.core.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Email
    @NotNull
    @NotEmpty
    @Column(name = "EMAIL", unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "userId=" + getUserId() +
                ", email='" + email + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", birthday=" + getBirthday() +
                ", phone='" + getPhone() + '\'' +
                ", mobile='" + getMobile() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", activated=" + isActivated() +
                '}';
    }
}
