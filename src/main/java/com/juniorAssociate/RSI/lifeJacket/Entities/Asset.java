package com.juniorAssociate.RSI.lifeJacket.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//todo: id is of type long
@Entity
@Table(name="assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asset_id")
    long equipmentNumber;
    @Column(name = "equipment")
    Equipment equipment;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "email")
    private User user;

    public Asset(String user_email, long equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public long getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(long equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @Override
    public String toString() {
        return "Asset{" +
                ", equipmentNumber=" + equipmentNumber +
                ", user=" + user +
                '}';
    }

    public Asset() {
    }
}
