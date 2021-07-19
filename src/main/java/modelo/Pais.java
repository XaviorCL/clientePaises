package modelo;

public class Pais {
	
	private String nombre;
	private String capital;
	private int poblacion;
	private String bandera;
	
	public Pais(String nombre, String capital, int poblacion, String bandera) {
		
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.poblacion = poblacion;
		this.bandera = bandera;	
	}
	
	public Pais() {
		super();		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}	

}
