package com.masai.springRelationship3.SpringRelationship.repository;

import com.masai.springRelationship3.SpringRelationship.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
