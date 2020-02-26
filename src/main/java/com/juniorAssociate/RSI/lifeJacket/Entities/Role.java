package com.juniorAssociate.RSI.lifeJacket.Entities;
//todo: id is of type string
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

//todo: id is of type string
@Entity
public class Role implements Serializable {
    @Id
    String role;
    @OneToOne(mappedBy = "role")
            private User user;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Step> steps;


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

}
