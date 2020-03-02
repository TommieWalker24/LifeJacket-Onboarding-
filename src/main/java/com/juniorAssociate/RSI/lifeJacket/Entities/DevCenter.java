package com.juniorAssociate.RSI.lifeJacket.Entities;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

//todo: id is of type string
@Entity
@Table(name="dev_center")
public class DevCenter {
    @Id
    String location;
    @NotNull
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
