package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.model.*;
import nz.co.midori.backend.core.repositories.ReviewRepository;
import nz.co.midori.backend.core.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by djunigari on 22/05/17.
 */
@Controller
public class ReviewController {
    private Logger log = Logger.getLogger("ReviewController");

    @Autowired
    private ReviewRepository repository;
    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/school/reviews")
    public String getReviewSchool(@RequestParam(value="school-id", required=true)long schoolId, Model model,HttpSession session){
        log.info("Task: getReviewSchool, schoolId: "+schoolId);
        School school = schoolRepository.findBySchoolId(schoolId);
        if(school == null){
            log.info("Task: getReviewSchool, Result: Failed, schoolId: "+schoolId);
            return "/error/404";
        }
        SchoolReview schoolReview = repository.findSchoolReview(school);
        log.info("Task: getReviewSchool, Result: Success, schoolReview: "+schoolReview);

        User user = (User)session.getAttribute(LoginController.USER_SESSION);
        if(user != null) {
            Review review = repository.findBySchoolAndUser(school,user);
            if(review == null){
                review = new Review();
                review.setReviewPK(new ReviewPK(school.getSchoolId(),user.getUserId()));
            }
            model.addAttribute("review",review);
        }
        model.addAttribute("schoolReview",schoolReview);
        return "/school/review/reviews";
    }

    @PostMapping("/school/review")
    public String createReview(Review review,HttpSession session){
        User user = (User)session.getAttribute(LoginController.USER_SESSION);
        if(user == null) {
            log.info("Task: createReview, Result: Failed, ERROR_MESSAGE: User not logged in");
            return "/error/403";
        }
        review.setUser(user);
        review.setDataReview(Calendar.getInstance());
        log.info("Task: createReview, review: "+review);
        repository.createReview(review);
        log.info("Task: createReview, Result: Success, review: "+review);

        return "redirect:/school/reviews?school-id="+review.getReviewPK().getSchoolId();
    }
}
