package modelo;

public class Administrativo {
	
	private String id;
	private String nombre;
	private String fecha;
	private String rut;
	private String area;
	private String experienciaPrevia;
	
	
	public Administrativo(String id, String nombre, String fecha, String rut, String area, String experienciaPrevia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.rut = rut;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
	
	
}
