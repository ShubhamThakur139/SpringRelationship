package com.masai.springRelationship3.SpringRelationship.controller;

import com.masai.springRelationship3.SpringRelationship.entity.Professor;
import com.masai.springRelationship3.SpringRelationship.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/professors")
    public List<Professor> getAllProfessor(){
        return professorService.getAllProfessor();
    }

    @PostMapping("/professor/{id}/subject/{id1}")
    public Professor addProfessorSubject(@PathVariable("id") long professorId,@PathVariable("id1") long subjectId){
        return professorService.addProfessorSubject(professorId,subjectId);
    }

    @PostMapping("/professor")
    public Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @PutMapping("/professor")
    public String updateProfessor(@RequestBody Professor professor){
        return professorService.updateProfessor(professor);
    }

    @DeleteMapping("/professor/{id}")
    public String deleteProfessor(@PathVariable("id") long professorId){
        boolean flag = professorService.deleteProfessor(professorId);
        if(flag) return "delete successfully";
        else return "delete Failed";
    }

}
