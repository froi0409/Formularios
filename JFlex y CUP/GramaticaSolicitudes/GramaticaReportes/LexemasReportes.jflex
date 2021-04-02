package com.froi.formulariosweb.analizadores.codigoindigo;

import java_cup.runtime.*;
import com.froi.formulariosweb.entidades.Advertencia;
import java.util.ArrayList;
import static com.froi.formulariosweb.analizadores.codigoindigo.ParserReportesSym.*;

%%
%public
%class ReportesLexer
%cup
%unicode
%line
%column

%{
    private String cadenaLexica = "";
    private ArrayList<Advertencia> listaErrores;
    private int linea, columna;

    public ReportesLexer(java.io.Reader in, ArrayList<Advertencia> listaErrores, int linea, int columna) {
        this.zzReader = in;
        this.listaErrores = listaErrores;
    }

    public void agregarError(int line, int column) {
        if(cadenaLexica.length() > 0) {
            int columnaTotal = columna + (column - cadenaLexica.length());
            int filaTotal = line + linea;
            listaErrores.add(new Advertencia(cadenaLexica, filaTotal, columnaTotal, "Léxico", "Símbolo no reconocido por la gramatica de reporteria"));
            cadenaLexica = "";
        }
    }
%}

%eof{
    agregarError(yyline, yycolumn);
%eof}

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
IDENTIFICADOR = ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")*
ALLCHARACTERSNOSPACE = [^' ' "," "\"" "|" "[" "]" "<" ">" "=" \n \t]+
NUMEROCONSULTA = [-]?[0-9]+ ([.][0-9]+)?
CADENACONSULTA = ("\’" | "\'") ([^ "\"" "\'" "\’" "|"] | [ \t\f])* ("\’" | "\'")
%%
<YYINITIAL> {
    "SELECT"                { agregarError(yyline,yycolumn); return new Symbol(SELECT, yyline, yycolumn, yytext()); }
    "TO"                    { agregarError(yyline,yycolumn); return new Symbol(TO, yyline, yycolumn, yytext()); }
    "FORM"                  { agregarError(yyline,yycolumn); return new Symbol(FORM, yyline, yycolumn, yytext()); }
    "->"                    { agregarError(yyline,yycolumn); return new Symbol(FLECHA, yyline, yycolumn, yytext()); }
    "AND"                   { agregarError(yyline,yycolumn); return new Symbol(AND, yyline, yycolumn, yytext()); }
    "OR"                    { agregarError(yyline,yycolumn); return new Symbol(OR, yyline, yycolumn, yytext()); }
    "NOT"                   { agregarError(yyline,yycolumn); return new Symbol(NOT, yyline, yycolumn, yytext()); }
    "WHERE"                 { agregarError(yyline,yycolumn); return new Symbol(WHERE, yyline, yycolumn, yytext()); }
    ","                     { agregarError(yyline,yycolumn); return new Symbol(COMA, yyline, yycolumn, yytext()); }
    "<"                     { agregarError(yyline,yycolumn); return new Symbol(MENOR_QUE, yyline, yycolumn, yytext()); }
    ">"                     { agregarError(yyline,yycolumn); return new Symbol(MAYOR_QUE, yyline, yycolumn, yytext()); }
    "="                     { agregarError(yyline,yycolumn); return new Symbol(IGUAL, yyline, yycolumn, yytext()); }
    "<="                    { agregarError(yyline,yycolumn); return new Symbol(MENOR_IGUAL, yyline, yycolumn, yytext()); }
    ">="                    { agregarError(yyline,yycolumn); return new Symbol(MAYOR_IGUAL, yyline, yycolumn, yytext()); }
    "<>"                    { agregarError(yyline,yycolumn); return new Symbol(DIFERENTE, yyline, yycolumn, yytext()); }
    "["                     { agregarError(yyline,yycolumn); return new Symbol(CORCHETE_A, yyline, yycolumn, yytext()); }
    "]"                     { agregarError(yyline,yycolumn); return new Symbol(CORCHETE_C, yyline, yycolumn, yytext()); }
    {NUMEROCONSULTA}        { agregarError(yyline,yycolumn); return new Symbol(NUMERO_CONSULTA, yyline, yycolumn, yytext()); }
    {CADENACONSULTA}        { agregarError(yyline,yycolumn); return new Symbol(CADENA_CONSULTA, yyline, yycolumn, yytext()); }
    {IDENTIFICADOR}         { agregarError(yyline,yycolumn); return new Symbol(IDENTIFICADOR, yyline, yycolumn, yytext()); }
    {Ignore}                { agregarError(yyline,yycolumn); /* Ignorar */}
    {ALLCHARACTERSNOSPACE}  { agregarError(yyline,yycolumn); return new Symbol(ALLCHARACTERSNOSPACE, yyline, yycolumn, yytext()); }
    
}

[^] {

}