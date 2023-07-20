package modelo;

public class Profesional {
	
	private String id;
	private String nombre;
	private String fecha;
	private String rut;
	private String titulo;
	private String fechaIngreso;
	
	public Profesional(String id, String nombre, String fecha, String rut, String titulo, String fechaIngreso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.rut = rut;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
