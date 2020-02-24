package com.juniorAssociate.RSI.lifeJacket.Entities;

import org.hibernate.annotations.NaturalId;
//todo: id is of type long

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_step")
public class UserStep {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "user_step_id")
    Long userStepId;
    Boolean complete;
    Boolean pending;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "email")
    private User user;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "step_id")
    private Step stepId;
}
//todo: join of user and steps