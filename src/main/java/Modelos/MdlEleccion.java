package Modelos;

import Clases.ClsEleccion;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ - ALEX ORJUELA - WILSON LOPEZ
 */
public class MdlEleccion {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlEleccion() {

        jdbc.CrearConexion();

    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {

            String consulta = "INSERT INTO tbl_elecciones VALUES (?, ?, ?, ?, ?, ?, null)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, eleccion.getIdEleccion());
            sentencia.setString(2, eleccion.getDescripcion());
            sentencia.setString(3, eleccion.getTipo());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());
            sentencia.setString(6, eleccion.getEstado());
            ;

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La Eleccion Ha Sido Agregada");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La Eleccion No Ha Sido Agregada");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }
    
    
    public ClsMensaje eliminarEleccion(String idEleccion) {

        ClsMensaje mensaje;

        try {

            String consulta = "DELETE FROM tbl_elecciones WHERE id_eleccion = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La Eleccion Ha Sido Eliminada");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La Eleccion No Ha Sido Eliminada");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }
    
    
            
    public ClsMensaje ActualizarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {

            String consulta = "UPDATE tbl_elecciones SET descripcion = ?,"
                    + "tipo = ?, fecha_inicio = ?, fecha_fin = ?, estado = ?, ganador = ? WHERE id_eleccion = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, eleccion.getDescripcion());
            sentencia.setString(2, eleccion.getTipo());
            sentencia.setString(3, eleccion.getFechaInicio());
            sentencia.setString(4, eleccion.getFechaFin());
            sentencia.setString(5, eleccion.getEstado());
            sentencia.setString(6, eleccion.getGanador());
            sentencia.setString(7, eleccion.getIdEleccion());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La Eleccion Ha Sido Actualizada");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La Eleccion No Ha Sido Actualizada");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {

        try {

            LinkedList<ClsEleccion> elecciones = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_elecciones";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idEleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String tipo = resultados.getString("tipo");
                String fechaInicio = resultados.getString("fecha_inicio");
                String fechaFin = resultados.getString("fecha_fin");
                String estado = resultados.getString("estado");
                String ganador = resultados.getString("ganador");

                ClsEleccion eleccion = new ClsEleccion(idEleccion, descripcion, tipo,
                        fechaInicio, fechaFin, estado);

                elecciones.add(eleccion);
            }
            return elecciones;

        } catch (SQLException e) {
            return null;
        }

    }

}
