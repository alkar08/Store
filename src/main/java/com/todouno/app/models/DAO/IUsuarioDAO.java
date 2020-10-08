package com.todouno.app.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.todouno.app.models.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
	
}
