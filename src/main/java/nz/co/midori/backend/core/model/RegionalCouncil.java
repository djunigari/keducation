package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "REGIONAL_COUNCIL")
@NamedQueries({
        @NamedQuery(name = RegionalCouncil.FIND_ALL, query = "From RegionalCouncil r"),
})
public class RegionalCouncil implements Serializable{
    public static final String FIND_ALL = "RegionalCouncil.findAll";

    @Id
    @GeneratedValue
    @Column(name = "REGIONAL_COUNCIL_ID")
    private long regionalCouncilId;
    @Column(name = "NAME")
    private String name;

    public RegionalCouncil() {
    }

    public RegionalCouncil(String name) {
        this.name = name;
    }

    public long getRegionalCouncilId() {
        return regionalCouncilId;
    }

    public void setRegionalCouncilId(long regionalCouncilId) {
        this.regionalCouncilId = regionalCouncilId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegionalCouncil{" +
                "regionalCouncilId=" + regionalCouncilId +
                ", name='" + name + '\'' +
                '}';
    }
}
