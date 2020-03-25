package com.juniorAssociate.RSI.lifeJacket.Repositories;

import com.juniorAssociate.RSI.lifeJacket.Entities.UserCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCategoriesRepository extends JpaRepository<UserCategories, Long> {
    @Query("SELECT uc " +
            "FROM UserCategories uc " +
            "WHERE uc.pending = true AND uc.user.email = :email")
    List<UserCategories> findPendingCategories(@Param("email")String email);

    @Query("Select uc "+
            "FROM UserCategories uc " +
            "WHERE uc.userCategoriesId = :categoryId AND uc.user.email = :email")
    UserCategories findUserCategory(@Param("email")String email, @Param("categoryId") long categoryId);

    UserCategories findByUserCategoriesId(Long id);

    List<UserCategories> deleteByUserCategoriesId(Long id);
}
