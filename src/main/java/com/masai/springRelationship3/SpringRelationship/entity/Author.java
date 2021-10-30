package com.masai.springRelationship3.SpringRelationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    private Long authorId;
    private String authorName;
    private int authorAge;
    private String authorAddress;

    @OneToMany(mappedBy = "author")
//    @JsonIgnore
    List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

}
