package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 21/05/17.
 */
@Entity
@Table(name = "CATEGORY_SCHOOL")
@NamedQueries({
        @NamedQuery(name = CategorySchool.FIND_ALL, query = "From CategorySchool c"),
})
public class CategorySchool implements Serializable{
    public static final String FIND_ALL = "CategorySchool.findAll";
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_SCHOOL_ID")
    private long categorySchoolId;
    @Column(name = "NAME", unique = true)
    private String name;

    public CategorySchool() {
    }

    public CategorySchool(String name) {
        this.name = name;
    }

    public long getCategorySchoolId() {
        return categorySchoolId;
    }

    public void setCategorySchoolId(long categorySchoolId) {
        this.categorySchoolId = categorySchoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategorySchool{" +
                "categorySchoolId=" + categorySchoolId +
                ", name='" + name + '\'' +
                '}';
    }
}
