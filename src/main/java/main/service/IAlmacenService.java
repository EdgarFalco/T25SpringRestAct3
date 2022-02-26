package main.service;

import java.util.List;

import main.dto.Almacen;

public interface IAlmacenService {

	public List<Almacen> listarAlmacen();
	
	public Almacen almacenXID(Long id);
	
	public Almacen guardarAlmacen(Almacen almacen);
				
	public Almacen actualizarAlmacen(Almacen almacen);
	
	public void eliminarAlmacen(Long id);
}
