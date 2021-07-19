package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import modelo.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {	
	String url= "https://restcountries.eu/rest/v2/all";	
	@Autowired
	RestTemplate template;	
	@Override
	public List<Pais> obtenerPaises() {
		String resultado = template.getForObject(url, String.class); 
		//.getForObject(url, String.class);
		ObjectMapper maper = new ObjectMapper();
		List<Pais> paises = new ArrayList<>();
		ArrayNode array;
		
		try {
			//Obtenemos el objeto Json y extraemos las properties que nos interesan
			array = (ArrayNode) maper.readTree(resultado);
			for (Object ob:array) {			
				ObjectNode json = (ObjectNode) ob;
				paises.add(new Pais(
						json.get("name").asText(),
						json.get("capital").asText(),
						json.get("population").asInt(),
						json.get("flag").asText()));			
			}
		}catch (JsonProcessingException e){
			e.printStackTrace();
		}
		
		return paises;
	}

	@Override
	public List<Pais> buscarPaises(String name) {
		return obtenerPaises()
				.stream()
				.filter(p-> p.getNombre().contains(name))
				.collect(Collectors.toList());
	}

}
