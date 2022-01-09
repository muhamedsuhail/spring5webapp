package guru.springframework.spring5webapp.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String title;
	private String isbn;

	@ManyToMany()
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;

	public Book() {

	}

	public Book(String title, String isbn, Set<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
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
		Book other = (Book) obj;
		return Objects.equals(Id, other.Id);
	}

}
