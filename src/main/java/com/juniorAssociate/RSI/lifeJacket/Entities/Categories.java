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
import java.util.List;

@Entity
@Table(name="categories")
public class Categories {

    //todo: need to set ai to true through code
    @Id
  //  @OneToOne(mappedBy = "category")
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

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "role")
    private Role role;

    public Categories() {
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
