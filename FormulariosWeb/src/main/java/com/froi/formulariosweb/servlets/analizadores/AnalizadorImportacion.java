/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.analizadores;

import com.froi.formulariosweb.analizadores.importacion.AnalizadorEntradaImportacion;
import java.io.BufferedReader;
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
@WebServlet(name = "AnalizadorImportacion", urlPatterns = {"/AnalizadorImportacion"})
public class AnalizadorImportacion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        BufferedReader reader = request.getReader();
        String comprobador;
        String codigoEntrada = "";
        String userOnline = request.getHeader("userOnline");
        while((comprobador = reader.readLine()) != null) {
            codigoEntrada += comprobador + "\n";
        }
        //linea que nos sirve para reconocer los caracteres especiales que no se reconocen a traves del canal HTTP
        String codigo = new String(codigoEntrada.getBytes("ISO-8859-1"), "UTF-8");
        AnalizadorEntradaImportacion analizadorEntrada = new AnalizadorEntradaImportacion(codigo, userOnline);
        String codigoRespuesta = analizadorEntrada.analizar();
        
        
        try(PrintWriter out = response.getWriter()) {
            out.print(codigoRespuesta);
        }
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
