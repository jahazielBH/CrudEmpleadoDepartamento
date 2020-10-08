/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Crud.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gabrielhs
 */
public class test {
    
    public static void main(String[] args) {
        
     EmpDAOH dao = new EmpDAOH();
        Empleado empleado = new Empleado();
        empleado.setId(Long.valueOf(117));
        empleado.setNombre("pepe problemas");
        empleado.setDireccion("aaaa");
        empleado.setTelefono("6666");
        //dao.ingresar(empleado);
        //dao.actualizar(empleado);
        dao.eliminar(Long.valueOf(117));
        
            
            
       
    }
}
