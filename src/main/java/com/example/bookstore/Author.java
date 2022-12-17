package com.example.bookstore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "AUTHORS")
public class Author {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private java.sql.Date birthday;

	//Caused by: org.hibernate.cfg.RecoverableException: 
	// A '@JoinColumn' references a column named 'isbn' 
	//but the target entity 'com.example.bookstore.models.Author' has no property which maps to this column

  @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "book_author", 
	   joinColumns = @JoinColumn(name = "book_isbn"),
	   inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Book> books;

	public Author() {
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
