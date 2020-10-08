package Crud;

/**
 *
 * @author gabrielhs 
 */
public class FactoryDAO {

    /**
     *
     */
    public enum TypeDAO {
        EMPLEADO, DEPARTAMENTO
    };

    /**
     *
     * @param t
     * @return dao
     */
    public static IDAO create(TypeDAO t) {
        IDAO dao = null;
        switch (t) {
            case EMPLEADO:
                dao = new EmpleadoDAO();
                break;
            case DEPARTAMENTO:
                dao = new DepartamentoDAO();
                break;
        }
        return dao;
    }
}
