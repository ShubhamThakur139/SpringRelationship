package com.masai.springRelationship3.SpringRelationship.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.masai.springRelationship3.SpringRelationship.entity.Author;
import com.masai.springRelationship3.SpringRelationship.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    };

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public String updateAuthor(Author author) {
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        if (author1.isEmpty()){
            return null;
        }
         try{
             author1.get().setAuthorAge(author.getAuthorAge());
             author1.get().setAuthorName(author.getAuthorName());
             authorRepository.save(author1.get());
             return "Update Successfully";
         }catch (Exception ex){
             return "Update Failed";
         }
    }

    public boolean deleteAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).get();
        try{
            authorRepository.delete(author);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
