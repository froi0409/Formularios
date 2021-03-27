<%-- 
    Document   : cabecera
    Created on : 25/03/2021, 18:24:13
    Author     : froi-pc
--%>

<!-- A�adimos la fila que ser� la cabecera de la p�gina -->
<div class="container-fluid">
    <div class="row fondoInicio align-items-center">

        <div class="col-3" align="left">
            <h4>Bienvenido <% out.print(request.getSession().getAttribute("USER")); %></h4>
        </div>
        <div class="col-6" align="center">
            <h2>FORMULARIOS WEB</h2>
        </div>
        <div class="col-3" align="right">
            &nbsp;&nbsp;
            <form action="CerrarSesion" method="POST" class="form">
                <button type="submit" class="btn btn-outline-light form">Cerrar Sesi�n</button>
            </form>
        </div>

    </div>
</div>