package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends  JpaRepository<Asset, Long> {
}
