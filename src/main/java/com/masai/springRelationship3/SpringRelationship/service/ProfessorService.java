package com.masai.springRelationship3.SpringRelationship.service;

import com.masai.springRelationship3.SpringRelationship.entity.Professor;
import com.masai.springRelationship3.SpringRelationship.entity.Subject;
import com.masai.springRelationship3.SpringRelationship.repository.ProfessorRepository;
import com.masai.springRelationship3.SpringRelationship.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public List<Professor> getAllProfessor() {
        return  professorRepository.findAll();
    }

    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public boolean deleteProfessor(long professorId) {
        Professor professor = professorRepository.findById(professorId).get();
        try{
            professorRepository.delete(professor);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    public String updateProfessor(Professor professor) {
        Optional<Professor> professor1 = professorRepository.findById(professor.getProfessorId());
        if(professor1.isEmpty()) return "Repository Error";

        try{
            professor1.get().setName(professor.getName());
            professor1.get().setAge(professor.getAge());
            professor1.get().setAddress(professor.getAddress());
            professorRepository.save(professor1.get());
            return "Update Successfully";
        }catch (Exception ex){
            return "Update Failed";
        }
    }

    public Professor addProfessorSubject(long professorId, long subjectId) {
        Professor professor = professorRepository.findById(professorId).get();
        Subject subject = subjectRepository.findById(subjectId).get();

        subject.addProfessor(professor);
        professor.addSubject(subject);

        return professorRepository.save(professor);
    }
}
