package com.juniorAssociate.RSI.lifeJacket.Entities;
//Todo: id is of type long
import com.sun.istack.NotNull;

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
import java.util.Comparator;
import java.util.List;
/*
This class directly generates and describes an sql table "categories"
Table ID:
    o	categoryId
Non-Null fields include
    o	categoryId
    o	seqNum
    o	category
    o	role
Relations:
    o	One-To-Many: Steps   - used to associate steps to a particular category.
    o	Many-To-One: Role   - used to associate a number a categories to a given role.

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name="categories")
public class Categories {

    //todo: need to set ai to true through code
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", insertable = false)
    long categoryId;

    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sequence_number", nullable = false)
    int seqNum;

    @NotNull
    @Column(name = "original_category_name", nullable = false)
    String category;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Step> steps;
    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    public Categories() {
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }

    public static Comparator<Categories>sortBySequenceNumber = new Comparator<Categories>() {
        @Override
        public int compare(Categories o1, Categories o2) {
            return o1.seqNum - o2.seqNum;
        }
    };

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
