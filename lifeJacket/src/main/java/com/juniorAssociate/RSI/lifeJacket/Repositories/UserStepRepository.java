package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.UserStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStepRepository extends JpaRepository<UserStep, Long> {
    //todo: for built in functions look up jpa repository
}
