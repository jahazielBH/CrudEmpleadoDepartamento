
package Crud;

import java.util.List;

/**
 *
 * @author gabrielhs
 */
public interface IDAO <T> {
    public boolean ingresar(T pojo);
    public boolean actualizar (T pojo);
    public boolean eliminar (Long id);
    public T mostrarById (Long id);
    public List<T> mostrarAll();
    
    
}
