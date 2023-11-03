/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EstudianteDao;
import controlador.dao.UsuarioDao;
import controlador.dao.RolDAO;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.EmptyException;
import controlador.ed.lista.exception.PositionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author Walter
 */
public class Control {

    private RolDAO rol;
    private UsuarioDao usuario;
    private EstudianteDao estudiante;

    public Control() {
        this.rol = new RolDAO();
        this.usuario = new UsuarioDao();
    }

    public RolDAO getRol() {
        return rol;
    }

    public void setRol(RolDAO rol) {
        this.rol = rol;
    }

    public UsuarioDao getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDao usuario) {
        this.usuario = usuario;
    }

   

    public ListaEnlazada<Usuario> listar() {
        return usuario.listar();
    }

    

 public void guardarEstudiante(String facultad, String modalidad, String ciclo, String expediente, String nivel) {
    if (estudiante != null) {
        estudiante.getEstudiante().setFacultad(facultad);
        estudiante.getEstudiante().setCiclo(ciclo);
        estudiante.getEstudiante().setModalidad(modalidad);
        estudiante.getEstudiante().setExpediente(expediente);
        estudiante.getEstudiante().setNivel(nivel);
        try {
            estudiante.guardar();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    } else {
        System.out.println("El objeto estudiante no está inicializado.");
    }
}


    public void guardarCuenta(String rol) {
        this.rol.getRol().setRol(rol);

        try {
            this.rol.guardarRol();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
    public void guardarUsuario(String nombre, String apellido,String cedula,String celular,String estado,String nacimiento,String correoPer,String correoIns, String rol) {

        try {

            usuario.getUsuario().setNombre(nombre);
            usuario.getUsuario().setApellido(apellido);
            usuario.getUsuario().setCedula(cedula);
            usuario.getUsuario().setCelular(celular);
            usuario.getUsuario().setEstado(estado);
            usuario.getUsuario().setNacimiento(nacimiento);
            usuario.getUsuario().setCorreoPer(correoPer);
            usuario.getUsuario().setCorreoIns(correoIns);
            usuario.getUsuario().setId_rol(this.rol.buscarRol(rol).getId());

            try {
                usuario.guardar();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        } catch (EmptyException | PositionException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListaEnlazada<Usuario> buscarPorRolBinaria(String apellido) {
        ListaEnlazada<Usuario> lista = usuario.listar();
        ListaEnlazada<Usuario> resultado = new ListaEnlazada<>();

        Usuario[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        int l = 0, r = arreglo.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arreglo[m].getApellido().equalsIgnoreCase(apellido)) {
                resultado.insertar(arreglo[m]);
                return resultado;
            } else if (arreglo[m].getApellido().compareToIgnoreCase(apellido) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        for (var a : arreglo) {
            System.out.println(a + " == " + apellido);
        }

        return resultado;
    }


    public ListaEnlazada<Usuario> busquedaPorApellidoLineal(String apellido) {
        ListaEnlazada<Usuario> lista = usuario.listar();
        ListaEnlazada<Usuario> resultado = new ListaEnlazada<>();

        Usuario[] arreglo = lista.toArray();

        quickSortApellido(arreglo, 0, arreglo.length - 1);

        for (Usuario pc : arreglo) {
            if (pc.getApellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                resultado.insertar(pc);
            }
        }

        return resultado;
    }

    private void swapApellido(Usuario[] arr, int i, int j) {
        Usuario temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partitionApellido(Usuario[] arr, int low, int high) {
        Usuario pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j].getApellido().compareToIgnoreCase(pivot.getApellido()) < 0) {
                i++;
                swapApellido(arr, i, j);
            }
        }
        swapApellido(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSortApellido(Usuario[] arr, int low, int high) {
        if (low < high) {

            int pi = partitionApellido(arr, low, high);

            quickSortApellido(arr, low, pi - 1);
            quickSortApellido(arr, pi + 1, high);
        }
    }

    

    



}
