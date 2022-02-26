package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ICajaDao;
import main.dto.Caja;

@Service
public class CajaServiceImpl implements ICajaService {

	@Autowired
	ICajaDao iCajaDao;

	@Override
	public List<Caja> listarCaja() {
		
		return iCajaDao.findAll();
	}
	
	@Override
	public Caja cajaXID(Character id) {
		
		return iCajaDao.findById(id).get();
	}

	@Override
	public Caja guardarCaja(Caja caja) {
		
		return iCajaDao.save(caja);
	}

	@Override
	public Caja actualizarCaja(Caja caja) {
		
		return iCajaDao.save(caja);
	}

	@Override
	public void eliminarCaja(Character id) {
		
		iCajaDao.deleteById(id);
	}
}
