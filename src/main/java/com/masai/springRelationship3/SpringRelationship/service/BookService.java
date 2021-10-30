package com.masai.springRelationship3.SpringRelationship.service;

import com.masai.springRelationship3.SpringRelationship.entity.Author;
import com.masai.springRelationship3.SpringRelationship.entity.Book;
import com.masai.springRelationship3.SpringRelationship.repository.AuthorRepository;
import com.masai.springRelationship3.SpringRelationship.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book,long authorId) {
        Optional<Author> author  = authorRepository.findById(authorId);
        if(author.isEmpty()) return null;
        try{
            author.get().addBook(book);
            book.setAuthor(author.get());
            return bookRepository.save(book);
        }catch(Exception ex){
            return null;
        }

    }

    public String updateBook(Book book) {
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        if (book1.isEmpty()){
            return null;
        }
        try{
            book1.get().setBookName(book.getBookName());
            book1.get().setBookCategory(book.getBookCategory());
            book1.get().setBookPublication(book.getBookPublication());
            book1.get().setPages(book.getPages());
            book1.get().setPrice(book.getPrice());
            bookRepository.save(book1.get());
            return "Update Successfully";
        }catch (Exception ex){
            return "Update Failed";
        }
    }

    public boolean deleteBook(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        try{
            bookRepository.delete(book);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
