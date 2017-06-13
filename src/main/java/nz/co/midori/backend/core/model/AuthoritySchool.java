package nz.co.midori.backend.core.model;

import javax.persistence.*;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "AUTHORITY_SCHOOL")
public class AuthoritySchool {
    @Id
    @GeneratedValue
    @Column(name = "AUTHORITY_SCHOOL_ID")
    private long authoritySchoolId;
    @Column(name = "NAME")
    private String name;

    public AuthoritySchool() {
    }

    public AuthoritySchool(String name) {
        this.name = name;
    }

    public long getAuthoritySchoolId() {
        return authoritySchoolId;
    }

    public void setAuthoritySchoolId(long authoritySchoolId) {
        this.authoritySchoolId = authoritySchoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthoritySchool{" +
                "authoritySchoolId=" + authoritySchoolId +
                ", name='" + name + '\'' +
                '}';
    }
}
