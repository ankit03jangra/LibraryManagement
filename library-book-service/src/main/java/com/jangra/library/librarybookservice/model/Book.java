package com.jangra.library.librarybookservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.jangra.library.librarybookservice.model.BookCountRecord;


@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Long bookId;
	
	@NotNull(message = "Book name can not be null")
	private String name;
	
	@NotNull(message = "Book MRP can not be null")
	private Float mrp;
	
	@NotNull(message = "Book rent can not be null")
	private Integer rent;
	
	private Boolean available=true; 
	
	@NotNull(message = "Book category can not be null")
	private String bookCategory;
	
	@ManyToOne
	private BookCountRecord bookCountRecord; 
	
	public Book() {
		super();
	}

	
	
	public Book(Long bookId, @NotNull(message = "Book name can not be null") String name,
			@NotNull(message = "Book MRP can not be null") Float mrp,
			@NotNull(message = "Book rent can not be null") Integer rent,
			@NotNull(message = "Book category can not be null") String bookCategory,Boolean available,
			BookCountRecord bookCountRecord) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.mrp = mrp;
		this.rent = rent;
		this.available=available;
		this.bookCategory = bookCategory;
		this.bookCountRecord = bookCountRecord;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", mrp=" + mrp + ", rent=" + rent + ", bookCategory="
				+ bookCategory + ", bookCountRecord=" + bookCountRecord + "]";
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(Float mrp) {
		this.mrp = mrp;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookCountRecord getBookCountRecord() {
		return bookCountRecord;
	}

	public void setBookCountRecord(BookCountRecord bookCountRecord) {
		this.bookCountRecord = bookCountRecord;
	}
	
	
}
