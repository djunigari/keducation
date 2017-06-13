package nz.co.midori.frontend.configs;

import nz.co.midori.backend.core.model.RegionalCouncil;
import nz.co.midori.backend.core.repositories.RegionalCouncilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by djunigari on 7/06/17.
 */
@Component
@ApplicationScope
public class ApplicationAttributes {
    @Autowired
    private RegionalCouncilRepository regionalCouncilRepository;

    private List<RegionalCouncil> regions;

    @PostConstruct
    private void setUp(){
        regions = regionalCouncilRepository.getAll();
    }

    public List<RegionalCouncil> getRegions() {
        return regions;
    }
}
