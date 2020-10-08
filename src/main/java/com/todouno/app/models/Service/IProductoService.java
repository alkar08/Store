package com.todouno.app.models.Service;

import java.util.List;

import com.todouno.app.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public void save(Producto producto);
	
	public  Producto findOne(Long id);
	
	public void delete(Long id);

}
