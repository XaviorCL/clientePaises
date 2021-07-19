package service;

import modelo.Pais;
import java.util.List;


public interface PaisesService {

	List<Pais> obtenerPaises();
	List<Pais> buscarPaises(String name);
	
}
