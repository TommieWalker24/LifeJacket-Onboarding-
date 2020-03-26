package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.DevCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevCenterRepository extends JpaRepository <DevCenter,String> {
    //todo: for built in functions look up jpa repository
    public DevCenter findByLocation(String location);
}
