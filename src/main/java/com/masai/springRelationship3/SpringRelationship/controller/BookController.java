package com.masai.springRelationship3.SpringRelationship.controller;

import com.masai.springRelationship3.SpringRelationship.entity.Author;
import com.masai.springRelationship3.SpringRelationship.entity.Book;
import com.masai.springRelationship3.SpringRelationship.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping("/book/author/{id}")
    public Book addBook(@RequestBody Book book, @PathVariable("id") long authorId){
        return bookService.addBook(book,authorId);
    }

    @PutMapping("/book")
    public String updateBook(@RequestBody Book book){
        return  bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable("id") long bookId){
        boolean flag = bookService.deleteBook(bookId);
        if(flag) return "Book deleted";
        else return "unable to detect";
    }
}
