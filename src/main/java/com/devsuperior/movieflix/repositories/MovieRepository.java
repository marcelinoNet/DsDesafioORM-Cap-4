package com.devsuperior.movieflix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	
	@Query("SELECT obj FROM Movie obj "
			+ "INNER JOIN obj.genre gen "
			+ "WHERE (COALESCE(:genre) IS NULL OR :genre IN gen) "
			+ "ORDER BY obj.title")
	Page<Movie> find(Genre genre, Pageable pageable);
	
	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre WHERE obj IN :movies")
	List<Movie> findMoviesWithGenres(List<Movie> movies);
	
	@Query(  "SELECT obj FROM Movie obj "
			+ "INNER JOIN obj.genre gen "
			+ "WHERE obj.id = :movieId")
	Optional<Movie> findMovieWithGenre(Long movieId);
	
	@Query(  "SELECT obj FROM Movie obj "
			+ "INNER JOIN obj.reviews rev "
			+ "WHERE obj.id = :movieId")
	Optional<Movie> findMovieWithReviews(Long movieId);
	
}
