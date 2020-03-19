package com.juniorAssociate.RSI.lifeJacket.Entities;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
This class directly generates and describes an sql table "user_steps"
Table ID:
    o	userStepId
Non-Null fields include
    o	userStepId
    o	email
    o	stepId
    o	userCategoriesId

Non-Null fields in database include
    o	user_step_id
    o	email
    o	step_id
    o	user_category_id

Relations:
    o	Many-To-One: User  - used to get the user email from user object
    o	One-To-One: Step   - used to get the generic step information
    o	Many-To-One: UserCategories   - used to correspond a user's step to a user's category

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name = "user_step")
public class UserStep {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "user_step_id")
    long userStepId;
    Boolean complete;
    Boolean pending;
    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "email", nullable = false)
    private User user;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "step_id", nullable = false)
    private Step stepId;

    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_category_id", nullable = false)
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