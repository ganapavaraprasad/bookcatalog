package com.book.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Books;
import com.book.service.BooksService;
//mark class as Controller
@RestController
public class BooksController 
{
//autowire the BooksService class
@Autowired
BooksService booksService;
//creating a get mapping that retrieves all the books detail from the database 
@RequestMapping("/book")
private List<Books> getAllBooks() 
{
return booksService.getAllBooks();
}


//creating a get mapping that retrieves the detail of a specific book
@GetMapping("/book/{ISBN}")
private Books getBooks(@PathVariable("ISBN") int ISBN) 
{
return booksService.getBooksById(ISBN);
}


//creating a delete mapping that deletes a specified book
@DeleteMapping("/book/{ISBN}")
private void deleteBook(@PathVariable("ISBN") int ISBN) 
{
booksService.delete(ISBN);
}
//creating post mapping that post the book detail in the database
@PostMapping("/books")
private int saveBook(@RequestBody Books books) 
{
booksService.saveOrUpdate(books);
return books.getISBN();
}
//creating put mapping that updates the book detail 
@PutMapping("/books")
private Books update(@RequestBody Books books) 
{
booksService.saveOrUpdate(books);
return books;
}
}
