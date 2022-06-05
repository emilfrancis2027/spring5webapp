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
        publisherRepository.save(publisher);

        Author emil = new Author("Emil", "Francis");
        Book alpha = new Book("Alpha", "1123Alpha");

        alpha.getAuthors().add(emil);
        emil.getBooks().add(alpha);

        publisher.getBooks().add(alpha);
        alpha.setPublisher(publisher);

        authorRepository.save(emil);
        bookRepository.save(alpha);
        publisherRepository.save(publisher);

        Author francis = new Author("Francis" , "K F");
        Book omega = new Book("Omega", "1123Omega");
        omega.getAuthors().add(francis);
        francis.getBooks().add(omega);

        omega.setPublisher(publisher);
        publisher.getBooks().add(omega);

        authorRepository.save(francis);
        bookRepository.save(omega);
        publisherRepository.save(publisher);


        System.out.println(authorRepository.count());

        System.out.println(publisherRepository.count());

    }
}
