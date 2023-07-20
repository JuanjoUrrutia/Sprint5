package modelo;

public class Contacto {
	private int id;
	private String nombre; 
	private String email;
	private String mensaje;
	
	public Contacto(int id, String nombre, String email, String mensaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.mensaje = mensaje;
	}
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
