/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Rol;

/**
 *
 * @author Walter
 */
public class RolDAO extends AdaptadorDAO<Rol>{
    private Rol rol;
    
    public RolDAO(){
        super(Rol.class);
    }
    
    public void guardarRol() throws IOException{
        rol.setId(generarId());
        
        guardar(rol);
        
        rol = null;
    }
    
    public Rol buscarRol(String rol) throws EmptyException, PositionException{
        ListaEnlazada<Rol> lista = listar();
        
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getRol().equalsIgnoreCase(rol)) {
                return lista.get(i);
            }
        }
        
        return null;
    }
    
    public Rol buscarRol(int rol) throws EmptyException, PositionException{
        ListaEnlazada<Rol> lista = listar();
        
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == rol) {
                return lista.get(i);
            }
        }
        
        return null;
    }
    
    public Rol getRol() {
        if(rol == null){
            rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
