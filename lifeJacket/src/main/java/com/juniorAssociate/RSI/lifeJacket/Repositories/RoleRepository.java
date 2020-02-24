package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
//todo: for built in functions look up jpa repository
}
