package com.juniorAssociate.RSI.lifeJacket.Entities;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/*
This class directly generates and describes an sql table "dev_center"
Table ID:
    o	location

Non-Null fields include
    o	location
    o	hrRep

Non-Null fields in database include:
    o	location
    o	hr_rep

Relations:
    o	One-To-Many: User   - used to associate users to a particular dev-center

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name="dev_center")
public class DevCenter {
    @Id
    String location;
    @NotNull
    @Column(name = "hr_rep", nullable = false)
    String hrRep;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHrRep() {
        return hrRep;
    }

    public void setHrRep(String hrRep) {
        this.hrRep = hrRep;
    }

    public DevCenter(String location, String hrRep) {
        this.location = location;
        this.hrRep = hrRep;
    }

    public DevCenter() {
    }
}
