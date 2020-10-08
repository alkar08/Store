package com.todouno.app.models.entity;

public class Carrito {
	
	private Integer item;
	
	private Long idProducto;
	
	private String nombre;
	
	private String descripcion;
	
	private String foto;
	
	private Double precio;
	
	private Integer cantidad;
	
	private Double subTotal;

	
	public Carrito() {
		
	}
	

	public Carrito(Integer item, Long idProducto, String nombre, String descripcion, String foto, Double precio,
			Integer cantidad, Double subTotal) {
		super();
		this.item = item;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}


	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}	
	
}
