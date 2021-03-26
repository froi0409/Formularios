<%-- 
    Document   : formularios-disponibles
    Created on : 25/03/2021, 18:27:13
    Author     : froi-pc
--%>

<%@page import="com.froi.formulariosweb.entidadesfundamentales.Formulario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>Formularios Diponibles</title>
    </head>
    <body>
        <%@include file = "cabecera.jsp" %>

        <c:choose>
            <c:when test = "${mensaje != null}">
                <div class="alert alert-secondary container mt-5" align="center" role="alert">
                    ${mensaje}
                </div>
            </c:when>
        </c:choose>
        
        <div align="center" style="padding-top: 100px;">
            <h1>Formularios Propios:</h1><br>
        </div>
        <div class="container" align="center" style="margin-top: 100px; margin-bottom: 50px;">
            <table class="table table-bordered">
                <thead>
                    <tr class="table-secondary">
                        <th scope="col">Id</th>
                        <th scope="col">Titulo</th>
                        <th scope="col">Seleccionar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    AnalizadorEntrada analizador = new AnalizadorEntrada(null);
                    analizador.analisisDatosExistentes();
                    ArrayList<Formulario> listaFormularios = analizador.getListaFormularios();
                    String usuario = (String) request.getSession().getAttribute("USER");
                    out.println("<tr>");
                    for(Formulario element: listaFormularios){
                        if(element.getUsuarioCreacion().equals(usuario)) {
                            out.println("<td>" + element.getIdentificador() + "</td>");
                            out.println("<td>" + element.getTitulo() + "</td>");
                            out.println("<td> <form method=\"GET\" action=\"RenderizarFormulario?user=" + usuario + "\" target=\"_blank\"><button type = \"submit\" class=\"btn btn-info\" value=\"" + element.getIdentificador() + "\" name=\"identificador\">Visualizar</button></td></form>");
                        }
                    out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        
        
        <%@include file = "scripts.html"%>
    </body>
</html>