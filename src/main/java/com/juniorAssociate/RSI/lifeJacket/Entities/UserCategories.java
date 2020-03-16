package com.juniorAssociate.RSI.lifeJacket.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user_categories")
public class UserCategories {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "user_categories_id")
    long userCategoriesId;
    Boolean complete;
    Boolean pending;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "email")
    private User user;

    @Column(name = "category_id")
    long categoryId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "original_category_id")
    private Categories categories;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStep> userSteps;

    public UserCategories() {
    }

    public long getUserCategoriesId() {
        return userCategoriesId;
    }

    public void setUserCategoriesId(long userCategoriesId) {
        this.userCategoriesId = userCategoriesId;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public List<UserStep> getUserSteps() {
        return userSteps;
    }

    public void setUserSteps(List<UserStep> userSteps) {
        this.userSteps = userSteps;
    }
}
