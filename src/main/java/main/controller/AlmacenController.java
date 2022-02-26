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

import main.dto.Almacen;
import main.service.AlmacenServiceImpl;

@RestController
@RequestMapping("/api")
public class AlmacenController {

	@Autowired
	AlmacenServiceImpl almacenServiceImpl;

	@GetMapping("/almacenes")
	public List<Almacen> listarAlmacen() {
		return almacenServiceImpl.listarAlmacen();
	}
	
	@GetMapping("/almacenes/{id}")
	public Almacen almacenXID(@PathVariable(name = "id") Long codigo) {

		Almacen almacen_xid = new Almacen();

		almacen_xid = almacenServiceImpl.almacenXID(codigo);

		System.out.println("Almacen XID: " + almacen_xid);

		return almacen_xid;
	}

	@PostMapping("/almacenes")
	public Almacen salvarAlmacen(@RequestBody Almacen almacen) {

		return almacenServiceImpl.guardarAlmacen(almacen);
	}

	@PutMapping("/almacenes/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name = "id") Long codigo, @RequestBody Almacen almacen) {

		Almacen almacen_seleccionado = new Almacen();
		Almacen almacen_actualizado = new Almacen();

		almacen_seleccionado = almacenServiceImpl.almacenXID(codigo);

		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());

		almacen_actualizado = almacenServiceImpl.actualizarAlmacen(almacen_seleccionado);

		System.out.println("El almacen actualizado es: " + almacen_actualizado);

		return almacen_actualizado;
	}

	@DeleteMapping("/almacenes/{id}")
	public void eliminarAlmacen(@PathVariable(name = "id") Long codigo) {
		almacenServiceImpl.eliminarAlmacen(codigo);
	}
}