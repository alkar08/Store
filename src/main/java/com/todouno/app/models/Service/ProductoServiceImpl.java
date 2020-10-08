package com.todouno.app.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todouno.app.models.DAO.IProductoDAO;
import com.todouno.app.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	IProductoDAO productoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productoDAO.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		return productoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDAO.deleteById(id);
		
	}

}
