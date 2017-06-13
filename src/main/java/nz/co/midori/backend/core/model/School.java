package nz.co.midori.backend.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djunigari on 20/05/17.
 */
@Entity
@Table(name = "SCHOOL")
@NamedQueries({
        @NamedQuery(name = School.FIND_BY_SCHOOL_ID, query = "From School s where s.schoolId = :schoolId"),
        @NamedQuery(name = School.COUNT_ALL, query = "Select count(s) From School s"),
        @NamedQuery(name = School.FIND_ALL, query = "From School s"),
        @NamedQuery(name = School.COUNT_BY_SCHOOL_NAME, query = "Select count(s) From School s where s.name LIKE :schoolName "),
        @NamedQuery(name = School.FIND_BY_SCHOOL_NAME, query = "From School s where s.name LIKE :schoolName "),
        @NamedQuery(name = School.COUNT_BY_REGION, query = "Select count(s) From School s where s.regionalCouncil.name = :region"),
        @NamedQuery(name = School.FIND_BY_REGION, query = "From School s where s.regionalCouncil.name = :region"),
        @NamedQuery(name = School.COUNT_BY_REGION_AND_SCHOOL_NAME, query = "Select count(s) From School s where s.regionalCouncil.name = :region and s.name LIKE :schoolName"),
        @NamedQuery(name = School.FIND_BY_REGION_AND_SCHOOL_NAME, query = "From School s where s.regionalCouncil.name = :region and s.name LIKE :schoolName"),
})
public class School implements Serializable {
    public static final String FIND_BY_SCHOOL_NAME = "School.findBySchoolName";
    public static final String FIND_BY_SCHOOL_ID = "School.findBySchoolId";
    public static final String FIND_BY_REGION_AND_SCHOOL_NAME = "School.findByRegionAndSchoolName";
    public static final String FIND_BY_REGION = "School.findByRegion";
    public static final String FIND_ALL = "School.findAll";
    public static final String COUNT_ALL = "School.countAll";
    public static final String COUNT_BY_REGION = "School.countByRegion";
    public static final String COUNT_BY_REGION_AND_SCHOOL_NAME = "School.countByRegionAndSchoolName";
    public static final String COUNT_BY_SCHOOL_NAME = "School.countBySchoolName";
    @Id
    @GeneratedValue
    @Column(name = "SCHOOL_ID")
    private long schoolId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "WEBSITE")
    private String webSite;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TYPE_SCHOOL_ID")
    private TypeSchool typeSchool;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_SCHOOL_ID")
    private CategorySchool  categorySchool;
    @Column(name = "FUNDING_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private FundingType fundingType;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "AUTHORITY_SCHOOL_ID")
    private AuthoritySchool authoritySchool;
    @Column(name = "STREET")
    private String street;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "SUBURB_ID")
    private Suburb suburb;
    @Column(name = "POST_CODE")
    private String postCode;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "TERRITORIAL_AUTHORITY")
    private TerritorialAuthority territorialAuthority;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "REGIONAL_COUNCIL_ID")
    private RegionalCouncil regionalCouncil;
    @Column(name = "POSTAL_ADDRESS_1")
    private String postAddress1;
    @Column(name = "POSTAL_ADDRESS_2")
    private String postAddress2;
    @Column(name = "POSTAL_ADDRESS_3")
    private String postAddress3;

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public TypeSchool getTypeSchool() {
        return typeSchool;
    }

    public void setTypeSchool(TypeSchool typeSchool) {
        this.typeSchool = typeSchool;
    }

    public CategorySchool getCategorySchool() {
        return categorySchool;
    }

    public void setCategorySchool(CategorySchool categorySchool) {
        this.categorySchool = categorySchool;
    }

    public FundingType getFundingType() {
        return fundingType;
    }

    public void setFundingType(FundingType fundingType) {
        this.fundingType = fundingType;
    }

    public AuthoritySchool getAuthoritySchool() {
        return authoritySchool;
    }

    public void setAuthoritySchool(AuthoritySchool authoritySchool) {
        this.authoritySchool = authoritySchool;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public TerritorialAuthority getTerritorialAuthority() {
        return territorialAuthority;
    }

    public void setTerritorialAuthority(TerritorialAuthority territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

    public RegionalCouncil getRegionalCouncil() {
        return regionalCouncil;
    }

    public void setRegionalCouncil(RegionalCouncil regionalCouncil) {
        this.regionalCouncil = regionalCouncil;
    }

    public String getPostAddress1() {
        return postAddress1;
    }

    public void setPostAddress1(String postAddress1) {
        this.postAddress1 = postAddress1;
    }

    public String getPostAddress2() {
        return postAddress2;
    }

    public void setPostAddress2(String postAddress2) {
        this.postAddress2 = postAddress2;
    }

    public String getPostAddress3() {
        return postAddress3;
    }

    public void setPostAddress3(String postAddress3) {
        this.postAddress3 = postAddress3;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", webSite='" + webSite + '\'' +
                ", typeSchool=" + typeSchool +
                ", categorySchool=" + categorySchool +
                ", fundingType=" + fundingType +
                ", authoritySchool=" + authoritySchool +
                ", street='" + street + '\'' +
                ", suburb=" + suburb +
                ", postCode='" + postCode + '\'' +
                ", territorialAuthority=" + territorialAuthority +
                ", regionalCouncil=" + regionalCouncil +
                ", postAddress1='" + postAddress1 + '\'' +
                ", postAddress2='" + postAddress2 + '\'' +
                ", postAddress3='" + postAddress3 + '\'' +
                '}';
    }
}
