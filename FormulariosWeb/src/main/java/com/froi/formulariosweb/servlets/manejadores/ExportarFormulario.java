/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.formulariosweb.servlets.manejadores;

import com.froi.formulariosweb.entidadesfundamentales.Componente;
import com.froi.formulariosweb.entidadesfundamentales.Formulario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author froi-pc
 */
@WebServlet(name = "ExportarFormulario", urlPatterns = {"/ExportarFormulario"})
public class ExportarFormulario extends HttpServlet {

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
        try {
            Formulario formulario = (Formulario) request.getSession().getAttribute("formularioObjeto");
            String pathName = "Formulario" + formulario.getNombre() + ".form";
            String codigoFormulario = "";
           //Escribimos el código que el formulario tendrá
            codigoFormulario += "new.formulario (\n";
            codigoFormulario += "{\n";
            codigoFormulario += "\"ID_FORMULARIO\" : \"" + formulario.getIdentificador() + "\",\n";
            codigoFormulario += "\"TITULO\" : \"" + formulario.getTitulo() + "\",\n";
            codigoFormulario += "\"NOMBRE\" : \"" + formulario.getNombre() + "\",\n";
            codigoFormulario += "\"TEMA\" : \"" + formulario.getTema() + "\"";
            if(!formulario.getListaComponentes().isEmpty()) {
                codigoFormulario += ",\n";
                codigoFormulario += "\"ESTRUCTURA\" : (\n";
                int contCompo = 1;
                Collections.sort(formulario.getListaComponentes());
                for(Componente componente : formulario.getListaComponentes()) {
                    if(contCompo > 1) {
                        codigoFormulario +=  ",\n";
                    }
                    codigoFormulario += "{\n";
                    codigoFormulario += "\"ID_COMPONENTE_" + contCompo + "\" : \"" + componente.getId() + "\",\n";
                    codigoFormulario += "\"INDICE\" : \"" + componente.getIndice() + "\",\n";
                    codigoFormulario += "\"CLASE\" : \"" + componente.getClase() + "\",\n";
                    codigoFormulario += "\"TEXTO_VISIBLE\" : \"" + componente.getTextoVisible() + "\",\n";
                    codigoFormulario += "\"REQUERIDO\" : \"" + componente.getRequerido() + "\",\n";
                    codigoFormulario += "\"ALINEACION\" : \"" + componente.getAlineacion() + "\"";
                    if (componente.getClase().equals("AREA_TEXTO")) {
                        codigoFormulario += ",\n";
                        codigoFormulario += "\"FILAS\" : \"" + componente.getFilas() + "\",\n";
                        codigoFormulario += "\"COLUMNAS\" : \"" + componente.getColumnas() + "\"";
                    } else if (componente.getClase().equals("CHECKBOX") || componente.getClase().equals("RADIO") || componente.getClase().equals("COMBO")) {
                        codigoFormulario += ",\n";
                        codigoFormulario += "\"OPCIONES\" : \"" + componente.getOpciones() + "\"";
                    } else if(componente.getClase().equals("IMAGEN")) {
                        codigoFormulario += ",\n";
                        codigoFormulario += "\"URL\" : \"" + componente.getUrl() + "\"";
                    }
                    if (componente.getNombreCampo() != null) {
                        codigoFormulario += ",\n";
                        codigoFormulario += "\"NOMBRE_CAMPO\" : \"" + componente.getNombreCampo() + "\"\n";
                    }
                    codigoFormulario += "\n}\n";
                    contCompo++;
                }
                codigoFormulario += ")\n";
            }
            codigoFormulario += "}\n";
            codigoFormulario += ")\n";
            //Transformamos el String de codigo de formulario a un array de bytes
            byte[] cadenaPrueba = codigoFormulario.getBytes();
            response.setContentType("application/octet-stream");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + pathName);
            ServletOutputStream output = response.getOutputStream();
            output.write(cadenaPrueba);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Error en Expotacion: " + e.getMessage());
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
