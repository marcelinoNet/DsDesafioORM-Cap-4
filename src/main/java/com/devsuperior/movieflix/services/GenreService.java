package com.devsuperior.movieflix.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public List<GenreDTO> allListGenre(){
		List<Genre> list = new ArrayList<>();
		list = genreRepository.findAll();
		return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public GenreDTO findById(Long id) {
		Optional<Genre> obj = genreRepository.findById(id);
		Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found :" + id));
		return new GenreDTO(entity);
	}
	
	@Transactional
	public GenreDTO insert(GenreDTO dto) {
		
		Genre genre =  new Genre();
		genre.setName(dto.getName());
		genre = genreRepository.save(genre);
		
		return new GenreDTO(genre);
	}
	
	@Transactional
	public GenreDTO update(Long id, GenreDTO dto) {	
		try {
			Genre entity = genreRepository.getOne(id);
			entity.setName(dto.getName());
			entity = genreRepository.save(entity);
			return new GenreDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource Not found :" + id);
		}
		
	}
	
	public void delete(Long id) {
		try {
			genreRepository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource Not found :" + id);
		}
	}
	
}
