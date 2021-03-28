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
    "<"                     { System.out.println("MENOR_QUE: "); return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext()); }
    ">"                     { System.out.println("MAYOR_QUE: "); return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext()); }
    "!"                     { System.out.println("EXCLAMACION: "); return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext()); }
    ":"                     { System.out.println("PUNTOS: "); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext()); }
    "["                     { System.out.println("CORCHETE_A: "); return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext()); }
    "]"                     { System.out.println("CORCHETE_C: "); return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext()); }
    "{"                     { System.out.println("LLAVE_A: "); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext()); }
    "}"                     { System.out.println("LLAVE_C: "); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext()); }
    ","                     { System.out.println("COMA: "); return new Symbol(COMA, yyline+1, yycolumn+1, yytext()); }
    
    //Instrucciones
    "\""{WS}*"ERROR_DETECTADO"{WS}*"\""                 { System.out.println("ERROR_DETECTADO: "); return new Symbol(ERROR_DETECTADO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION"{WS}*"\""                     { System.out.println("DESCRIPCION: "); return new Symbol(DESCRIPCION, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCION_EJECUTADA"{WS}*"\""           { System.out.println("INSTRUCCION_EJECUTADA: "); return new Symbol(INSTRUCCION_EJECUTADA, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"INSTRUCCIONES"{WS}*"\""                   { System.out.println("INSTRUCCIONES: "); return new Symbol(INSTRUCCIONES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"TIPO"{WS}*"\""                            { System.out.println("TIPO: "); return new Symbol(TIPO, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DETALLES"{WS}*"\""                        { System.out.println("DETALLES: "); return new Symbol(DETALLES, yyline+1, yycolumn+1, yytext()); }
    "\""{WS}*"DESCRIPCION_ERROR"{WS}*"\""               { System.out.println("DESCRIPCION_ERROR: "); return new Symbol(DESCRIPCION_ERROR, yyline+1, yycolumn+1, yytext()); }

    {INIRESPUESTA}          { System.out.println("INI_RESPUESTA: "); return new Symbol(INI_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTA}          { System.out.println("FIN_RESPUESTA: "); return new Symbol(FIN_RESPUESTA, yyline+1, yycolumn+1, yytext()); }
    {INIRESPUESTAS}         { System.out.println("INI_RESPUESTAS: "); return new Symbol(INI_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {FINRESPUESTAS}         { System.out.println("FIN_RESPUESTAS: "); return new Symbol(FIN_RESPUESTAS, yyline+1, yycolumn+1, yytext()); }
    {ALLCHARACTERS}         { System.out.println("ALLCHARACTERS: "); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext()); }

    {Ignore}                {/* Ignorar */}

}

[^] {
    System.out.println("Lexema no correspondiente al lenguaje; " + yytext());
}