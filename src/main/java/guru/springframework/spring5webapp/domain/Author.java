package guru.springframework.spring5webapp.domain;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;

	public Author() {
		
	}

	public Author(Long  id, String firstName, String lastName, Set<Book> books) {
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	public Long  getId() {
		return Id;
	}

	public void setId(Long  id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
