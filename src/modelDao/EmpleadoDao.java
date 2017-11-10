package modelDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Conexion;
import model.Empleado;

public class EmpleadoDao {
	private static final String SQL_INGRESAR=
            "INSERT INTO Empleado(Persona_perId,empSueldoBruto,created_at)"
            + " VALUES (?,?,?);";
	
	private static final Conexion cnn=Conexion.saberEstado();
	
	public boolean ingresar(Empleado e) {
	    	Date fechaActual = new Date(System.currentTimeMillis());
	    	SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
	    	SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
	        PreparedStatement ps;
	        int bandera;
	        try {
	            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
	            ps.setInt(1, e.getPerId());
	            ps.setInt(2, e.getEmpSueldoBruto());
	            ps.setString(3, dia.format(fechaActual)+" "+hora.format(fechaActual));
	            System.out.println(String.valueOf(ps));
	            bandera=ps.executeUpdate();
	            if(bandera > 0){
	                return true;
	            }
	        } catch (SQLException ex) {
	            System.out.println("Error al momento de Ingresar Empleado");
	        }finally{
	            cnn.cerrarConexion();
	        }
	        return false;
	    }
	
	
	
	
}
