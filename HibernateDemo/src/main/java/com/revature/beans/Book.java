package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	
	public Book() {
		super();
	}
	public Book(String title, String genre, String authorFirstName, String authorLastName) {
		super();
		this.title = title;
		this.genre = genre;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
	}
	public Book(int id, String title, String genre, String authorFirstName, String authorLastName) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="bookSequence")
	@SequenceGenerator(allocationSize=1, name="bookSequence", sequenceName="SQ_BOOK_PK")
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="BOOK_TITLE")
	private String title;
	
	@Column(name="BOOK_GENRE")
	private String genre;
	
	@Column(name="AUTHOR_FIRST_NAME")
	private String authorFirstName;
	
	@Column(name="AUTHOR_LAST_NAME")
	private String authorLastName;
	
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorFirstName == null) ? 0 : authorFirstName.hashCode());
		result = prime * result + ((authorLastName == null) ? 0 : authorLastName.hashCode());
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
		if (authorFirstName == null) {
			if (other.authorFirstName != null)
				return false;
		} else if (!authorFirstName.equals(other.authorFirstName))
			return false;
		if (authorLastName == null) {
			if (other.authorLastName != null)
				return false;
		} else if (!authorLastName.equals(other.authorLastName))
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", authorFirstName=" + authorFirstName
				+ ", authorLastName=" + authorLastName + "]";
	}

}
