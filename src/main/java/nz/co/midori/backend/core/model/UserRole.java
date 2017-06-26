package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alexandreigari on 19/06/17.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ROLE_ID")
    private Long userRoleID;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Long getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(Long userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
