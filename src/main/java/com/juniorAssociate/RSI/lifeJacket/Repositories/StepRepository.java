package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StepRepository extends JpaRepository<Step, Long> {

}
