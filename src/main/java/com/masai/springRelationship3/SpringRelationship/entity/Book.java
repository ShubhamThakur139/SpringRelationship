package com.masai.springRelationship3.SpringRelationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    long bookId;
    String bookName;
    String bookPublication;
    String bookCategory;
    int pages;
    int price;


    @ManyToOne
    @JsonIgnore
    Author author;

}

