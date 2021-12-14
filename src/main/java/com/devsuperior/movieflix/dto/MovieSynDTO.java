package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieSynDTO extends MovieDTO{

	private static final long serialVersionUID = 1L;
	
	private String synopsis;
	private Genre genre;
	
	public MovieSynDTO() {}

	public MovieSynDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis,
			Genre genre) {
		super(id, title, subTitle, year, imgUrl);
		this.synopsis = synopsis;
		this.genre = genre;
	}
	
	public MovieSynDTO(Movie entity) {
		super(entity.getId(), entity.getTitle(), entity.getSubTitle(), entity.getYear(), entity.getImgUrl());
		this.synopsis = entity.getSynopsis();
		this.genre = entity.getGenre();
	}
	
	

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	


	
}
