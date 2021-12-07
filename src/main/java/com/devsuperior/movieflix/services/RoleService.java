package com.devsuperior.movieflix.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.RoleDTO;
import com.devsuperior.movieflix.entities.Role;
import com.devsuperior.movieflix.repositories.RoleRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<RoleDTO> findPagedRoles(Pageable pageable){
		Page<Role> pages = roleRepository.findAll(pageable);
		return pages.map((x) -> new RoleDTO(x));	
	}
	
	@Transactional
	public RoleDTO findById(Long id) {
		Optional<Role> obj = roleRepository.findById(id);
		Role entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return new RoleDTO(entity);
	}
	
	@Transactional
	public RoleDTO insert(RoleDTO dto) {
		
		Role entity = new Role();
		
		entity.setAuthority(dto.getAuthority());
		entity = roleRepository.save(entity);
		
		return new RoleDTO(entity);
	}
	
	@Transactional
	public RoleDTO update(Long id, RoleDTO dto) {
		try {			// TODO: handle exception
			Role entity = roleRepository.getOne(id);
			entity.setAuthority(dto.getAuthority());
			entity = roleRepository.save(entity);
			return new RoleDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found :" + id);
		}
	}
	
	public void delete(Long id) {
		try {
			roleRepository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found :" + id);
		}
	}
}
