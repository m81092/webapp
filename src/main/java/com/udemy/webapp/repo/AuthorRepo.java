package com.udemy.webapp.repo;

import com.udemy.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {


}
