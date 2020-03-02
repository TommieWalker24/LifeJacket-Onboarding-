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

//todo: id is of type long
@Entity
@Table(name= "steps")
public class Step {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "step")
    Long stepId;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "step_num")
    private Role steps_of_role;
    @NotNull
    @UniqueElements
    String tile;
    String description;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category", referencedColumnName = "category")
    private Categories category;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStep> user;

    public Step(Long stepId, Role steps_of_role, String tile, String description, Categories category, List<UserStep> user) {
        this.stepId = stepId;
        this.steps_of_role = steps_of_role;
        this.tile = tile;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    public Step() {

    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", steps_of_role=" + steps_of_role +
                ", tile='" + tile + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Role getSteps_of_role() {
        return steps_of_role;
    }

    public void setSteps_of_role(Role steps_of_role) {
        this.steps_of_role = steps_of_role;
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

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<UserStep> getUser() {
        return user;
    }

    public void setUser(List<UserStep> user) {
        this.user = user;
    }

}
