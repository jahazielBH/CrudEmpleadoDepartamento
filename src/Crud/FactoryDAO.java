
package Crud;

/**
 *
 * @author gabrielhs
 * @param 
 */
public class FactoryDAO  {
    public enum TypeDAO {EMPLEADO,DEPARTAMENTO};
    public static IDAO create (TypeDAO t){
        IDAO dao = null;
        switch (t){
            case EMPLEADO:
                dao=new EmpleadoDAO();
                break;
            case DEPARTAMENTO:
                dao=new DepartamentoDAO();
                break;
        }
        return dao;
    }
}
