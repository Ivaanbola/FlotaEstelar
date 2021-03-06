package modelo;

public class Tripulantes {
	private int id;
	private String nombre;
	private String cargo;
	private int sexo;
	private int experiencia;
	private String origen;
	private String raza;
	private int edad;
	private String foto;
	private int nave;

	public Tripulantes() {

	}

	public Tripulantes(int id, String nombre, String cargo, int sexo, int experiencia, String origen, String raza,
			int edad, String foto, int nave) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nave = nave;
	}

	public Tripulantes(String nombre, String cargo, int sexo, int experiencia, String origen, String raza, int edad,
			String foto, int nave) {
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nave = nave;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getNave() {
		return nave;
	}

	public void setNave(int nave) {
		this.nave = nave;
	}

}
