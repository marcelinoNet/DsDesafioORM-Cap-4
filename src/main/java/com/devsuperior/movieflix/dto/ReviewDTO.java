package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank
	private String text;
	private UserMinDTO userDTO;
	private Long movieId;
	
	public ReviewDTO() {}

	public ReviewDTO(Long id, String text, UserMinDTO userDTO, Long movieId) {
		this.id = id;
		this.text = text;
		this.userDTO = userDTO;
		this.movieId = movieId;
	}
	
	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.userDTO = new UserMinDTO(entity.getUser());
		this.movieId = entity.getMovie().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserMinDTO getUser() {
		return userDTO;
	}

	public void setUser(UserMinDTO userDTO) {
		this.userDTO = userDTO;
	}

	
	
}
