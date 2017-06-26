package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.model.UserRole;
import nz.co.midori.backend.core.repositories.UserRoleRepository;
import nz.co.midori.backend.core.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by alexandreigari on 20/06/17.
 */
@Controller
public class UserRoleController {
    @Autowired
    private UserRoleService service;
    @Autowired
    private UserRoleRepository repository;

    @GetMapping("/user/role/{userRoleId}")
    public String getUserRole(@PathVariable("userRoleId")UserRole role){
        if(role.getUserRoleID() == null){
//            throw new ResourceNotFoundException();
        }
        repository.findOne(role.getUserRoleID());
        return "/user/role/index";
    }

    @PostMapping("/user/role/{userRoleId}")
    public String registerUserRole(UserRole role){
        service.createUserRole(role);
        return "/user/role/"+role.getUserRoleID();
    }
}
