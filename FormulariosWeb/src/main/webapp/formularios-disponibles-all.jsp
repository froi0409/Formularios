<%-- 
    Document   : formularios-disponibles-all
    Created on : 26/03/2021, 21:08:20
    Author     : froi-pc
--%>

<%@page import="com.froi.formulariosweb.entidadesfundamentales.Formulario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.froi.formulariosweb.analizadores.codigoindigo.AnalizadorEntrada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row fondoInicio align-items-center">

        <div class="col-3" align="left">
        </div>
        <div class="col-6" align="center">
            <h2>FORMULARIOS WEB</h2>
        </div>
        <div class="col-3" align="right">
            <form action="inicio-sesion.jsp" method="GET" class="form">
                <button type="submit" class="btn btn-outline-light form">Volver a Inicio</button>
            </form>
        </div>

    </div>
        
        <div align="center" style="padding-top: 100px;">
            <h1>Formularios Disponibles:</h1><br>
        </div>
        <div class="container" align="center" style="margin-top: 100px; margin-bottom: 50px;">
            <table class="table table-bordered">
                <thead>
                    <tr class="table-secondary">
                        <th scope="col">Propietario</th>
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
                    out.println("<tr>");
                    for(Formulario element: listaFormularios){
                        out.println("<td>" + element.getUsuarioCreacion() + "</td>");
                        out.println("<td>" + element.getIdentificador() + "</td>");
                        out.println("<td>" + element.getTitulo() + "</td>");
                        out.println("<td> <form method=\"GET\" action=\"RenderizarFormulario\" target=\"_blank\"><button type = \"submit\" class=\"btn btn-info\" value=\"" + element.getIdentificador() + "\" name=\"identificador\">Visualizar</button></td></form>");
                        out.println("</tr>");
                    }
                    %>
                </tbody>
            </table>

        </div>
        <%@include file = "scripts.html"%>
    </body>
</html>
