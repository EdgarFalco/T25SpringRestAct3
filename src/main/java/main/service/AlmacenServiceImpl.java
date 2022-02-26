package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IAlmacenDao;
import main.dto.Almacen;

@Service
public class AlmacenServiceImpl implements IAlmacenService {

	@Autowired
	IAlmacenDao iAlmacenDao;

	@Override
	public List<Almacen> listarAlmacen() {
		
		return iAlmacenDao.findAll();
	}
	
	@Override
	public Almacen almacenXID(Long id) {
		
		return iAlmacenDao.findById(id).get();
	}

	@Override
	public Almacen guardarAlmacen(Almacen almacen) {
		
		return iAlmacenDao.save(almacen);
	}

	@Override
	public Almacen actualizarAlmacen(Almacen almacen) {
		
		return iAlmacenDao.save(almacen);
	}

	@Override
	public void eliminarAlmacen(Long id) {
		
		iAlmacenDao.deleteById(id);
	}
}
