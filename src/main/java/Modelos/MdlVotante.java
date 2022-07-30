
package Modelos;

import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import interfaces.interfaceCrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ - ALEX ORJUELA - WILSON LOPEZ
 */
public class MdlVotante implements interfaceCrud {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlVotante() {
        jdbc.CrearConexion();

    }
    
    public ClsMensaje ActualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {

            String consulta = "UPDATE tbl_votantes SET nombre = ?, telefono = ?,"
                    + "correo = ?, ciudad_residencia = ? WHERE id_votante = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getTelefono());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getCiudadResidencia());
            sentencia.setString(5, votante.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Votante Ha Sido Actualizado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El votante No Ha Sido Actualizado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }
    
    public ClsMensaje eliminarVotante(String idVotante) {

        ClsMensaje mensaje;

        try {

            String consulta = "DELETE FROM tbl_votantes WHERE id_votante = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, idVotante);
            

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Votante Ha Sido Eliminado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El votante No Ha Sido Eliminado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }


    public ClsMensaje agregarVotante(ClsVotante votante) {
        
        ClsMensaje mensaje;

        try {

            String consulta = "INSERT INTO tbl_votantes VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getCiudadResidencia());
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Votante Ha Sido Agregado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Votante No Ha Sido Agregado");
            }
            
            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsVotante> ObtenerVotantes() {

        try {

            LinkedList<ClsVotante> votantes = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_votantes";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String ciudadResidencia = resultados.getString("ciudad_residencia");

                ClsVotante votante = new ClsVotante(ciudadResidencia, numeroDocumento, nombre, telefono, correo);

                votantes.add(votante);
            }
            return votantes;

        } catch (SQLException e) {
            return null;
        }

    }

    
    // metodos abstractos de la interfaz
    
    
    
    
    @Override
    public ClsMensaje agregar(Object objeto) {
        
        ClsVotante votante = (ClsVotante) objeto;
        ClsMensaje mensaje;

        try {

            String consulta = "INSERT INTO tbl_votantes VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getCiudadResidencia());
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Votante Ha Sido Agregado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Votante No Ha Sido Agregado");
            }
            
            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }
        
        
        
    }

    @Override
    public ClsMensaje actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClsMensaje eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<Object> obtener(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
