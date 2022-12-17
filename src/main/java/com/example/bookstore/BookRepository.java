package com.example.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BookRepository extends CrudRepository<Book, String> {

	/*
	 * @PreAuthorize("hasRole('ROLE_ADMIN')")
	 * 
	 * @Override Optional<Book> findById(String isbn);
	 * 
	 * @PreAuthorize("hasRole('ROLE_ADMIN')") // <2>
	 * 
	 * @Override void deleteById(String isbn);
	 * 
	 * @PreAuthorize("hasRole('ROLE_ADMIN')")
	 * 
	 * @Override void delete(Book book);
	 * 
	 * @PreAuthorize("hasRole('ROLE_ADMIN')")
	 * 
	 * @Override void deleteAll(Iterable<? extends Book> books);
	 * 
	 * @PreAuthorize("hasRole('ROLE_ADMIN')")
	 * 
	 * @Override void deleteAll();
	 */
	@RestResource(path = "byTitle", rel = "byTitle")
	List<Book> findByTitle(@Param("title") String title);

	//public List<Student> findByStudent_Grades_ClassName(final String className);

	@RestResource(path = "byAuthorName", rel = "byAuthorName")
	List<Book> findByAuthors_Name(@Param("name") String name);
	
	@Override
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	void deleteById(String isbn);

	@Override
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	void delete(Book book);
}
