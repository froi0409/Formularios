/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.manejadores;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "RenderizarFormulario", urlPatterns = {"/RenderizarFormulario"})
public class RenderizarFormulario extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuarioFormulario = request.getParameter("user");
        String idFormulario = request.getParameter("identificador");
        
        AnalizadorEntrada analizador = new AnalizadorEntrada(null);
        analizador.analisisDatosExistentes();;
        
        for(Formulario element : analizador.getListaFormularios()) {
            if(element.getIdentificador().equals(idFormulario)) {
                request.setAttribute("formulario", element);
                request.setAttribute("usuario", element.getUsuarioCreacion());
                System.out.println("\n\n\n\n\n\n");
                System.out.println(element.getUsuarioCreacion());
                request.getRequestDispatcher("mostrar-formulario.jsp").forward(request, response);
            }
        }
        request.setAttribute("mensaje", "El formulario no existe en el sistema.");
        request.getRequestDispatcher("mostrar-formulario.jsp").forward(request, response);
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
