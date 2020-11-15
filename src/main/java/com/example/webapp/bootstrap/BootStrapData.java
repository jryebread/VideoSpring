package com.example.webapp.bootstrap;

import com.example.webapp.domain.Author;
import com.example.webapp.domain.Book;
import com.example.webapp.domain.Publisher;
import com.example.webapp.repositories.AuthorRepository;
import com.example.webapp.repositories.BookRepository;
import com.example.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher pub = new Publisher("ruspub", "2408528045");

        publisherRepository.save(pub);


        Author frank = new Author("frank", "herbert");
        Book dune = new Book("Dune", "234235");


        frank.getBooks().add(dune);
        dune.getAuthors().add(frank);
        dune.setPublisher(pub);
        pub.getBooks().add(dune);

        authorRepository.save(frank);
        bookRepository.save(dune);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "34950305");


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


        publisherRepository.save(pub);

        System.out.println("started in bootstrap");
        System.out.println("number of books:" + bookRepository.count());


    }
}
