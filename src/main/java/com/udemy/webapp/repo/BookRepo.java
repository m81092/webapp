package com.udemy.webapp.repo;

import com.udemy.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {

}
