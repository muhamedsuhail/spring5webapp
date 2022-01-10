package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRespository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;

/**
 * Created by muhamedsuhail on 09-Jan-2022
 */

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRespository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRespository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author thiruvalluvar = new Author("Thiru", "Valluvar");
		Book thirukkural = new Book("Thirukkural", "9788184721096");
		
		Publisher palaniappa = new Publisher("Palaniappa Bros","No: 420, Govindha Street","Abase Nagar","Shroov Nadu","666666");
		publisherRepository.save(palaniappa);
		
		thiruvalluvar.getBooks().add(thirukkural);
		thirukkural.getAuthors().add(thiruvalluvar);
		thirukkural.setPublisher(palaniappa);
		palaniappa.getBooks().add(thirukkural);
		
		
		authorRepository.save(thiruvalluvar);
		bookRepository.save(thirukkural);
		publisherRepository.save(palaniappa);
		
		Author barathiyar = new Author("Subramania", "Bharathi");
		Book barathiyarKavithaigal = new Book("Barathiyar Kavithaigal", "9788123401447");
		
		Publisher Kalaingan = new Publisher("Kalaingan","No: 629, Soori Street","SK na Nagar","Shroov Nadu","777777");
		publisherRepository.save(Kalaingan);
		
		barathiyar.getBooks().add(barathiyarKavithaigal);
		barathiyarKavithaigal.getAuthors().add(barathiyar);
		barathiyarKavithaigal.setPublisher(Kalaingan);
		Kalaingan.getBooks().add(barathiyarKavithaigal);
		
		authorRepository.save(barathiyar);
		bookRepository.save(barathiyarKavithaigal);
		publisherRepository.save(Kalaingan);
		
		System.out.println("Started BootStrap Class");
		System.out.println("Number of Authors: " + authorRepository.count());
		System.out.println("Number of Books : " + bookRepository.count());
		System.out.println("Number of Publishers : " + publisherRepository.count());
	}

}
