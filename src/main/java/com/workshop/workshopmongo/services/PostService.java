package com.workshop.workshopmongo.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.workshopmongo.domain.Post;
import com.workshop.workshopmongo.repository.PostRepository;
import com.workshop.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		try {
			return repo.findById(id).orElseThrow();
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
}
