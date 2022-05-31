package partum.springframework.partum.web.application.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import partum.springframework.partum.web.application.domain.Author;
import partum.springframework.partum.web.application.domain.Book;
import partum.springframework.partum.web.application.domain.Publisher;
import partum.springframework.partum.web.application.repositories.AuthorRepository;
import partum.springframework.partum.web.application.repositories.BookRepository;
import partum.springframework.partum.web.application.repositories.PublisherRepository;

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

        System.out.println("Started in bootstrap");

        Publisher jwsi= new Publisher();
        jwsi.setName("John Wiley & Sons, Inc.");
        jwsi.setAddressLine1("111 River Street");
        jwsi.setCity("Hoboken");
        jwsi.setState("NJ");
        jwsi.setZip("07030-5774");

        publisherRepository.save(jwsi);

        Publisher careercup= new Publisher();
        careercup.setName("CareerCup");
        careercup.setCity("Palo Alto");
        careercup.setState("CA");

        publisherRepository.save(careercup);

        Author doug = new Author("Doug", "Lowe");
        Book jaio = new Book("Java ALL-IN-ONE for dummies", "978-1119247791");
        doug.getBooks().add(jaio);
        jaio.getAuthors().add(doug);

        jaio.setPublisher(careercup);
        careercup.getBooks().add(jaio);

        authorRepository.save(doug);
        bookRepository.save(jaio);
        publisherRepository.save(careercup);

        Author gayle = new Author("Gayle", "McDowell");
        Book ctci = new Book("Cracking the Coding Interview", "978-0984782857");
        gayle.getBooks().add(ctci);
        ctci.getAuthors().add(gayle);

        ctci.setPublisher(jwsi);
        jwsi.getBooks().add(ctci);

        authorRepository.save(gayle);
        bookRepository.save(ctci);
        publisherRepository.save(jwsi);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Count: "+ publisherRepository.count());

        if(careercup.getBooks().size()>0){
            System.out.println("Publishing company "+careercup.getName()+" Number of Books: "+careercup.getBooks().size());
        }

        if(jwsi.getBooks().size()>0){
            System.out.println("Publishing company "+jwsi.getName()+" Number of Books: "+careercup.getBooks().size());
        }

    }
}
