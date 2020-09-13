package com.roxan.bookreward;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookrewardApplication{

//	@Autowired
//	private BookTypeRepository bookTypeRepository;

		public static void main(String[] args) {
			SpringApplication.run(com.roxan.bookreward.BookrewardApplication.class, args);
		}



//	public void run(String... args) {
//
//		BookType bookType = new BookType();
//		bookType.setTypeName("Romance");
//		bookTypeRepository.save(bookType);
//		bookType.setTypeName("S.F.");
//		bookTypeRepository.save(bookType);
//
//	}
	}
