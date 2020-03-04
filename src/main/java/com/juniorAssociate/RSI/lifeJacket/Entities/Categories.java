package com.juniorAssociate.RSI.lifeJacket.Entities;
//Todo: id is of type long
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    long categoryId;

    @NotNull
    @Column(name = "category", nullable = false)
    String category;
    @OneToOne(mappedBy = "category")
    private Step steps;

    public Categories() {
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
