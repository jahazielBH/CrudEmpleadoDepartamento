
package Crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielhs
 */
public class DepartamentoDAO implements IDAO<Departamento> {

    public DepartamentoDAO() {
    }
    
    ConexionDB con= ConexionDB.getInstance();
    ResultSet rs;
    Departamento depa= new Departamento();

    @Override
    public boolean ingresar(Departamento Pojo) {
            //       String sql="insert into persona (clave,nombre,direccion,telefono) values "
//                + "('" + pojo.getClave() + "','" + pojo.getNombre() + "','" + pojo.getDireccion() + "','" +
//                pojo.getTelefono() + "')"; 
//        con.execute(sql);
//        return true;
        
 String insert = "INSERT INTO departamentos (id,nombre) VALUES (?,?)";
        try {
            try (PreparedStatement sentencia = ConexionDB.getInstance().getConnection().prepareStatement(insert)) {
                Long id = Pojo.getId();
                String nombre = Pojo.getNombre();
                sentencia.setLong(1, id);
                sentencia.setString(2, nombre);
                sentencia.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Departamento Pojo) {
                //        String sql = "update persona set nombre= '" + pojo.getNombre()
//                + "',direccion= '" + pojo.getDireccion()
//                + "',telefono= '" + pojo.getTelefono()
//                + "' where clave = '" + pojo.getClave() + "'";
//        con.execute(sql);
//        return true;
  String update = "UPDATE departamentos SET nombre=? WHERE id=?";
        try {
            try (PreparedStatement sentencia = ConexionDB.getInstance().getConnection().prepareStatement(update)) {
                Long id = Pojo.getId();
                String nombre = Pojo.getNombre();
                sentencia.setString(1, nombre);
                sentencia.setLong(2, id);
                sentencia.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Long id) {
        //String sql = "DELETE FROM persona WHERE clave =" + "'" + pojo.getClave() + "'";
//con.execute(sql);
// return true;
   String delete = "DELETE FROM departamentos WHERE id=?";
        try {
            try (PreparedStatement sentencia = ConexionDB.getInstance().getConnection().prepareStatement(delete)) {
                sentencia.setLong(1, id);
                sentencia.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Departamento mostrarById(Long id) {
         ResultSet rs;
        String selectAll = "SELECT * FROM departamentos WHERE id =?";
        try {
            PreparedStatement sentencia = ConexionDB.getInstance().getConnection().prepareStatement(selectAll);
            sentencia.setLong(1, id);
            rs = sentencia.executeQuery();
            if (rs.next()) {
                Departamento p = new Departamento();
                p.setId(rs.getLong(1));
                p.setNombre(rs.getString(2));
                depa=p;
            }else{
                
                depa=null;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depa;
    }

    @Override
    public List<Departamento> mostrarAll() {
        ResultSet rs;
        String selectAll = "SELECT * FROM departamentos ORDER BY id";
        List<Departamento> listaPer = new ArrayList<>();
        try {
            PreparedStatement sentencia = ConexionDB.getInstance().getConnection().prepareStatement(selectAll);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                Departamento p = new Departamento();
                p.setId(rs.getLong(1));
                p.setNombre(rs.getString(2));

                listaPer.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPer;
    }
    
}
