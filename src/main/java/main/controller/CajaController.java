package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Caja;
import main.service.CajaServiceImpl;

@RestController
@RequestMapping("/api")
public class CajaController {

	@Autowired
	CajaServiceImpl cajaServiceImpl;

	@GetMapping("/cajas")
	public List<Caja> listarCaja() {
		return cajaServiceImpl.listarCaja();
	}
	
	@GetMapping("/cajas/{id}")
	public Caja cajaXID(@PathVariable(name = "id") Character numReferencia) {

		Caja caja_xid = new Caja();

		caja_xid = cajaServiceImpl.cajaXID(numReferencia);

		System.out.println("Caja XID: " + caja_xid);

		return caja_xid;
	}

	@PostMapping("/cajas")
	public Caja salvarCaja(@RequestBody Caja caja) {

		return cajaServiceImpl.guardarCaja(caja);
	}

	@PutMapping("/cajas/{id}")
	public Caja actualizarCaja(@PathVariable(name = "id") Character numReferencia, @RequestBody Caja caja) {

		Caja caja_seleccionada = new Caja();
		Caja caja_actualizada = new Caja();

		caja_seleccionada = cajaServiceImpl.cajaXID(numReferencia);

		caja_seleccionada.setContenido(caja.getContenido());
		caja_seleccionada.setValor(caja.getValor());
		caja_seleccionada.setAlmacen(caja.getAlmacen());

		caja_actualizada = cajaServiceImpl.actualizarCaja(caja_seleccionada);

		System.out.println("La caja actualizada es: " + caja_actualizada);

		return caja_actualizada;
	}

	@DeleteMapping("/cajas/{id}")
	public void eliminarCaja(@PathVariable(name = "id") Character numReferencia) {
		cajaServiceImpl.eliminarCaja(numReferencia);
	}
}
