/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.manejadores;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import com.froi.formulariosweb.entidadesfundamentales.Componente;
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
@WebServlet(name = "ObtenerDatos", urlPatterns = {"/ObtenerDatos"})
public class ObtenerDatos extends HttpServlet {

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
        
    }

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
        String idFormulario = (String) request.getSession().getAttribute("formularioUsario");
        
        AnalizadorEntrada analizador = new AnalizadorEntrada(null, null);
        analizador.analisisDatosExistentes();
        for(Formulario element: analizador.getListaFormularios()) {
            if(element.getIdentificador().equals(idFormulario)) {
                for(Componente componente: element.getListaComponentes()) {
                    if(request.getParameter(componente.getNombreCampo()) != null) {
                        componente.getDatosRecopilados().add(request.getParameter(componente.getNombreCampo()));
                    } else if(!componente.getClase().equals("IMAGEN") || !componente.getClase().equals("BOTON")) {
                        componente.getDatosRecopilados().add("");
                    }
                }
            }
        }
        analizador.guardarFormularios();
        request.getSession().removeAttribute("formularioUsario");
        request.getRequestDispatcher("respuesta-final.jsp").forward(request, response);
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
