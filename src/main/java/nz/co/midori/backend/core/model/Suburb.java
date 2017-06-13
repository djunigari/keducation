package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "SUBURB")
public class Suburb implements Serializable{
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
