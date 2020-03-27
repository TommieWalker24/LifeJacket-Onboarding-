package com.juniorAssociate.RSI.lifeJacket.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
This class directly generates and describes an sql table "steps"
Table ID:
    o	pictureId
Non-Null fields include
    o	pictureId
    o	stepSequenceNum
    o	title
    o	categoriesId

Non-Null fields in database include
    o	picture_id
    o	sequence_num
    o	title
    o	categories_id

Relations:
    o	Many-To-One: Categories  - used to associate steps to a given category.
    o	One-To-One: UserStep - used to provide userSteps with generic step information.
     o	One-To-Many: Picture  - used to associate steps many pictures in picture table.

@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name="picture")
public class Picture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "picture_id", insertable = false)
    long pictureId;
    @Column
    byte[] image;

    @ManyToOne
    Steps step;


    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
