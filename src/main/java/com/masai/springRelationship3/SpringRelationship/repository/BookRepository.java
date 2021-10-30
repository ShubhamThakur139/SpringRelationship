package com.masai.springRelationship3.SpringRelationship.repository;

import com.masai.springRelationship3.SpringRelationship.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface BookRepository extends JpaRepository<Book,Long> {
}
