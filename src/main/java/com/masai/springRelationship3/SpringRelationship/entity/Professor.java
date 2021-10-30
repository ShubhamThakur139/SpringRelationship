package com.masai.springRelationship3.SpringRelationship.entity;

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
public class Professor {
    @Id
    private long professorId;
    private String name;
    private int age;
    private String address;

    @ManyToMany
    @JoinTable(name = "Professor_Subject",
        joinColumns = @JoinColumn(name = "PROFESSOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    List<Subject> subjects =  new ArrayList<>();

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject){
        this.subjects.remove(subject);
    }

}
