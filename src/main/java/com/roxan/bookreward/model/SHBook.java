package com.roxan.bookreward.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SHBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shBookId;

    private String title;
    private String author;

    private String seller;
    private long phoneNumber;
    private float price;

}
