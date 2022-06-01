package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

import guru.springframework.spring5webapp.repositories.PublisherRepository;
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
        Publisher publisher =new Publisher("A", "add1", "KTM", "Kerala", "12345");
        Author emil = new Author("Emil", "Francis");
        Book alpha = new Book("Alpha", "1123Alpha");
        publisher.getBooks().add(alpha);
        alpha.getAuthors().add(emil);
        emil.getBooks().add(alpha);
        authorRepository.save(emil);
        publisherRepository.save(publisher);
        bookRepository.save(alpha);



        Author francis = new Author("Francis" , "K F");
        Book omega = new Book("Omega", "1123Omega");
        francis.getBooks().add(omega);
        omega.getAuthors().add(francis);
        authorRepository.save(francis);
        bookRepository.save(omega);


        System.out.println(authorRepository.count());

        System.out.println(publisherRepository.count());

    }
}
