package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	
	public Book(int id, String title, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
	}
	public Book(String title, Genre genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	public Book() {
		super();
	}
	
	@Id // indicates that this is the primary key! ("persistent identity")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="bookSequence")
	@SequenceGenerator(allocationSize=1, name="bookSequence", sequenceName="SQ_BOOK_PK")
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="BOOK_TITLE")
	private String title;
	
	// establish a foreign key from Book to Genre
	// Genre has to be a mapped entity for this work correctly
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="GENRE_ID")
	private Genre genre;
	
	// unidirectional many-many relationship with Author
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="BOOK_AUTHOR", 
		joinColumns = { @JoinColumn(name="BOOK_ID")}, 
		inverseJoinColumns= { @JoinColumn(name="AUTHOR_ID")})
	private List<Author> authors = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", authors=" + authors + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
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
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
