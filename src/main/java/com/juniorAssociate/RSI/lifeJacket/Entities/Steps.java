package com.juniorAssociate.RSI.lifeJacket.Entities;


import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
This class directly generates and describes an sql table "steps"
Table ID:
    o	stepId
Non-Null fields include
    o	stepId
    o	stepSequenceNum
    o	title
    o	categoriesId

Non-Null fields in database include
    o	step_id
    o	sequence_num
    o	title
    o	categories_id

Relations:
    o	Many-To-One: Categories  - used to associate steps to a given category.
    o	One-To-One: UserStep - used to provide userSteps with generic step information.

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name= "steps")
public class Steps {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "step_id")
    long stepId;
   @NotNull
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "sequence_num", nullable = false)
   int stepSequenceNum;
    @NotNull
    @UniqueElements
    @Column(name = "title", nullable = false)
    String title;
    String description;
    String categoryName;

    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Categories categoriesId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "step_id", referencedColumnName = "user_step_id", nullable = false)
    private UserSteps userStep;


    public Steps(Long stepId, int stepSequenceNum, String title, String description) {
        this.stepId = stepId;
        this.stepSequenceNum= stepSequenceNum;
        this.title = title;
        this.description = description;
    }

    public Steps() {

    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", stepSequenceNum=" + stepSequenceNum +
                ", tile='" + title + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Categories categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
