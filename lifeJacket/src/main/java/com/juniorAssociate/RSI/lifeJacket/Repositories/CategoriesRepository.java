package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
