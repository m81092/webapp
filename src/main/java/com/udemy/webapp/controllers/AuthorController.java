package com.udemy.webapp.controllers;

import com.udemy.webapp.repo.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
  
  private final AuthorRepo authorRepo;
  
  public AuthorController(AuthorRepo authorRepo) {
    this.authorRepo = authorRepo;
  }
  
  @RequestMapping("/authors")
  public String getAuthor(Model model) {
    model.addAttribute("authors", authorRepo.findAll());
    System.out.println(model.getAttribute("authors"));
    return "books/authors/authorlist";
  }
}
