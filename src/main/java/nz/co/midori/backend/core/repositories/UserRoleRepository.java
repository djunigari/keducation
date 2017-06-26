package nz.co.midori.backend.core.repositories;

import nz.co.midori.backend.core.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by alexandreigari on 19/06/17.
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{

    @Query("select r from UserRole r where r.name = :name")
    UserRole findByName(@Param("name") String name);
}
