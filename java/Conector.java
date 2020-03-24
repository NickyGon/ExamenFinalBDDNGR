package fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Conector {
 
//	Atributos de clase
	
	private static Connection con;
	private static Conector INSTANCE =null;
	
	// Constructor
	
	private Conector(){
		
	}
	 //crear instancia
	
	private synchronized static void crearInstancia(){
		if(INSTANCE == null){
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	// obtener instancia
	public static Conector getInstancia(){
	if (INSTANCE ==null){
		crearInstancia();
	} 
	return INSTANCE;
	}
		
	
	//crear conexion
	
	
	private static void crearConexion(){
		String host = "127.0.0.1";
		String user = "nicky";
		String password = "Hopeinthegalaxy";
		String dataBase = "fifa";
		try {
			// importando libreria de conexion
			Class.forName("com.mysql.jdbc.Driver");
			//Url de conexion
			String urlConexion = "jdbc:mysql://" + host +"/" 
			+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Al fin, ya era hora");
		}catch (Exception e){
			System.out.println("Error al conectar");
		}
	}
	
	public ArrayList<String> getCount() throws SQLException{
		ArrayList<String> Count=new ArrayList<String>();
		PreparedStatement ps =con.prepareStatement("select count(personal_details.player_id) as jugadores from personal_details inner join other_details on personal_details.player_id=other_details.player_id where personal_details.age>25 && other_details.club='FC Bayern Munich';");
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			Count.add(rs.getString("jugadores"));
		}
		rs.close();
		return Count;
	}
	
	public ArrayList<List<String>> getPorPaseCorto() throws SQLException{
		ArrayList<List<String>> listaJugadoryPase=new ArrayList<List<String>>();
		PreparedStatement ps =con.prepareStatement("select personal_details.player_name,player_stats.short_pass from personal_details inner join player_stats on personal_details.player_id=player_stats.player_id order by player_stats.short_pass desc;");
		ResultSet rs= ps.executeQuery();
		for (int i=0;i<2;i++){
			listaJugadoryPase.add(new ArrayList<String>());
		}
		while(rs.next()){
			for (int i=0;i<2;i++){
				if (i==0){
					 listaJugadoryPase.get(i).add(rs.getString("player_name"));
				} else {
					 listaJugadoryPase.get(i).add(rs.getString("short_pass"));
				}
			}
		}
		rs.close();
		return listaJugadoryPase;
	}

	public ArrayList<List<String>> getPorAceleracion() throws SQLException{
		ArrayList<List<String>> listaJugadorClubyAceleracion=new ArrayList<List<String>>();
		PreparedStatement ps =con.prepareStatement("select personal_details.player_name,other_details.club,player_stats.acceleration from personal_details inner join other_details on personal_details.player_id=other_details.player_id inner join player_stats on personal_details.player_id=player_stats.player_id where player_stats.acceleration>(select avg(acceleration) from player_stats) order by acceleration desc;");
		ResultSet rs= ps.executeQuery();
		for (int i=0;i<3;i++){
			listaJugadorClubyAceleracion.add(new ArrayList<String>());
		}
		while(rs.next()){
			for (int i=0;i<3;i++){
				if (i==0){
					 listaJugadorClubyAceleracion.get(i).add(rs.getString("player_name"));
				} else if (i==1){
					 listaJugadorClubyAceleracion.get(i).add(rs.getString("club"));
				} else {
					listaJugadorClubyAceleracion.get(i).add(rs.getString("acceleration"));
				}
			}
		}
		rs.close();
		return listaJugadorClubyAceleracion;
	}
	

}

