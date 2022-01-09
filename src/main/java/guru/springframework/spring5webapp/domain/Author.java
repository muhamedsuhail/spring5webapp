package guru.springframework.spring5webapp.domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<Book>();

	public Author() {
		
	}

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	@Override
	public String toString() {
		return "Author [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(Id, other.Id);
	}

}
