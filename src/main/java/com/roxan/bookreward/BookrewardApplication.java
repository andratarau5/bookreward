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
//	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookrewardApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Book book = new Book();
//		book.setTitle("Ion");
//		book.setAuthor("Liviu Rebreanu");
//		book.setYear(1920);
//
//		bookRepository.save(book);
//	}
}
