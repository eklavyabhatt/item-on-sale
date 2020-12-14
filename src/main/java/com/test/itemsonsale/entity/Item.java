package com.test.itemsonsale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@JsonProperty("itemid")
	@Column(name="itemid")
	private int itemid;
	@JsonProperty("categoryid")
	@Column(name="categoryid")
	private int categoryid;
	@JsonProperty("categoryame")
	@Column(name="categoryame")
	private String categoryame; 
	@JsonProperty("itemname")
	@Column(name="itemname")
	private String itemname;
	@JsonProperty("itemdescription")
	@Column(name="itemdescription")
	private String itemdescription;
	@JsonProperty("isitemonsale")
	@Column(name="isitemonsale")
	private String isitemonsale;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryame() {
		return categoryame;
	}
	public void setCategoryame(String categoryame) {
		this.categoryame = categoryame;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemdescription() {
		return itemdescription;
	}
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public String getIsitemonsale() {
		return isitemonsale;
	}
	public void setIsitemonsale(String isitemonsale) {
		this.isitemonsale = isitemonsale;
	} 
	
	
}
