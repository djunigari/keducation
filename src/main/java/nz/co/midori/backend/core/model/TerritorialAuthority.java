package nz.co.midori.backend.core.model;

import javax.persistence.*;

/**
 * Created by djunigari on 22/05/17.
 */
@Entity
@Table(name = "TERRITORIAL_AUTHORITY")
public class TerritorialAuthority {
    @Id
    @GeneratedValue
    @Column(name = "TERRITORIAL_AUTHORITY_ID")
    private long territorialAuthorityId;
    @Column(name = "NAME")
    private String name;

    public TerritorialAuthority() {
    }

    public TerritorialAuthority(String name) {
        this.name = name;
    }

    public long getTerritorialAuthorityId() {
        return territorialAuthorityId;
    }

    public void setTerritorialAuthorityId(long territorialAuthorityId) {
        this.territorialAuthorityId = territorialAuthorityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TerritorialAuthority{" +
                "territorialAuthorityId=" + territorialAuthorityId +
                ", name='" + name + '\'' +
                '}';
    }
}
