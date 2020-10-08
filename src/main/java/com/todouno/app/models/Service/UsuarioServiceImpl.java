package com.todouno.app.models.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todouno.app.models.DAO.IUsuarioDAO;
import com.todouno.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);		
	}
}
