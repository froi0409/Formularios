import java_cup.runtime.*;

%%

%public
%class SolicitudesLexer
%cup
%unicode
%line
%column

//Codigo añadido

//Definición de expresiones regulares específicas
INISOLICITUDES = [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
FINSOLICITUDES = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]
INISOLICITUD =  [iI][nN][iI][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
FINSOLICITUD = [fF][iI][nN][_][sS][oO][lL][iI][cC][iI][tT][uU][dD]
COMILLAS = [\"]
TEMA = (Dark | White)

TerminacionLinea = [\r|\n|\r\n]
Ignore = {TerminacionLinea} | [ \t\f]
%%

<YYINITIAL> {
    //Signos fundamentales
    "<"                     { return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "!"                     { return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    {COMILLAS}              { return new Symbol(COMILLAS, yyline+1, yycolumn+1, yytext()); }
    "["                     { return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    "$"                     { return new Symbol(DOLAR, yyline+1, yycolumn+1, yytext()); }
    "_"                     { return new Symbol(GUION_BAJO, yyline+1, yycolumn+1, yytext()); }
    "-"                     { return new Symbol(GUION, yyline+1, yycolumn+1, yytext()); }
    
    //Instrucciones
    {INISOLICITUDES}        { return new Symbol(INI_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUDES}        { return new Symbol(FIN_SOLICITUDES, yyline+1, yycolumn+1, yytext()); }
    {INISOLICITUD}          { return new Symbol(INI_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    {FINSOLICITUD}          { return new Symbol(FIN_SOLICITUD, yyline+1, yycolumn+1, yytext()); }
    "CREAR_USUARIO"         { return new Symbol(CREAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "CREDENCIALES_USUARIO"  { return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "USUARIO"               { return new Symbol(USUARIO, yyline+1, yycolumn+1, yytext()); }
    "PASSWORD"              { return new Symbol(PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "MODIFICAR_USUARIO"     { return new Symbol(MODIFICAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "USUARIO_ANTIGUO"       { return new Symbol(USUARIO_ANTIGUO, yyline+1, yycolumn+1, yytext()); }
    "USUARIO_NUEVO"         { return new Symbol(USUARIO_NUEVO, yyline+1, yycolumn+1, yytext()); }
    "NUEVO_PASSWORD"        { return new Symbol(NUEVO_PASSWORD, yyline+1, yycolumn+1, yytext()); }
    "FECHA_MODIFICACION"    { return new Symbol(FECHA_MODIFICACION, yyline+1, yycolumn+1, yytext()); }
    "ELIMINAR_USUARIO"      { return new Symbol(ELIMINAR_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "CREDENCIALES_USUARIO"  { return new Symbol(CREDENCIALES_USUARIO, yyline+1, yycolumn+1, yytext()); }
    "NUEVO_FORMULARIO"      { return new Symbol(NUEVO_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "ID"                    { return new Symbol(ID, yyline+1, yycolumn+1, yytext()); }
    "TITULO"                { return new Symbol(TITULO, yyline+1, yycolumn+1, yytext()); }
    "NOMBRE"                { return new Symbol(NOMBRE, yyline+1, yycolumn+1, yytext()); }
    "TEMA"                  { return new Symbol(TEMA, yyline+1, yycolumn+1, yytext()); }
    "USUARIO_CREACION"      { return new Symbol(USUARIO_CREACION, yyline+1, yycolumn+1, yytext()); }
    "FECHA_CREACION"        { return new Symbol(FECHA_CREACION, yyline+1, yycolumn+1, yytext()); }
    "ELIMINAR_FORMULARIO"   { return new Symbol(ELIMINAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "MODIFICAR_FORMULARIO"  { return new Symbol(MODIFICAR_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "PARAMETROS_FORMULARIO" { return new Symbol(PARAMETROS_FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "AGREGAR_COMPONENTE"    { return new Symbol(AGREGAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "PARAMETROS_COMPONENTE" { return new Symbol(PARAMETROS_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "NOMBRE_CAMPO"          { return new Symbol(NOMBRE_CAMPO, yyline+1, yycolumn+1, yytext()); }
    "FORMULARIO"            { return new Symbol(FORMULARIO, yyline+1, yycolumn+1, yytext()); }
    "CLASE"                 { return new Symbol(CLASE, yyline+1, yycolumn+1, yytext()); }
    "INDICE"                { return new Symbol(INDICE, yyline+1, yycolumn+1, yytext()); }
    "TEXTO_VISIBLE"         { return new Symbol(TEXTO_VISIBLE, yyline+1, yycolumn+1, yytext()); }
    "ALINEACION"            { return new Symbol(ALINEACION, yyline+1, yycolumn+1, yytext()); }
    "REQUERIDO"             { return new Symbol(REQUERIDO, yyline+1, yycolumn+1, yytext()); }
    "OPCIONES"              { return new Symbol(OPCIONES, yyline+1, yycolumn+1, yytext()); }
    "FILAS"                 { return new Symbol(FILAS, yyline+1, yycolumn+1, yytext()); }
    "COLUMNAS"              { return new Symbol(COLUMNAS, yyline+1, yycolumn+1, yytext()); }
    "URL"                   { return new Symbol(URL, yyline+1, yycolumn+1, yytext()); }
    "ELIMINAR_COMPONENTE"   { return new Symbol(ELIMINAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    "MODIFICAR_COMPONENTE"  { return new Symbol(MODIFICAR_COMPONENTE, yyline+1, yycolumn+1, yytext()); }
    //Componentes Solicitados
    "CAMPO_TEXTO"           { return new Symbol(CAMPO_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "AREA_TEXTO"            { return new Symbol(AREA_TEXTO, yyline+1, yycolumn+1, yytext()); }
    "CHECKBOX"              { return new Symbol(CHECKBOX, yyline+1, yycolumn+1, yytext()); }
    "RADIO"                 { return new Symbol(RADIO, yyline+1, yycolumn+1, yytext()); }
    "FICHERO"               { return new Symbol(FICHERO, yyline+1, yycolumn+1, yytext()); }
    "IMAGEN"                { return new Symbol(IMAGEN, yyline+1, yycolumn+1, yytext()); }
    "COMBO"                 { return new Symbol(COMBO, yyline+1, yycolumn+1, yytext()); }
    "BOTON"                 { return new Symbol(BOTON, yyline+1, yycolumn+1, yytext()); }
}

[^] {

}
