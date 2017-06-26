package nz.co.midori.frontend.configs;

import nz.co.midori.backend.core.model.*;
import nz.co.midori.backend.core.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by djunigari on 7/06/17.
 */
@Component
@ApplicationScope
public class ApplicationAttributes {
    @Autowired
    private RegionalCouncilRepository regionalCouncilRepository;
    @Autowired
    private SuburbRepository suburbRepository;
    @Autowired
    private TerritorialAuthorityRepository territorialAuthorityRepository;
    @Autowired
    private CategorySchoolRepository categorySchoolRepository;
    @Autowired
    private TypeSchoolRepository typeSchoolRepository;
    @Autowired
    private AuthoritySchoolRepository authoritySchoolRepository;

    private List<Suburb> suburbs;
    private List<RegionalCouncil> regions;
    private List<TerritorialAuthority> territorialAuthorities;
    private List<CategorySchool> categorySchools;
    private List<AuthoritySchool> authoritySchools;
    private List<TypeSchool> typeSchools;
    private List<FundingType> fundingTypes;


    @PostConstruct
    private void setUp(){
        suburbs = suburbRepository.getAll();
        regions = regionalCouncilRepository.getAll();
        territorialAuthorities = territorialAuthorityRepository.getAll();
        categorySchools = categorySchoolRepository.getAll();
        authoritySchools = authoritySchoolRepository.getAll();
        typeSchools = typeSchoolRepository.getAll();
        fundingTypes = Arrays.asList(FundingType.values());
    }

    public List<Suburb> getSuburbs() {
        return suburbs;
    }

    public List<TerritorialAuthority> getTerritorialAuthorities() {
        return territorialAuthorities;
    }

    public List<CategorySchool> getCategorySchools() {
        return categorySchools;
    }

    public List<AuthoritySchool> getAuthoritySchools() {
        return authoritySchools;
    }

    public List<TypeSchool> getTypeSchools() {
        return typeSchools;
    }

    public List<FundingType> getFundingTypes() {
        return fundingTypes;
    }

    public List<RegionalCouncil> getRegions() {
        return regions;
    }
}
