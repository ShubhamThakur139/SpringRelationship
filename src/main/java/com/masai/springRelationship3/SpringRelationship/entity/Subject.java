package com.masai.springRelationship3.SpringRelationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    private long subjectId;
    private String  subjectName;
    private String subjectTiming;
    private String duration;
    private int roomNumber;

    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    List<Professor> professors = new ArrayList<>();

    public void addProfessor(Professor professor){
        this.professors.add(professor);
    }
    public void removeProfessor(Professor professor){
        this.professors.remove(professor);
    }

}
