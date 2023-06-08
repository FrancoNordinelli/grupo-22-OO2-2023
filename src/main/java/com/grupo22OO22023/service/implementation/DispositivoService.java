package com.grupo22OO22023.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.models.DispositivoModel;
import com.grupo22OO22023.repositories.IDispositivoRepository;
import com.grupo22OO22023.service.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public DispositivoModel insertOrUpdate(DispositivoModel dispositivoModel) {
		Dispositivo dispositivo = dispositivoRepository.save(modelMapper.map(dispositivoModel, Dispositivo.class)); 
		return modelMapper.map(dispositivo, DispositivoModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			dispositivoRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public DispositivoModel searchById(int id) {
		return modelMapper.map(dispositivoRepository.findById(id), DispositivoModel.class);
	}
}
