package com.jangra.library.librarybookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "BookCount")
@Entity
public class BookCountRecord {
	
	@Id
	@SequenceGenerator(name = "countGenerator" , initialValue = 5000)
	@GeneratedValue(generator = "countGenerator" , strategy = GenerationType.IDENTITY)
	private Long cId;
	
	private Integer count;
	
	
	  public BookCountRecord() { super(); }
	  
	  public BookCountRecord(Integer count) { super(); this.count = count; }
	 

	@Override
	public String toString() {
		return "BookCountRecord [cId=" + cId +", count=" + count + "]";
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
