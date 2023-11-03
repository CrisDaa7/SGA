/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import controlador.dao.RolDAO;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import modelo.Rol;

/**
 *
 * @author usuario
 */
public class Utilidades {
    
    public static void cargarRoles(JComboBox cbx){
        cbx.removeAllItems();
        ListaEnlazada<Rol> lista = new RolDAO().listar();
        
        for(int i = 0; i < lista.size() ; i++) {
            try {
                cbx.addItem(lista.get(i));
            } catch (EmptyException | PositionException ex) {
                System.out.println("Error");
            }
        }
    }
    
    public static void cargarCriterios(JComboBox cbx) {
        cbx.removeAllItems();
        
        cbx.addItem("Apellido");
        
    }
    
    public static void cargarFacultad(JComboBox cbx) {
        cbx.removeAllItems();
        
        cbx.addItem("Facultad Agropecuaria y de Recursos Naturales Renovables");
        cbx.addItem("Facultad de la Educación el Arte y la Comunicación");
        cbx.addItem("Facultad de la Energía, las Industrias y los Recursos Naturales no Renovables");
        cbx.addItem("Facultad Jurídica, Social y Administrativa");
        cbx.addItem("Facultad de la Salud Humana");
        
    }
    
    public static void cargarModalidad(JComboBox cbx) {
        cbx.removeAllItems();
        
        cbx.addItem("Presencial");
        cbx.addItem("Distancia");
        
    }
    
     public static void cargarCiclo(JComboBox cbx) {
        cbx.removeAllItems();
        
        cbx.addItem("1 ciclo");
        cbx.addItem("2 ciclo");
        cbx.addItem("3 ciclo");
        cbx.addItem("4 ciclo");
        cbx.addItem("5 ciclo");
        cbx.addItem("6 ciclo");
        cbx.addItem("7 ciclo");
        cbx.addItem("8 ciclo");
        cbx.addItem("9 ciclo");
        
    }
}
