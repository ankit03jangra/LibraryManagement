package com.jangra.library.librarybookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jangra.library.librarybookservice.model.BookCountRecord;

public interface BookCountRepository extends JpaRepository<BookCountRecord,Long>{
	
}
