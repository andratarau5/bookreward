package com.roxan.bookreward.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {

    private String title;
    private String author;
    private int year;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookType bookType;
}
