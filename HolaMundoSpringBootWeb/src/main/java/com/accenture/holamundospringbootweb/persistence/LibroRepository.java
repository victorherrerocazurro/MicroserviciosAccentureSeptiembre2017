package com.accenture.holamundospringbootweb.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.holamundospringbootweb.recursos.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	List<Libro> findByTitulo(String titulo);
	
	@Query("select libro from Libro libro where libro.titulo = :tit")
	List<Libro> consultarLibrosPorTitulo(String tit);
	
}
