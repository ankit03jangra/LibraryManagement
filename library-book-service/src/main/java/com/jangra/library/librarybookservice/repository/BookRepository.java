package com.jangra.library.librarybookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jangra.library.librarybookservice.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	
	public List<Book> findByName(String name);
	//@Query(value = "select distinct book_category,book_count_record_c_id from book where book_category=?1", nativeQuery = true)
	public List<Book> findByBookCategory(String category);
	public List<Book> findByNameAndMrpAndRentAndBookCategory(String name,float mrp,int rent,String bookCategory);
	@Query(value = "select * from book where name=?1 and mrp=?2 and rent=?3 and book_category=?4", nativeQuery = true)
	public List<Book> findByBookQuery(String name, float mrp, int rent, String bookCategory);

}