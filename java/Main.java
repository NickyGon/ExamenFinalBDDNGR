package fifa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Conector instancia = Conector.getInstancia();
//	try {
//		System.out.println("Jugadores de mayor a menor pase corto");
//		System.out.println("-----------------------");
//		ArrayList<String> listCompanies = instancia.getPaciente();
//		for(String paciente:listCompanies){
//			System.out.println(paciente);
//		}
//		System.out.println("-----------------------");
//		System.out.println();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	try {
		System.out.println("------------------------------------");
		System.out.println("Jugadores de mayor a menor pase corto");
		System.out.println("------------------------------------");
		System.out.println("Nombre | Puntuacion Pase Corto");
		System.out.println("------------------------------------");
		ArrayList<List<String>> listJugadoryPase = instancia.getPorPaseCorto();
		int i=0;
		while (i<listJugadoryPase.get(0).size()){
			for (int j=0;j<listJugadoryPase.size();j++){
				System.out.print(listJugadoryPase.get(j).get(i) + " | ");
			}
			System.out.println();
			i++;
		}
		System.out.println();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		System.out.println("-----------------------");
		System.out.println("Cantidad de jugadores mayores a 25 y en el Bayern Munich");
		System.out.println("-----------------------");
		ArrayList<String> count = instancia.getCount();
		for(String Count:count){
			System.out.println(Count);
		}
		System.out.println("-----------------------");
		System.out.println();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	try {
		System.out.println("------------------------------------");
		System.out.println("Jugadores con aceleración mayor al promedio");
		System.out.println("------------------------------------");
		System.out.println("Nombre | Club | Puntuacion Aceleracion");
		System.out.println("------------------------------------");
		ArrayList<List<String>> listJugadorClubyAceleracion = instancia.getPorAceleracion();
		int i=0;
		while (i<listJugadorClubyAceleracion.get(0).size()){
			for (int j=0;j<listJugadorClubyAceleracion.size();j++){
				System.out.print(listJugadorClubyAceleracion.get(j).get(i) + " | ");
			}
			System.out.println();
			i++;
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
//a) Mostrar los nombres de jugadores on orden de mejor a peor para pases cortos(short_pass).
//b) Contar el numero de jugadores mayores a 25 años que juegan en FC Bayern Munich
//c) Obtener los nombres de los jugadores y el equipo que tienen su aceleracion por encima del promedio
	
	
	
	}

