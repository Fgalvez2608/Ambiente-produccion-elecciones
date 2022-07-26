
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ
 */
public class MdlCandidato {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlCandidato() {
        jdbc.CrearConexion();

    }
    
    
    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {

            String consulta = "UPDATE tbl_candidatos SET nombre = ?, ciudad_origen = ?, "
                    + " telefono = ?, correo = ?, partido_politico = ?, descripcion = ?,"
                    + "mensaje_campania= ?, propuestas = ? WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getCiudadOrigen());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getDescripcion());
            sentencia.setString(7, candidato.getMensajeCampania());
            sentencia.setString(8, candidato.getPropuestas());
            sentencia.setString(9, candidato.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Candidato Ha Sido Actualizado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Candidato No Ha Sido Actualizado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }       
            

    public ClsMensaje eliminarCandidato(String idCandidato) {

        ClsMensaje mensaje;

        try {

            String consulta = "DELETE FROM tbl_candidatos WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, idCandidato);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Candidato Ha Sido Eliminado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Candidato No Ha Sido Eliminado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {

            String consulta = "INSERT INTO tbl_candidatos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getCiudadOrigen());
            sentencia.setString(4, candidato.getTelefono());
            sentencia.setString(5, candidato.getCorreo());
            sentencia.setString(6, candidato.getPartidoPolitico());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getMensajeCampania());
            sentencia.setString(9, candidato.getPropuestas());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Candidato Ha Sido Agregado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Candidato No Ha Sido Agregado");
            }

            return mensaje;

        } catch (SQLException e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy Un Error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsCandidato> ObtenerCandidatos() {

        try {

            LinkedList<ClsCandidato> candidatos = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_candidatos";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String partidoPolitico = resultados.getString("partido_politico");
                String ciudadOrigen = resultados.getString("ciudad_origen");
                String descripcion = resultados.getString("descripcion");
                String propuestas = resultados.getString("propuestas");
                String mensajeCampania = resultados.getString("mensaje_campania");
                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");

                ClsCandidato candidato = new ClsCandidato(partidoPolitico, ciudadOrigen, descripcion, propuestas, mensajeCampania, numeroDocumento, nombre, telefono, correo);

                candidatos.add(candidato);
            }
            return candidatos;

        } catch (SQLException e) {
            return null;
        }

    }
}
