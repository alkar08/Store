package com.todouno.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todouno.app.models.Service.IProductoService;
import com.todouno.app.models.entity.Carrito;
import com.todouno.app.models.entity.Producto;


@Controller
public class ProductoController {
	
	@Autowired
	IProductoService productoService;
	
	List<Carrito> listaCarrito = new ArrayList<Carrito>();
	Integer item = 0;
	Double totalPagar = 0.0;
	Integer cantidad = 1;

	
	@RequestMapping(value = {"/catalogo","/"}, method = RequestMethod.GET)
	public String catalogoProductos(@RequestParam(name = "cantidad", required = false)Integer cantidad, Model model, HttpServletRequest request){
		List<Producto>listaProductos = new ArrayList<Producto>();
		listaProductos = productoService.findAll();
		
		model.addAttribute("titulo", "Catálogo de productos");
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("cantpro", request.getAttribute("cantpro"));
		
		return "catalogo";
	}
	
	@RequestMapping(value="/detalles/{id}", method = RequestMethod.GET)
	public String verDetalles(@PathVariable(value = "id")Long id, Model model, RedirectAttributes flash) {
		
		Producto producto = productoService.findOne(id);
		if (producto == null) {
			flash.addAttribute("error", "El cliente no existe en la Base de Datos");
			return "redirect:/catalogo";
		}
		model.addAttribute("producto", producto);
		model.addAttribute("titulo","Detalle Producto: "+ producto.getDescripcion());
		return "detalles";
	}
	
	@RequestMapping(value="/agregar-carrito/{id}", method = RequestMethod.GET)
	public String agregarCarrito(@PathVariable(value = "id")Long id, HttpServletRequest request, RedirectAttributes flash) {
		
		Producto producto = productoService.findOne(id);
		
		item = item+1;
		Carrito carrito = new Carrito();
		carrito.setItem(item);
		carrito.setIdProducto(producto.getId());
		carrito.setNombre(producto.getNombre());
		carrito.setDescripcion(producto.getDescripcion());
		carrito.setFoto(producto.getFoto());
		carrito.setPrecio(producto.getPrecio());
		carrito.setCantidad(cantidad);
		carrito.setSubTotal(cantidad*producto.getPrecio());
		listaCarrito.add(carrito);
		request.setAttribute("cantpro", listaCarrito.size());
		request.setAttribute("listaCarrito", listaCarrito);
		flash.addAttribute("success", "Se agregó con éxito");
		return "forward:/catalogo";
	}
	
	@RequestMapping(value="/ver-articulos-compra", method = RequestMethod.GET)
	public String comprar(Model model) {
		totalPagar = 0.0;
		model.addAttribute("listaCarrito", listaCarrito);
		model.addAttribute("cantidadProductos", listaCarrito.size());
		return "articulos-compra";
	}
	
	@RequestMapping(value="/pagar", method = RequestMethod.GET)
	public String pagar(Model model) {
		
		return "tarjeta-credito";
	}
	
}
