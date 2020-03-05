package com.juniorAssociate.RSI.lifeJacket.Entities;

public enum Equipment {
    KEYFOB("Key Fob"),
   PARKINGPASS("Parking Pass"),
    COMPUTER("Computer");
    private final String equiment;
    Equipment(String equipment) {
        this.equiment = equipment;
    }

    public String getEquipment() {
        return equiment;
    }
}
