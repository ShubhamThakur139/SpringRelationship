package com.masai.springRelationship3.SpringRelationship.controller;


import com.masai.springRelationship3.SpringRelationship.entity.Subject;
import com.masai.springRelationship3.SpringRelationship.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping("/subject")
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @PutMapping("/subject")
    public String updateSubject(@RequestBody Subject subject){
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/subject/{id}")
    public String deleteSubject(@PathVariable("id") long subjectId){
        boolean flag = subjectService.deleteSubject(subjectId);
        if(flag) return "delete successfully";
        else return "delete Failed";
    }


}
