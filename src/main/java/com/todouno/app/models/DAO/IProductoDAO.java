package com.todouno.app.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.todouno.app.models.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{

}
