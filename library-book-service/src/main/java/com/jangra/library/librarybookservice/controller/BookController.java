package com.jangra.library.librarybookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jangra.library.librarybookservice.dao.BookDao;
import com.jangra.library.librarybookservice.model.Book;
import com.jangra.library.librarybookservice.util.CommonUtil;



@RestController
@RequestMapping("/LibraryManagement")
public class BookController {
	
	
	@Autowired
	BookDao dao;
	
	Logger logger = Logger.getLogger(BookController.class);
	
	static {
		CommonUtil.configurelog();
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		logger.info("Entering into getAllBooks method...");
		logger.debug("debug message");
		logger.info("Logging info");
		logger.debug("Logging debug");
		return dao.getAllBooks();
	}
	
	
	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		return dao.getBookById((long) id);
	}
	
	
	@GetMapping("/getBookByCategory/{category}")
	public ResponseEntity<List<Book>> getBookByCategory(@PathVariable String category){
		return dao.getBookByCategory(category);
	}
	
	
	
	@GetMapping("/getBookByName/{bookName}")
	public ResponseEntity<List<Book>> getBookByName(@PathVariable String bookName){
		return dao.getBookByName(bookName);
	}
	
	
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
		return dao.addBook(book);
	}

	
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Book> removeBook(@PathVariable int id) {
		return dao.removeBook((long)id);
	}
	
	@PutMapping("/orderingBook/{id}")
	public ResponseEntity<Book> orderingBook(@PathVariable int id) {
		return dao.orderingBook((long)id);
	}
	
	
	@PutMapping("/returningBook/{id}")
	public ResponseEntity<Book> returningBook(@PathVariable int id) {
		return dao.returningBook((long)id);
	}
	
	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return dao.updateBook(book);
	}
	
}
