package com.juniorAssociate.RSI.lifeJacket.Entities;

public enum Category {
    EMAIL("Email"),
    MEETING("Meeting"),
    CALENDAR("Calendar"),
    SLACK("Slack");

    private final String type;

    Category(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
