package com.grupo22OO22023.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SHEvento;

import com.grupo22OO22023.models.SHEventoModel;

import com.grupo22OO22023.repositories.ISHEventoRepository;
import com.grupo22OO22023.services.ISHEventoService;

@Service("SHEvento")
public class SHEventoService implements ISHEventoService {
	
	private ModelMapper mp = new ModelMapper();
	
	@Autowired
	@Qualifier("shEventoRepository")
	private ISHEventoRepository shEventoRepository;

	@Override
	public SHEventoModel insertOrUpdate(SHEventoModel shEventoModel) {
		SHEvento sh = shEventoRepository.save(mp.map(shEventoModel, SHEvento.class));
		
		return mp.map(sh, SHEventoModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			shEventoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public SHEventoModel findByidEvento(int id) {
		return mp.map(shEventoRepository.findById(id), SHEventoModel.class);
	}

	/*@Override
	public List<SPEventoModel> findByDispositivo(int idDispositivo){
		return spEventoRepository.findByDispositivo(idDispositivo).stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());	
	}*/
	@Override
	public List<SHEventoModel> buscarPorIdDispositivo(int id) {
		return shEventoRepository.findByDispositivo(id).stream().map(evento -> mp.map(evento, SHEventoModel.class)).collect(Collectors.toList());
	}

	

	

}
