package com.test.itemsonsale.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOTDEALS")
public class Hotdeals {

	@Id
	private int itemid;

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	
}
