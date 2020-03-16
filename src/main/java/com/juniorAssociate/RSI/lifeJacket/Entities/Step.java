package com.juniorAssociate.RSI.lifeJacket.Entities;


import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "steps")
public class Step {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "step_id")
    long stepId;
   @NotNull
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "sequence_num")
   int stepSequenceNum;
    @NotNull
    @UniqueElements
    @Column(name = "title", nullable = false)
    String tile;
    String description;
    @NotNull

    //todo many to one
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories categoriesId;

    //todo: one to one

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "step_id", referencedColumnName = "user_step_id", nullable = false)
    private UserStep userStep;


    public Step(Long stepId, int stepSequenceNum, String tile, String description) {
        this.stepId = stepId;
        this.stepSequenceNum= stepSequenceNum;
        this.tile = tile;
        this.description = description;
    }

    public Step() {

    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", stepSequenceNum=" + stepSequenceNum +
                ", tile='" + tile + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public int getStepSequenceNum() {
        return stepSequenceNum;
    }

    public void setStepSequenceNum(int stepSequenceNum) {
        this.stepSequenceNum = stepSequenceNum;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
