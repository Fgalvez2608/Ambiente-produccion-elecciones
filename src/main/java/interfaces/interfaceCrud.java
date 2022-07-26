
package interfaces;

import Clases.ClsMensaje;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ
 */
public interface interfaceCrud {

    public ClsMensaje agregar(Object objeto);

    public ClsMensaje actualizar(Object objeto);

    public ClsMensaje eliminar(String id);

    public LinkedList<Object> obtener(String id);

}
