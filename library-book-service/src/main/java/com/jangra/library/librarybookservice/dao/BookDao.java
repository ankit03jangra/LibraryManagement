package com.jangra.library.librarybookservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.jangra.library.librarybookservice.model.Book;
import com.jangra.library.librarybookservice.model.BookCountRecord;
import com.jangra.library.librarybookservice.repository.BookCountRepository;
import com.jangra.library.librarybookservice.repository.BookRepository;

@Component
public class BookDao {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookCountRepository countRepository;
	

	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = repository.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	public ResponseEntity<Book> getBookById(Long id) {
			 Optional<Book> book = repository.findById(id);
			if(book.isPresent())
				return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
			else
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Book not available with id "+id);
	}

	
	public ResponseEntity<List<Book>> getBookByCategory(String category) {
		List<Book> books = repository.findByBookCategory(category);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	
	
	public ResponseEntity<List<Book>> getBookByName(String bookName) {
		List<Book> books = repository.findByName(bookName);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	
	
	public ResponseEntity<Book> addBook(Book book) {
		List<Book> existingBook = repository.
				findByNameAndMrpAndRentAndBookCategory(book.getName(),book.getMrp(),book.getRent(),book.getBookCategory());
		if(existingBook.isEmpty()){
			BookCountRecord record = new BookCountRecord(1);
			countRepository.save(record);
			book.setBookCountRecord(record);
			repository.save(book);
		}	
		else {
			BookCountRecord record =  existingBook.get(0).getBookCountRecord();
			record.setCount(record.getCount()+1);
			System.out.println(record.toString());
			book.setBookCountRecord(record);
			System.out.println(book.toString());
			repository.save(book);
		}
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	
	
	
	public ResponseEntity<Book> removeBook(Long id) {
		Optional<Book> book= repository.findById(id);
		if(book.isPresent()) {
			BookCountRecord record = book.get().getBookCountRecord();
			record.setCount(record.getCount()-1);
			repository.deleteById(id);
			return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
		}
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Book not available with id "+id);
		}

	
	
	
	public ResponseEntity<Book> updateBook(Book book) {
		Book updatedBook = repository.getOne(book.getBookId());
		
		BookCountRecord record = updatedBook.getBookCountRecord();
		if(record.getCount()==1)
			countRepository.delete(record);
		else
		record.setCount(record.getCount()-1);
		
			if(book.getName()!=null)
				updatedBook.setName(book.getName());
			if(book.getMrp()!=0)
				updatedBook.setMrp(book.getMrp());
			if(book.getRent()!=0)
				updatedBook.setRent(book.getRent());
			if(book.getBookCategory()!=null)
				updatedBook.setBookCategory(book.getBookCategory());
			
			List<Book> books = repository.findByBookQuery(updatedBook.getName(),
					updatedBook.getMrp(),updatedBook.getRent(),updatedBook.getBookCategory());
			
			if(books.isEmpty()) {
				BookCountRecord rec = new BookCountRecord(1);
				countRepository.save(rec);
				updatedBook.setBookCountRecord(rec);
				repository.save(updatedBook);
			}
			else {
				BookCountRecord rec =  books.get(0).getBookCountRecord();
				rec.setCount(rec.getCount()+1);
				book.setBookCountRecord(rec);
				repository.save(book);
			}
			return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	
	
	public ResponseEntity<Book> orderingBook(long id) {
		Book updatedBook = repository.getOne(id);
		BookCountRecord record = updatedBook.getBookCountRecord();
		record.setCount(record.getCount()-1);
		updatedBook.setAvailable(false);
		updatedBook.setBookCountRecord(record);
		repository.save(updatedBook);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
	}
	
	public ResponseEntity<Book> returningBook(long id) {
		Book updatedBook = repository.getOne(id);
		BookCountRecord record = updatedBook.getBookCountRecord();
		record.setCount(record.getCount()+1);
		updatedBook.setAvailable(true);
		updatedBook.setBookCountRecord(record);
		repository.save(updatedBook);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
	}
	
	
	
	
}
