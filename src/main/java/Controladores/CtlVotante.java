package Controladores;

import Clases.ClsMensaje;
import Clases.ClsVotante;
import Modelos.MdlVotante;
import interfaces.interfaceCrud;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ - ALEX ORJUELA - WILSON LOPEZ
 */
public class CtlVotante implements interfaceCrud {

    MdlVotante modelo;

    public CtlVotante() {
        this.modelo = new MdlVotante();
    }

    public ClsMensaje eliminarVotante(String idVotante) {

        return this.modelo.eliminarVotante(idVotante);
    }

    public ClsMensaje ActualizarVotante(ClsVotante votante) {

        return this.modelo.ActualizarVotante(votante);
    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        return this.modelo.agregarVotante(votante);
    }

    public LinkedList<ClsVotante> ObtenerVotantes() {

        return this.modelo.ObtenerVotantes();
    }

    
    
    @Override
    public ClsMensaje agregar(Object objeto) {
        return this.modelo.agregarVotante((ClsVotante) objeto);
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
