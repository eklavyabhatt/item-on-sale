package com.test.itemsonsale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ratingid; 
	private int userid; 
	private int itemid; 
	private int rating;
	public int getRatingid() {
		return ratingid;
	}
	public void setRatingid(int ratingid) {
		this.ratingid = ratingid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	} 
	
	
}
