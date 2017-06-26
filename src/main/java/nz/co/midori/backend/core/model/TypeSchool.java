package nz.co.midori.backend.core.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "TYPE_SCHOOL")
@NamedQueries({
        @NamedQuery(name = TypeSchool.FIND_ALL, query = "From TypeSchool t"),
})
public class TypeSchool implements Serializable{
    public static final String FIND_ALL = "TypeSchool.findAll";
    @Id
    @GeneratedValue
    @Column(name = "TYPE_SCHOOL_ID")
    private long typeSchoolId;
    @NotBlank
    @Column(name = "NAME", unique = true)
    private String name;

    public TypeSchool() {
    }

    public TypeSchool(String name) {
        this.name = name;
    }

    public long getTypeSchoolId() {
        return typeSchoolId;
    }

    public void setTypeSchoolId(long typeSchoolId) {
        this.typeSchoolId = typeSchoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeSchool{" +
                "typeSchoolId=" + typeSchoolId +
                ", name='" + name + '\'' +
                '}';
    }
}
