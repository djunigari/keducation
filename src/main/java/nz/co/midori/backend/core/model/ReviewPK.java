package nz.co.midori.backend.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by djunigari on 24/05/17.
 */
@Embeddable
public class ReviewPK implements Serializable {
    @Column(name = "SCHOOL_ID")
    private long schoolId;
    @Column(name = "USER_ID")
    private long userId;

    public ReviewPK() {
    }

    public ReviewPK(long schoolId, long userId) {
        this.schoolId = schoolId;
        this.userId = userId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ReviewPK){
            ReviewPK pk = (ReviewPK)obj;
            if(!(pk.getSchoolId() == schoolId)){
                return false;
            }
            if(!(pk.getUserId() == userId)){
                return false;
            }
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return ("l"+schoolId+userId).hashCode();
    }
}
