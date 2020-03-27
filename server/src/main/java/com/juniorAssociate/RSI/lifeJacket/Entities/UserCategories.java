package com.juniorAssociate.RSI.lifeJacket.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
import java.util.Comparator;
import java.util.List;

/*
This class directly generates and describes an sql table "user_categories"
Table ID:
    o	userCategoriesId
Non-Null fields include
    o	userCategoriesId
    o	user
    o	categories

Non-Null fields in database include
    o	user_categories_id
    o	user
    o	category_id

Relations:
    o	One-To-Many: UserStep  - used to correspond user steps to a particular user category
    o	One-To-One: Categories - used to associate user category to generic category and its information.

@author: Tommie Walker
@version: 1.0.0
 */

@Entity
@Table(name = "user_categories")
public class UserCategories {
    @Id
    @JsonProperty
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "user_categories_id")
    long userCategoriesId;
    Boolean complete;
    Boolean pending;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Categories categories;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "userCategoriesId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSteps> userSteps;



    public static Comparator<UserCategories> sortBySequenceNumber = new Comparator<UserCategories>() {
        @Override
        public int compare(UserCategories o1, UserCategories o2) {
            return o1.getCategories().seqNum - o2.getCategories().seqNum;
        }
    };
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public List<UserSteps> getUserSteps() {
        return userSteps;
    }

    public void setUserSteps(List<UserSteps> userSteps) {
        this.userSteps = userSteps;
    }


}
