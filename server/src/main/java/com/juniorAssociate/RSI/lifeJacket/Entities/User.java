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

    @Column(name="picture_url")
     String pictureUrl;

    @Column(name = "provider")
    String provider;

    @Column(name = "auth_token", length = 300)
    String authToken;

    @Column(name = "id_token", length = 2050)
    String idToken;

    @NotNull
    @ManyToOne
    private Role role;

    @NotNull
    @ManyToOne
    private DevCenter devCenter;

    @OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserCategories> userCategories;
    @OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSteps> userSteps;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "email", nullable = false)
//    private Picture picture;

    public User() {
    }
}
