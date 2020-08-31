package com.roxan.bookreward.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BookType {

    private String typeName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;

    @OneToMany(mappedBy = "bookType", cascade = CascadeType.ALL)
    private List<Book> books;
}
