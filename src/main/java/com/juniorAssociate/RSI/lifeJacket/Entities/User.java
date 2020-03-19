package com.juniorAssociate.RSI.lifeJacket.Entities;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
/*
This class directly generates and describes an sql table "user"
Table ID:
    o	email
Non-Null fields include
    o	email
    o	firstName
    o	lastName
    o	role
    o	devCenter

Non-Null fields in database include
    o	email
    o	first_name
    o	last_name
    o	role
    o	dev_center

Relations:
    o	Many-To-One: Role
    o	Many-To-One: DevCenter
    o	One-To-Many: UserCategories
    o	One-To-Many: UserStep

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "email")
    String email;
    @NotNull
    @Column(name= "first_name", nullable = false)
    String firstName;
    @NotNull
    @Column(name= "last_name", nullable = false)
    String lastName;

    //todo: many to one
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "role", nullable = false)
    private Role role;

    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "dev_center", nullable = false)
    private DevCenter devCenter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserCategories> userCategories;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStep> userSteps;

    @Column(name = "picture_url")
    String pictureUrl;

    public User() {
    }
}
