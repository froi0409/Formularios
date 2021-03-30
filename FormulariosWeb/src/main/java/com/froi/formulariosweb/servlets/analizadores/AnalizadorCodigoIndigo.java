/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.analizadores;

import com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada;
import java.io.BufferedReader;
import java.io.File;
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
@WebServlet(name = "AnalizadorCodigoIndigo", urlPatterns = {"/AnalizadorCodigoIndigo"})
public class AnalizadorCodigoIndigo extends HttpServlet {

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
        System.out.println("\n\nUsuario en linea desde el Servlet: " + request.getHeader("userOnline"));
        BufferedReader reader = request.getReader();
        String comprobador;
        String codigoEntrada = "";
        while ((comprobador = reader.readLine()) != null) {
            codigoEntrada += comprobador + "\n";
            System.out.println(comprobador);
        }
        String codigo = new String(codigoEntrada.getBytes("ISO-8859-1"), "UTF-8");
        String userOnline = new String(request.getHeader("userOnline").getBytes("ISO-8859-1"), "UTF-8");
        AnalizadorEntrada analizadorEntrada = new AnalizadorEntrada(codigo, userOnline);
        String codigoRespuesta = analizadorEntrada.codificar();
        System.out.println(codigoRespuesta);
        
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
