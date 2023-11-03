/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import modelo.Usuario;

/**
 *
 * @author Walter
 */
public class UsuarioDao extends AdaptadorDAO<Usuario>{
    
    private Usuario usuario;
 

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void guardar() throws IOException {
        usuario.setId(generateID());
        this.guardar(usuario);
    }

    public void modificar(Integer pos) throws EmptyException, PositionException, IOException {
        this.modificar(usuario, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
