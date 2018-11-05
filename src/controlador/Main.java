package controlador;


import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOBitacoras;
import dao.DAOMisiones;
import dao.DAONave;
import dao.DAOTripulantes;
import modelo.Bitacoras;
import modelo.Misiones;
import modelo.Nave;
import modelo.Tripulantes;

public class Main {

	static Scanner sc;

	public static void main(String[] args) throws ParseException {

		try {
			sc = new Scanner(System.in);
			int opcion;

			do {
				menu();
				opcion = Integer.parseInt(sc.nextLine());
				if (opcion == 1) {
					DAOTripulantes dao = DAOTripulantes.getInstance();
					menuTripulante();
					opcion = Integer.parseInt(sc.nextLine());
					switch (opcion) {
					case 1:
						listarTripulantes(dao);
						break;
					case 2:
						buscarID(dao);
						break;
					case 3:
						nuevoTripulante(dao);
						break;
					case 4:
						actualizarTripulante(dao);
						break;
					case 5:
						eliminarTripulante(dao);
						break;
					}
				}
				if (opcion == 2) {
					DAONave dao = DAONave.getInstance();
					menuNave();
					opcion = Integer.parseInt(sc.nextLine());
					switch (opcion) {
					case 1:
						listarNave(dao);
						break;
					case 2:
						buscarID(dao);
						break;
					case 3:
						nuevaNave(dao);
						break;
					case 4:
						actualizarNave(dao);
						break;
					case 5:
						eliminarNave(dao);
						break;
					}
				}
				if (opcion == 3) {
					DAOMisiones dao = DAOMisiones.getInstance();
					menuMisiones();
					opcion = Integer.parseInt(sc.nextLine());
					switch (opcion) {
					case 1:
						listarMisiones(dao);
						break;
					case 2:
						buscarID(dao);
						break;
					case 3:
						nuevaMision(dao);
						break;
					case 4:
						actualizarMision(dao);
						break;
					case 5:
						eliminarMision(dao);
						break;
					}
				}
				if (opcion == 4) {
					DAOBitacoras dao = DAOBitacoras.getInstance();
					menuBitacoras();
					opcion = Integer.parseInt(sc.nextLine());
					switch (opcion) {
					case 1:
						listarBitacoras(dao);
						break;
					case 2:
						buscarID(dao);
						break;
					case 3:
						nuevoBitacoras(dao);
						break;
					case 4:
						actualizarBitacoras(dao);
						break;
					case 5:
						eliminarCuaderno(dao);
						break;
					}
				}
			} while (opcion != 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void menu() {
		System.out.println("===============================");
		System.out.println("SISTEMA DE GESTIÓN");
		System.out.println("===============================");
		System.out.println("1. Tripulantes");
		System.out.println("2. Nave");
		System.out.println("3. Misiones");
		System.out.println("4. Bitacoras");
		System.out.println("0. Salir");
	}

	public static void menuTripulante() {
		System.out.println("===============================");
		System.out.println("SISTEMA DE GESTIÓN DE TRIPULANTES");
		System.out.println("===============================");
		System.out.println("1. Listar todos los tripulantes");
		System.out.println("2. Listar un tripulante por su ID");
		System.out.println("3. Insertar un nuevo tripulante");
		System.out.println("4. Actualizar un tripulante");
		System.out.println("5. Eliminar un tripulante");
		System.out.println("0. Salir");
	}

	public static void menuNave() {
		System.out.println("===============================");
		System.out.println("SISTEMA DE GESTIÓN DE NAVES");
		System.out.println("===============================");
		System.out.println("1. Listar todas las naves");
		System.out.println("2. Listar una nave por su ID");
		System.out.println("3. Insertar un nueva nave");
		System.out.println("4. Actualizar una nave");
		System.out.println("5. Eliminar nave");
		System.out.println("0. Salir");
	}

	public static void menuBitacoras() {
		System.out.println("===============================");
		System.out.println("SISTEMA DE GESTIÓN DEL CUADERNO DE BITACORAS");
		System.out.println("===============================");
		System.out.println("1. Listar todos los cuadernos");
		System.out.println("2. Listar un cuaderno por su ID");
		System.out.println("3. Insertar un nuevo cuaderno");
		System.out.println("4. Actualizar un cuaderno");
		System.out.println("5. Eliminar un cuaderno");
		System.out.println("0. Salir");
	}

	public static void menuMisiones() {
		System.out.println("===============================");
		System.out.println("SISTEMA DE GESTIÓN DE MISIONES");
		System.out.println("===============================");
		System.out.println("1. Listar todas las misiones");
		System.out.println("2. Listar una mision por su ID");
		System.out.println("3. Insertar una nueva mision");
		System.out.println("4. Actualizar una mision");
		System.out.println("5. Eliminar una mision");
		System.out.println("0. Salir");
	}

	private static void listarTripulantes(DAOTripulantes dao) {
		ArrayList<Tripulantes> lista = null;
		try {
			lista = dao.listaTripulantes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (lista != null) {
			for (Tripulantes e : lista) {
				System.out.format("ID: %d, %s, %s, %d , %d, %s, %s, %d, %s, %d\n", e.getId(), e.getNombre(),
						e.getCargo(), e.getSexo(), e.getExperiencia(), e.getOrigen(), e.getRaza(), e.getEdad(),
						e.getFoto(), e.getNave());
			}
		} else
			System.out.println("No hay tripulantes registrados en la base de datos");
	}

	private static void listarNave(DAONave dao) {
		ArrayList<Nave> lista = null;
		try {
			lista = dao.listaNave();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (lista != null) {
			System.out.format(" %4s | %4s | %6s | %4s | %4s | %4s\n", "ID", "NOMBRE", "CAPITAN/A", "MATRICULA", "TIPO",
					"FOTO");
			for (Nave e : lista) {
				System.out.format(" %4s | %4s | %4s | %4s | %4s | %4s\n", e.getId(), e.getNombre(), e.getCapitan(),
						e.getMatricula(), e.getTipo(), e.getFoto());
			}
		} else
			System.out.println("No hay naves registradas en la base de datos");
	}

	private static void listarMisiones(DAOMisiones dao) {
		ArrayList<Misiones> lista = null;
		try {
			lista = dao.listaMisiones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (lista != null) {
			for (Misiones e : lista) {
				System.out.format("ID: %d, %s, %d, %s\n", e.getId(), e.getNombre(), e.getNave(), e.getDescripcion());
			}
		} else
			System.out.println("No hay misiones registrados en la base de datos");
	}

	private static void listarBitacoras(DAOBitacoras dao) {
		ArrayList<Bitacoras> lista = null;
		try {
			lista = dao.listaBitacoras();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (lista != null) {
			for (Bitacoras e : lista) {
				System.out.format("ID: %d, %d, %s, %s %n", e.getId(), e.getNave(), 
						e.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
						e.getAudio());
			}
		} else
			System.out.println("No hay cuadernos registrados en la base de datos");
	}

	private static void buscarID(DAOTripulantes dao) {
		System.out.println("Búsqueda de un tripulante");
		System.out.print("Introduzca el ID del tripulante: ");
		int id = Integer.parseInt(sc.nextLine());
		Tripulantes e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			System.out.format("ID: %d, %s, %s, %d , %d, %s, %s, %d, %s, %d\n", e.getId(), e.getNombre(), e.getCargo(),
					e.getSexo(), e.getExperiencia(), e.getOrigen(), e.getRaza(), e.getEdad(), e.getFoto(), e.getNave());
		} else {
			System.out.println("No existe ningún registro con ese ID");
		}
	}

	private static void buscarID(DAONave dao) {
		System.out.println("Búsqueda de una Nave");
		System.out.print("Introduzca el ID de la Nave: ");
		int id = Integer.parseInt(sc.nextLine());
		Nave e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			System.out.format("ID: %d, %s, %s, %s , %s, %s\n", e.getId(), e.getNombre(), e.getCapitan(),
					e.getMatricula(), e.getTipo(), e.getFoto());
		} else {
			System.out.println("No existe ningún registro con ese ID");
		}
	}

	private static void buscarID(DAOMisiones dao) {
		System.out.println("Búsqueda de una mision");
		System.out.print("Introduzca el ID de la mision: ");
		int id = Integer.parseInt(sc.nextLine());
		Misiones e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			System.out.format("ID: %d, %s, %d, %s\n", e.getId(), e.getNombre(), e.getNave(), e.getDescripcion());
		} else {
			System.out.println("No existe ningún registro con ese ID");
		}
	}

	private static void buscarID(DAOBitacoras dao) {
		System.out.println("Búsqueda de un cuaderno");
		System.out.print("Introduzca el ID del cuaderno: ");
		int id = Integer.parseInt(sc.nextLine());
		Bitacoras e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			System.out.format("ID: %d, %d, %s, %s %n", e.getId(), e.getNave(), 
					e.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
					e.getAudio());
		} else {
			System.out.println("No existe ningún registro con ese ID");
		}
	}

	private static void nuevoTripulante(DAOTripulantes dao) {
		System.out.println("Inserción de un nuevo tripulante");
		System.out.print("Introduzca el nombre del tripulante:(String) ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca el cargo del tripulante:(String) ");
		String cargo = sc.nextLine();
		System.out.print("Introduzca el sexo del tripulante:(int) ");
		Integer sexo = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el experiencia del tripulante:(int) ");
		Integer experiencia = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el origen del tripulante:(String) ");
		String origen = sc.nextLine();
		System.out.print("Introduzca el raza del tripulante:(String) ");
		String raza = sc.nextLine();
		System.out.print("Introduzca el edad del tripulante:(int) ");
		Integer edad = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el foto del tripulante:(String) ");
		String foto = sc.nextLine();
		System.out.print("Introduzca el nave del tripulante:(int) ");
		Integer nave = Integer.parseInt(sc.nextLine());

		Tripulantes tripu = new Tripulantes(nombre, cargo, sexo, experiencia, origen, raza, edad, foto, nave);
		try {
			dao.insert(tripu);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void nuevaNave(DAONave dao) {
		System.out.println("Inserción de una nueva nave");
		System.out.print("Introduzca el nombre de la nave:(String) ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca el capitan de la nave:(String) ");
		String capitan = sc.nextLine();
		System.out.print("Introduzca la matricula de la nave:(String) ");
		String matricula = sc.nextLine();
		System.out.print("Introduzca el tipo de la nave:(String) ");
		String tipo = sc.nextLine();
		System.out.print("Introduzca la foto de la nave:(String) ");
		String foto = sc.nextLine();

		Nave nave = new Nave(nombre, capitan, matricula, tipo, foto);
		try {
			dao.insert(nave);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void nuevaMision(DAOMisiones dao) {
		System.out.println("Inserción de una nueva mision");
		System.out.print("Introduzca el nombre de la mision:(String) ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca la nave  de la mision:(String) ");
		Integer nave = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca la mision:(String) ");
		String descripcion = sc.nextLine();

		Misiones mision = new Misiones(nombre, nave, descripcion);
		try {
			dao.insert(mision);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void nuevoBitacoras(DAOBitacoras dao) throws ParseException {
		System.out.println("Inserción de un nuevo cuaderno");
		System.out.print("Introduzca la nave del cuaderno:(Int) ");
		Integer nave = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca la fecha del cuaderno:(Date:dd/MM/yyyy) ");
		String strFecha = sc.nextLine();
		LocalDate fecha = LocalDate.parse(strFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Introduzca el audio:(String) ");
		String audio = sc.nextLine();

		Bitacoras cuaderno = new Bitacoras(nave, fecha, audio);
		try {
			dao.insert(cuaderno);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void actualizarTripulante(DAOTripulantes dao) {
		System.out.println("Actualización de un tripulante");
		System.out.print("Introduzca el ID del tripulante: ");
		int id = Integer.parseInt(sc.nextLine());
		Tripulantes e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			System.out.println("El tripulante a modificar no está registrado en la base de datos");
		} else {
			System.out.format("ID: %d, %s, %s, %d , %d, %s, %s, %d, %s, %d\n", e.getId(), e.getNombre(), e.getCargo(),
					e.getSexo(), e.getExperiencia(), e.getOrigen(), e.getRaza(), e.getEdad(), e.getFoto(), e.getNave());
			System.out.println("Inserción de un nuevo tripulante");
			System.out.print("Introduzca el nombre del tripulante:(String) ");
			String nombre = sc.nextLine();
			System.out.print("Introduzca el cargo del tripulante:(String) ");
			String cargo = sc.nextLine();
			System.out.print("Introduzca el sexo del tripulante:(int) ");
			Integer sexo = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca el experiencia del tripulante:(int) ");
			Integer experiencia = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca el origen del tripulante:(String) ");
			String origen = sc.nextLine();
			System.out.print("Introduzca el raza del tripulante:(String) ");
			String raza = sc.nextLine();
			System.out.print("Introduzca el edad del tripulante:(int) ");
			Integer edad = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca el foto del tripulante:(String) ");
			String foto = sc.nextLine();
			System.out.print("Introduzca el nave del tripulante:(int) ");
			Integer nave = Integer.parseInt(sc.nextLine());
			e.setNombre(nombre);
			e.setCargo(cargo);
			e.setSexo(sexo);
			e.setExperiencia(experiencia);
			e.setOrigen(origen);
			e.setRaza(raza);
			e.setEdad(edad);
			e.setFoto(foto);
			e.setNave(nave);
			try {
				dao.update(e);
				System.out.println("Registro actualizado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void actualizarNave(DAONave dao) {
		System.out.println("Actualización de una Nave");
		System.out.print("Introduzca el ID de la nave: ");
		int id = Integer.parseInt(sc.nextLine());
		Nave e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			System.out.println("La nave a modificar no está registrado en la base de datos");
		} else {
			System.out.format("ID: %d, %s, %s, %s , %s, %s\n", e.getId(), e.getNombre(), e.getCapitan(),
					e.getMatricula(), e.getTipo(), e.getFoto());
			System.out.println("Inserción de una nueva nave");
			System.out.print("Introduzca el nombre de la nave:(String) ");
			String nombre = sc.nextLine();
			System.out.print("Introduzca el capitan de la nave:(String) ");
			String capitan = sc.nextLine();
			System.out.print("Introduzca la matricula de la nave:(String) ");
			String matricula = sc.nextLine();
			System.out.print("Introduzca el tipo de la nave:(String) ");
			String tipo = sc.nextLine();
			System.out.print("Introduzca la foto de la nave:(String) ");
			String foto = sc.nextLine();
			e.setNombre(nombre);
			e.setCapitan(capitan);
			e.setMatricula(matricula);
			e.setTipo(tipo);
			e.setFoto(foto);
			try {
				dao.update(e);
				System.out.println("Registro actualizado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void actualizarMision(DAOMisiones dao) {
		System.out.println("Actualización de una Mision");
		System.out.print("Introduzca el ID de la Mision: ");
		int id = Integer.parseInt(sc.nextLine());
		Misiones e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			System.out.println("La Mision a modificar no está registrado en la base de datos");
		} else {
			System.out.format("ID: %d, %s, %d, %s\n", e.getId(), e.getNombre(), e.getNave(), e.getDescripcion());
			System.out.println("Inserción de una nueva mision");
			System.out.print("Introduzca el nombre de la mision:(String) ");
			String nombre = sc.nextLine();
			System.out.print("Introduzca la nave  de la mision:(String) ");
			Integer nave = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca la mision:(String) ");
			String descripcion = sc.nextLine();
			e.setNombre(nombre);
			e.setNave(nave);
			e.setDescripcion(descripcion);
			try {
				dao.update(e);
				System.out.println("Registro actualizado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void actualizarBitacoras(DAOBitacoras dao) throws ParseException {
		System.out.println("Actualización de un cuaderno");
		System.out.print("Introduzca el ID del cuaderno: ");
		int id = Integer.parseInt(sc.nextLine());
		Bitacoras e = null;
		try {
			e = dao.buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			System.out.println("La Mision a modificar no está registrado en la base de datos");
		} else {
			System.out.format("ID: %d, %d, %s, %s\n", e.getId(), e.getNave(), 
					e.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)), e.getAudio());
			System.out.println("Inserción de un nuevo cuaderno");
			System.out.print("Introduzca la nave del cuaderno:(Int) ");
			Integer nave = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca la fecha del cuaderno:(Date:dd/mm/yyyy) ");
			String strFecha = sc.nextLine();
			LocalDate fecha = LocalDate.parse(strFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Introduzca el audio:(String) ");
			String audio = sc.nextLine();
			e.setNave(nave);
			e.setFecha(fecha);
			e.setAudio(audio);
			try {
				dao.update(e);
				System.out.println("Registro actualizado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void eliminarTripulante(DAOTripulantes dao) {
		System.out.println("Borrado de un tripulante");
		System.out.print("Introduzca el ID del tripulante: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("¿Está usted seguro de eliminar dicho registro? (S/N)");
		String opcion = sc.nextLine();
		if (opcion.equalsIgnoreCase("S")) {
			try {
				dao.delete(id);
				System.out.println("Registro eliminado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void eliminarNave(DAONave dao) {
		System.out.println("Borrado de una nave");
		System.out.print("Introduzca el ID de la nave: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("¿Está usted seguro de eliminar dicho registro? (S/N)");
		String opcion = sc.nextLine();
		if (opcion.equalsIgnoreCase("S")) {
			try {
				dao.delete(id);
				System.out.println("Registro eliminado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void eliminarMision(DAOMisiones dao) {
		System.out.println("Borrado de una mision");
		System.out.print("Introduzca el ID de la mision: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("¿Está usted seguro de eliminar dicho registro? (S/N)");
		String opcion = sc.nextLine();
		if (opcion.equalsIgnoreCase("S")) {
			try {
				dao.delete(id);
				System.out.println("Registro eliminado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void eliminarCuaderno(DAOBitacoras dao) {
		System.out.println("Borrado de un cuaderno");
		System.out.print("Introduzca el ID del cuaderno: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("¿Está usted seguro de eliminar dicho registro? (S/N)");
		String opcion = sc.nextLine();
		if (opcion.equalsIgnoreCase("S")) {
			try {
				dao.delete(id);
				System.out.println("Registro eliminado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
