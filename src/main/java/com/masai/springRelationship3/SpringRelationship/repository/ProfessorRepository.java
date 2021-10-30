package com.masai.springRelationship3.SpringRelationship.repository;

import com.masai.springRelationship3.SpringRelationship.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
