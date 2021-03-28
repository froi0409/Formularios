<%-- 
    Document   : respuesta-final
    Created on : 26/03/2021, 21:21:50
    Author     : froi-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "links.html"%>
        <link href="estilos/forms.css" rel="stylesheet" type="text/css"/>
        <title>Respuesta Registrada</title>
    </head>
    <body style="color: #000000;">
        <div class="row fondoInicio align-items-center">

            <div class="col-3" align="left">
            </div>
            <div class="col-6" align="center">
                <h2>FORMULARIOS WEB</h2>
            </div>
            <div class="col-3" align="right">
            </div>
         </div>
        <div class="container"> 
            <div class="row justify-content-center pt-5 mt-5 mr-1"> <!-- Utilizamos el sistema de filas de bootstrap -->
                <div class="col-md-6 formulario">
                    <div class="form-group text-center pt-3">
                        <h1>Respuesta Registrada</h1>
                    </div>
                    <div class="form-froup mx-sm-5 pt3">
                        <h4>Su respuesta fue registrada con éxito, puede cerrar esta pestaña</h4>
                    </div>
                </div>
            </div>
        </div>
        
    <%@include file = "scripts.html"%>
    </body>
</html>
