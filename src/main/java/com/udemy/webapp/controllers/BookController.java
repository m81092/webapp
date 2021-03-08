package com.udemy.webapp.controllers;

import com.udemy.webapp.repo.AuthorRepo;
import com.udemy.webapp.repo.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
  
  private final BookRepo bookRepo;
  
  public BookController(BookRepo bookRepo, AuthorRepo authorRepo) {
    this.bookRepo = bookRepo;
  }
  
  @RequestMapping("/books")
  public String getBook(Model model) {
    model.addAttribute("books", bookRepo.findAll());
    return "books/list";
  }
}
