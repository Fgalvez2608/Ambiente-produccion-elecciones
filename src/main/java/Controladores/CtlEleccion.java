package Controladores;

import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import Modelos.MdlEleccion;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ - ALEX ORJUELA - WILSON LOPEZ
 */
public class CtlEleccion {

    MdlEleccion modelo;

    public CtlEleccion() {
        this.modelo = new MdlEleccion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        return this.modelo.agregarEleccion(eleccion);
    }
    
    public ClsMensaje ActualizarEleccion(ClsEleccion eleccion) {

        return this.modelo.ActualizarEleccion(eleccion);
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {

        LinkedList<ClsEleccion> elecciones = this.modelo.ObtenerElecciones();
        return elecciones;
    }
    
    public ClsMensaje eliminarEleccion(String idEleccion) {

        return this.modelo.eliminarEleccion(idEleccion);
    }

}
