package com.juniorAssociate.RSI.lifeJacket.Entities;

//todo: id is of type long

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
@Table(name = "user_step")
public class UserStep {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "user_step_id")
    long userStepId;
    Boolean complete;
    Boolean pending;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "email")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "step_id")
    private Step stepId;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_category_id")
    private UserCategories userCategoriesId;

    public UserStep() {
    }

    public long getUserStepId() {
        return userStepId;
    }

    public void setUserStepId(long userStepId) {
        this.userStepId = userStepId;
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

    public Step getStepId() {
        return stepId;
    }

    public void setStepId(Step stepId) {
        this.stepId = stepId;
    }

    public UserCategories getUserCategoriesId() {
        return userCategoriesId;
    }

    public void setUserCategoriesId(UserCategories userCategoriesId) {
        this.userCategoriesId = userCategoriesId;
    }
}
//todo: join of user and steps