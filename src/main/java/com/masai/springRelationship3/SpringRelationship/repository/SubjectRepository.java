package com.masai.springRelationship3.SpringRelationship.repository;

import com.masai.springRelationship3.SpringRelationship.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
