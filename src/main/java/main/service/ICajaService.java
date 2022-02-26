package main.service;

import java.util.List;

import main.dto.Caja;

public interface ICajaService {

	public List<Caja> listarCaja();
	
	public Caja cajaXID(Character id);
	
	public Caja guardarCaja(Caja caja);	
		
	public Caja actualizarCaja(Caja caja);
	
	public void eliminarCaja(Character id);
}
