package com.froi.editorcodigoindigo.analizadorrespuesta;

import java_cup.runtime.*;
import static com.froi.editorcodigoindigo.analizadorrespuesta.ParserRespuestasSym.*;

%%

%public
%class RespuestasLexer
%cup
%unicode
%line
%column

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]

INIRESPUESTAS = [iI][nN][iI][_][rR][eE][sS][pP][uU][eE][sS][tT][aA][sS]
INIRESPUESTA = [iI][nN][iI][_][rR][eE][sS][pP][uU][eE][sS][tT][aA]
FINRESPUESTAS = [fF][iI][nN][_][rR][eE][sS][pP][uU][eE][sS][tT][aA][sS]
FINRESPUESTA = [fF][iI][nN][_][rR][eE][sS][pP][uU][eE][sS][tT][aA]
ALLCHARACTERS = [\42] ([\40-\41] | [\43-\255] | [^"\"" "|"])* [\42]
%%
<YYINITIAL> {

    //Signos fundamentales
    "<"                     { System.out.println("MENOR_QUE: " + yytext()); return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { System.out.println("MAYOR_QUE: " + yytext()); return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "!"                     { System.out.println("EXCLAMACION: " + yytext()); return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { System.out.println("PUNTOS: " + yytext()); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "["                     { System.out.println("CORCHETE_A: " + yytext()); return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { System.out.println("CORCHETE_C: " + yytext()); return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    "{"                     { System.out.println("LLAVE_A: " + yytext()); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                     { System.out.println("LLAVE_C: " + yytext()); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { System.out.println("COMA: " + yytext()); return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    
    //Instrucciones
    "\""{WS}*"ERROR_DETECTADO"{WS}*"\""                 { System.out.println("ERROR_DETECTADO: " + yytext()); return new Symbol(ERROR_DETECTADO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION"{WS}*"\""                     { System.out.println("DESCRIPCION: " + yytext()); return new Symbol(DESCRIPCION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCION_EJECUTADA"{WS}*"\""           { System.out.println("INSTRUCCION_EJECUTADA: " + yytext()); return new Symbol(INSTRUCCION_EJECUTADA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCIONES"{WS}*"\""                   { System.out.println("INSTRUCCIONES: " + yytext()); return new Symbol(INSTRUCCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TIPO"{WS}*"\""                            { System.out.println("TIPO: " + yytext()); return new Symbol(TIPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DETALLES"{WS}*"\""                        { System.out.println("DETALLES: " + yytext()); return new Symbol(DETALLES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION_ERROR"{WS}*"\""               { System.out.println("DESCRIPCION_ERROR: " + yytext()); return new Symbol(DESCRIPCION_ERROR, yyline+1, yycolumn+1, yytext()); }

    {INIRESPUESTA}          { System.out.println("INI_RESPUESTA: " + yytext()); return new Symbol(INI_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTA}          { System.out.println("FIN_RESPUESTA: " + yytext()); return new Symbol(FIN_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {INIRESPUESTAS}         { System.out.println("INI_RESPUESTAS: " + yytext()); return new Symbol(INI_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTAS}         { System.out.println("FIN_RESPUESTAS: " + yytext()); return new Symbol(FIN_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}         { System.out.println("ALLCHARACTERS: " + yytext()); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }

    {Ignore}                {/* Ignorar */}

}

[^] {
    System.out.println("Lexema no correspondiente al lenguaje; " + yytext());
}