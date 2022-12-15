package org.generation.italy.demo.serv;

import java.util.List;
import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.repo.IngredienteRepo;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepo ingredienteRepo;

	public void save(Ingrediente ingrediente) {
		ingredienteRepo.save(ingrediente);
	}
    
	public  Ingrediente findById(int id) {
		return ingredienteRepo.findById(id).get();
	}
	
	public List<Ingrediente> findAll(){
		return ingredienteRepo.findAll();	}

	public void delete(int id) {
		ingredienteRepo.deleteById(id);
	}

 
}
