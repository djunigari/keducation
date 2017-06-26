package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.UserRole;
import nz.co.midori.backend.core.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexandreigari on 20/06/17.
 */
@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository repository;

    public UserRole createUserRole(UserRole role){
        repository.save(role);
        return role;
    }
}
