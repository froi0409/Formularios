<%-- 
    Document   : mostrar-formulario
    Created on : 25/03/2021, 19:54:31
    Author     : froi-pc
--%>

<%@page import="com.froi.formulariosweb.entidadesfundamentales.Componente"%>
<%@page import="com.froi.formulariosweb.entidadesfundamentales.Formulario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Formulario formulario = (Formulario) request.getAttribute("formulario");
    request.getSession().setAttribute("formularioObjeto", formulario);
    String tema, letra;
    request.getSession().setAttribute("formularioUsario", formulario.getIdentificador());
    String usuario = (String) request.getAttribute("usuario");
    if(formulario.getTema().equals("Dark")) {
        tema = "#4F576A";
        letra = "#FFFFFF";
    } else {
        tema = "#FFFFFF";
        letra = "#000000";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <link href="estilos/forms.css" rel="stylesheet" type="text/css"/>
        <title>Formulario</title>
    </head>
    <body style="background-color:<% out.print(tema); %>; color: <% out.print(letra); %>">
        <div class="container-fluid">
            <div class="row fondoInicio align-items-center">

                <div class="col-3" align="left">
                    <%if(request.getSession().getAttribute("USER") != null) {%>
                        <form action="ExportarFormulario" method="POST"> 
                            <input type="submit" value="Exportar" class="btn btn-outline-light form"/>
                        </form>
                    <%}%>
                </div>
                <div class="col-6" align="center">
                    <h2>FORMULARIOS WEB</h2>
                </div>
                <div class="col-3" align="right">
                    &nbsp;&nbsp;
                    <%if(request.getSession().getAttribute("USER") != null) {%>
                        <a onclick="obtenerLink()" class="btn btn-outline-light form">Obtener Enlace</a>
                    <%}%>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test = "${mensaje != null}">
                <div class="alert alert-secondary container mt-5" align="center" role="alert">
                    ${mensaje}
                </div>
            </c:when>
        </c:choose>
        
        <div align="center" style="padding-top: 100px;">
            <h1><% out.print(formulario.getTitulo()); %></h1><br>
            <h4>Formulario perteneciente a: <% out.print(usuario); %></h4><br><br>
        </div>
        <form action="ObtenerDatos" method ="POST">
        <%
        for(Componente element : formulario.getListaComponentes()) {
            String alineacion;
            String requerido = "";
            if(element.getAlineacion().equals("CENTRO")) {
                alineacion = "center";
            } else if(element.getAlineacion().equals("IZQUIERDA")) {
                alineacion = "left";
            } else if(element.getAlineacion().equals("DERECHA")) {
                alineacion = "right";
            } else if(element.getAlineacion().equals("JUSTIFICAR")) {
                alineacion = "justify";
            } else {
                alineacion = "left";
            }
            if(element.getRequerido().equals("SI")){
                requerido = "required";
            }
        %>
            <div class="container formulario pt-2 px-4"> 
                <div class="justify-content-<% out.print(alineacion); %>  pt-1 mt-2 mr-1 px-4">
                    <%if(!element.getClase().equals("BOTON")) {%>
                    <div class="form-group" style="text-align:<% out.print(alineacion); %>;">
                        <h5><% out.print(element.getTextoVisible()); %></h5>
                    </div>
                    <%}%>
                    <div class="form-group" align="<% out.print(alineacion); %>">
                    <%
                        if(element.getClase().equals("COMBO")) {
                            //Manejo de boton
                            String[] opciones = element.getOpciones().split("\\|");
                            out.println("<br><select id=\"" + element.getId() + "\" name=\"" + element.getNombreCampo() + "\" class=\"form-select\" " + requerido + ">");
                            for(String op : opciones) {
                                out.println("<option value=\"" + op + "\">" + op + "</option>");
                            }
                            out.println("</select>");
                        } else if (element.getClase().equals("AREA_TEXTO")) {
                            out.println("<div class=\"form-floating\">");
                            out.println("<textarea id=\"" + element.getId() + "\" name=\"" + element.getNombreCampo() + "\" rows=\"" + element.getFilas() + "\" cols=\"" + element.getColumnas() + "\" " + requerido + "></textarea>");
                            out.println("</div>");
                        } else if(element.getClase().equals("CAMPO_TEXTO")) {
                            out.println("<input tyoe=\"text\" name=\"" + element.getNombreCampo() + "\" id=\"" + element.getId() + "\" " + requerido + "/>");
                        } else if(element.getClase().equals("CHECKBOX")) {
                            String[] opciones = element.getOpciones().split("\\|");
                            for(String op: opciones){
                                out.println("<input type=\"checkbox\" id=\"" + element.getId() + "\" name=\"" + element.getNombreCampo() + "\">" + op + "</input>");
                            }
                        } else if(element.getClase().equals("RADIO")) {
                            String[] opciones = element.getOpciones().split("\\|");
                            for(String op: opciones) {
                                out.println("<input type=\"radio\" id=\"" + element.getId() + "\" value=\"" + op + "\" name=\"" + element.getNombreCampo() + "\">" + op + "</input>");
                            }
                        } else if(element.getClase().equals("FICHERO")) {
                            out.println("<input type=\"file\" name=\"" + element.getNombreCampo() + "\"" + requerido + "/>");
                        } else if(element.getClase().equals("BOTON")) {
                            out.println("<input type=\"button\" value=\"" + element.getTextoVisible() + "\"/>");
                        } else if(element.getClase().equals("IMAGEN")) {
                            out.print("<input style=\"max-width: 500px; max-height: 500px\" type=\"image\" src=\"" + element.getUrl() + "\"/>");
                        }
                    %>
                    </div>
                </div>
            </div>
            <br><br>
        <%
        }
        %>
            <div class="container justify-content-center pt-2 px-4">
                <input type="submit" class="btn btn-info btn-block ingresar" value="Enviar Datos"/>
            </div><br><br><br><br>
        </form>
        <script src="estilos/funciones.js" type="text/javascript"></script>
        <%@include file = "scripts.html"%>
    </body>
</html>