package nz.co.midori.backend.core.model;

import javax.persistence.*;

/**
 * Created by djunigari on 8/06/17.
 */
@Entity
@Table(name = "FACEBOOK_USER")
@NamedQueries({
        @NamedQuery(name = FacebookUser.FIND_BY_FACEBOOK_ID, query = "From FacebookUser u where u.facebookId = :facebookId"),
})
public class FacebookUser extends User{
    public static final String FIND_BY_FACEBOOK_ID = "FacebookUser.findByFacebookId";
    @Column(name = "FACEBOOK_ID")
    private String facebookId;
    @Column(name = "LINK")
    private String link;

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public String toString() {
        return "FacebookUser{" +
                "facebookId='" + facebookId + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
