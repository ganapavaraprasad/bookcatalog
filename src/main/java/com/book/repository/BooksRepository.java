package com.book.repository;
import org.springframework.data.repository.CrudRepository;

import com.book.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
