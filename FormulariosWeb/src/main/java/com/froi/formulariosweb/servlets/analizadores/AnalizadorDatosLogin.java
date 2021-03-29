/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.analizadores;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import com.froi.formulariosweb.entidadesfundamentales.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "AnalizadorDatosLogin", urlPatterns = {"/AnalizadorDatosLogin"})
public class AnalizadorDatosLogin extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuarioEntrada;
        String passwordEntrada;
        ArrayList<Usuario> listaUsuarios;
        usuarioEntrada = request.getParameter("usuario");
        passwordEntrada = request.getParameter("password");
        
        String usuario = new String(usuarioEntrada.getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(passwordEntrada.getBytes("ISO-8859-1"), "UTF-8");
        
        System.out.println("\n\nusuario");
        System.out.println(usuario);
        
        AnalizadorEntrada analizador = new AnalizadorEntrada(null);
        analizador.analisisDatosExistentes(); //Buscamos a los usuarios que hay en el sistema
        listaUsuarios = analizador.getListaUsuarios();
        
        //Verificamos si las credenciales ingresadas corresponden a un usuario en el sistema
        for(Usuario element : listaUsuarios) {
            if (element.getUsuario().equals(usuario) && element.getPassword().equals(password)) {
                request.getSession().setAttribute("USER", usuario);
                request.getRequestDispatcher("formularios-disponibles.jsp").forward(request, response);
            }
        }
        request.setAttribute("mensaje", "Usuario o contraseña incorrecta, favor de revisar sus datos.");
        request.getRequestDispatcher("inicio-sesion.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
