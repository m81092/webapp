package com.udemy.webapp.bootstrap;

import com.udemy.webapp.domain.Author;
import com.udemy.webapp.domain.Book;
import com.udemy.webapp.domain.Publisher;
import com.udemy.webapp.repo.AuthorRepo;
import com.udemy.webapp.repo.BookRepo;
import com.udemy.webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
  
  private final AuthorRepo authorRepo;
  private final BookRepo bookRepo;
  private final PublisherRepo publisherRepo;
  
  public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
    this.authorRepo = authorRepo;
    this.bookRepo = bookRepo;
    this.publisherRepo = publisherRepo;
  }
  
  @Override
  public void run(String... args) throws Exception {
  
    System.out.println("Started bootstrap");
  
    Publisher publisher = new Publisher("Wiley", "Funny Street", "Ottawa", "ON", "K2A1G6");
    publisherRepo.save(publisher);
    
    Author author = new Author("Eric", "Evans");
    Book book = new Book("DDD", "123561");
    author.getBooks().add(book);
    book.getAuthors().add(author);
    book.setPublisher(publisher);
    publisher.getBooks().add(book);
    
    authorRepo.save(author);
    bookRepo.save(book);
    publisherRepo.save(publisher);
    
    Author author1 = new Author("Rod", "Johnson");
    Book book1 = new Book("JDK", "58671");
    author1.getBooks().add(book1);
    book1.getAuthors().add(author1);
    book1.setPublisher(publisher);
    publisher.getBooks().add(book1);
    
    authorRepo.save(author1);
    bookRepo.save(book1);
    publisherRepo.save(publisher);
    
    System.out.println("Number of books: " + bookRepo.count());
    System.out.println("Number of Publishers: " + publisherRepo.count());
  
  }
}
