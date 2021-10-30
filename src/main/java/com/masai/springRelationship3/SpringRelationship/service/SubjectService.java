package com.masai.springRelationship3.SpringRelationship.service;

import com.masai.springRelationship3.SpringRelationship.entity.Professor;
import com.masai.springRelationship3.SpringRelationship.entity.Subject;
import com.masai.springRelationship3.SpringRelationship.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public String updateSubject(Subject subject) {
        Optional<Subject> subject1 = subjectRepository.findById(subject.getSubjectId());
        if(subject1.isEmpty()) return "Repository Error";

        try{
            subject1.get().setSubjectName(subject.getSubjectName());
            subject1.get().setSubjectTiming(subject.getSubjectTiming());
            subject1.get().setDuration(subject.getDuration());
            subject1.get().setRoomNumber(subject.getRoomNumber());
            subjectRepository.save(subject1.get());
            return "Update Successfully";
        }catch (Exception ex){
            return "Update Failed";
        }
    }

    public boolean deleteSubject(long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        try{
            subjectRepository.delete(subject);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
