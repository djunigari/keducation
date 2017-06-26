package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "SUBURB")
@NamedQueries({
        @NamedQuery(name = Suburb.FIND_ALL, query = "From Suburb s"),
})
public class Suburb implements Serializable{
    public static final String FIND_ALL = "Suburb.findAll";
    @Id
    @GeneratedValue
    @Column(name = "SUBURB_ID")
    private long suburbId;
    @Column(name = "NAME")
    private String name;

    public Suburb() {
    }

    public Suburb(String name) {
        this.name = name;
    }

    public long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(long suburbId) {
        this.suburbId = suburbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Suburb{" +
                "suburbId=" + suburbId +
                ", name='" + name + '\'' +
                '}';
    }
}
