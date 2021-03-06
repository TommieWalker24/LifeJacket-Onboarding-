package com.juniorAssociate.RSI.lifeJacket.Entities;
//todo: id is of type string
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
/*
This class directly generates and describes an sql table "role"
Table ID:
    o	role
Non-Null fields include:
    o	role

Non-Null fields in database include:
    o	role

Relations:
    o	One-To-Many: User  - used to associate users to a particular role
    o	One-To-Many: Categories  - used to associate categories to a particular role.

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
public class Role implements Serializable {
    @JsonProperty
    @Id
    String role;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "role", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Categories> categories;


//-----------------------------------------------------------------------
    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }
}
