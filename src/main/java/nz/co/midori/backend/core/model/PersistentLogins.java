package nz.co.midori.backend.core.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Created by alexandreigari on 23/06/17.
 */
@Entity
@Table(name = "persistent_logins")
public class PersistentLogins {

    @Id
    @Max(64)
    private String series;
    @NotNull
    @Max(64)
    @Column(name = "username")
    private String userName;
    @NotNull
    @Max(64)
    private String token;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_used")
    private Calendar lastUsed;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Calendar lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public String toString() {
        return "PersistentLogins{" +
                "series='" + series + '\'' +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", lastUsed=" + lastUsed +
                '}';
    }
}