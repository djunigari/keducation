package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.model.RegionalCouncil;
import nz.co.midori.backend.core.model.School;
import nz.co.midori.backend.core.repositories.SchoolRepository;
import nz.co.midori.frontend.configs.ApplicationAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by djunigari on 5/06/17.
 */
@Controller
public class SchoolController {
    @Autowired
    private SchoolRepository repository;
    @Autowired
    private ApplicationAttributes appAttributes;

    @GetMapping("/school")
    public String schoolShortInforPage(Model model){
        model.addAttribute("regions",appAttributes.getRegions());
        return "/public/school/index";
    }

    @PostMapping("/school")
    public String registerSchoolShortInfo(Model model, School school, BindingResult result){
        model.addAttribute("regions",appAttributes.getRegions());
        if(repository.findByRegionAndSchoolName(school.getRegionalCouncil(),school.getName().trim()) != null){
            result.addError(new FieldError("school","name","School existent"));
        }
        if(result.hasErrors()) {
            return "/public/school/index";
        }
        repository.create(school);
        return "redirect:/school/"+school.getSchoolId()+"/reviews";
    }

    @GetMapping("/school/{id}")
    public String getSchool(
            @PathVariable("id") long schoolId,
            Model model){
        if(schoolId > 0) {
            School school = repository.findBySchoolId(schoolId);
            if (school == null) {
                return "/public/error/404";
            }
            model.addAttribute("school", school);
        }
        model.addAttribute("suburbs",appAttributes.getSuburbs());
        model.addAttribute("authorities",appAttributes.getAuthoritySchools());
        model.addAttribute("categories",appAttributes.getCategorySchools());
        model.addAttribute("typeSchoolList",appAttributes.getTypeSchools());
        model.addAttribute("fundingTypeList",appAttributes.getFundingTypes());
        model.addAttribute("regions",appAttributes.getRegions());
        model.addAttribute("territorialAuthorityList",appAttributes.getTerritorialAuthorities());
        return "/authenticated/school/index";
    }


    @GetMapping("/schools")
    public String getSchools(Model model,
                             @RequestParam(value="region", required=false) String region,
                             @RequestParam(value="school-name", required=false) String schoolName,
                             @RequestParam(value="page",defaultValue = "1")int page,
                             @RequestParam(value="page-size",defaultValue = "10")int pageSize){
        int first = (page-1)*pageSize;

        List<RegionalCouncil> regions = appAttributes.getRegions();
        List<School> list;
        long count = 0;
        if(!isEmpty(region) && !isEmpty(schoolName)){
            list = repository.findByRegionAndSchoolName(region,schoolName,first,pageSize);
            count = repository.countByRegionAndSchoolName(region,schoolName);
        }else if(!isEmpty(region)){
            list = repository.findByRegion(region,first,pageSize);
            count = repository.countByRegion(region);
        }else if(!isEmpty(schoolName)) {
            list = repository.findBySchoolName(schoolName,first,pageSize);
            count = repository.countBySchoolName(schoolName);
        }else{
            list = repository.findAll(first,pageSize);
            count = repository.countAll();
        }
        long totalPages = (count/pageSize)+1;
        StringBuilder href = new StringBuilder("/schools?region=").append(region == null ? "" : region)
                .append("&school-name=").append(schoolName == null ? "" : schoolName)
                .append("&page=");

        model.addAttribute("href",href.toString());
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("totalResult",count);
        model.addAttribute("currentPage",page);
        model.addAttribute("regions",regions);
        model.addAttribute("schools", list);
        return "/public/school/school-list";
    }
    public boolean isEmpty(String val){
        return val == null || val.isEmpty();
    }
}
