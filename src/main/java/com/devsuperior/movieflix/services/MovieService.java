package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieSynDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(Long genreId, Pageable pageable){
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> page = repository.find(genre, pageable);
		repository.findMoviesWithGenres(page.getContent());
		return page.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true)
	public MovieSynDTO findById(Long movieId){	
		Optional<Movie> obj = repository.findMovieWithGenre(movieId);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));
		return new MovieSynDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findMovieWithReviews(Long movieId){	
		Optional<Movie> obj = repository.findMovieWithReviews(movieId);
		Movie movie =  obj.orElseThrow(() -> new ResourceNotFoundException("Movie does not have reviews yet"));
		List<Review> list = movie.getReviews();
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
	
	
	
	
}
