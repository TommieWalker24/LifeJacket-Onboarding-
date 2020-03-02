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
//todo: type is of type string
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "email")
    String email;
    @NotNull
    @Column(name= "fist_name")
    String firstName;
    @NotNull
    @Column(name= "last_name")
    String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "role" )
    private Role role;

    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "dev_center")
    private DevCenter devCenter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Asset> assignedEquipment;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStep> userSteps;

    String password;
    int cubeNumber;

    public User() {
    }
}
