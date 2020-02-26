package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    Optional<Step> findById();
    //Step findByTitle(String title);
    //todo: for built in functions look up jpa repository
}
