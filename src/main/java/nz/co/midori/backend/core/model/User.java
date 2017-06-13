package nz.co.midori.backend.core.model;

import nz.co.midori.frontend.security.Crypto;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by djunigari on 8/05/17.
 */

@Entity
@Table(name = "USER")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_TYPE")
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "TOKEN")
    private String token;
    @Email
    @NotNull
    @NotEmpty
    @Column(name = "EMAIL", unique = true)
    private String email;
    @NotNull
    @NotEmpty
    @Column(name = "USER_NAME", unique = true)
    private String userName;
    @NotNull
    @NotEmpty
    @Size(min=6, max = 32)
    @Column(name = "PASSWORD")
    @ColumnTransformer(
            read="AES_DECRYPT(UNHEX(password), UNHEX(SHA2('"+Crypto.KEY+"', 512)))",
            write="HEX(AES_ENCRYPT(?, UNHEX(SHA2('"+Crypto.KEY+"', 512))))")
    private String password;
    @Transient
    private String passwordConfirmation;
    @NotNull
    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotNull
    @NotEmpty
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "BIRTHDAY")
    private Calendar birthday;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PHONE")
    private String phone;
    @NotNull
    @NotEmpty
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ACTIVATED")
    private boolean activated;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.Normal;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", activated=" + activated +
                ", role=" + role +
                '}';
    }
}
