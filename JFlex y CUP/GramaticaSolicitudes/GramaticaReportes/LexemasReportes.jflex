import java_cup.runtime.*;
%%
%public
%class ReportesLexer
%cup
%unicode
%line
%column

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
IDENTIFICADOR = ("$" | "_" | "-") ( [a-zA-Z] | [0-9] | "$" | "_" | "-")*;
ALLCHARACTERSNOSPACE = [^' ' "," "\"" "|" "[" "]"]+
NUMEROCONSULTA = [-]?[0-9]+ ([.][0-9]+)?
CADENACONSULTA = ("\’" | "\'") ([^ "\"" "|"] | [ \t\f])* ("\’" | "\'")
%%
<YYINITIAL> {
    "SELECT"                { System.out.println("SELECT: " + yytext()); return new Symbol(SELECT, yyline, yycolumn, yytext()); }
    "TO"                    { System.out.println("TO: " + yytext()); return new Symbol(TO, yyline, yycolumn, yytext()); }
    "FORM"                  { System.out.println("FORM: " + yytext()); return new Symbol(FORM, yyline, yycolumn, yytext()); }
    "->"                    { System.out.println("FLECHA: " + yytext()); return new Symbol(FLECHA, yyline, yycolumn, yytext()); }
    "AND"                   { System.out.println("AND: " + yytext()); return new Symbol(AND, yyline, yycolumn, yytext()); }
    "OR"                    { System.out.println("OR: " + yytext()); return new Symbol(OR, yyline, yycolumn, yytext()); }
    "NOT"                   { System.out.println("NOT: " + yytext()); return new Symbol(NOT, yyline, yycolumn, yytext()); }
    "WHERE"                 { System.out.println("WHERE: " + yytext()); return new Symbol(WHERE, yyline, yycolumn, yytext()); }
    ","                     { System.out.println("COMA: " + yytext()); return new Symbol(COMA, yyline, yycolumn, yytext()); }
    "<"                     { System.out.println("MENOR_QUE: " + yytext()); return new Symbol(MENOR_QUE, yyline, yycolumn, yytext()); }
    ">"                     { System.out.println("MAYOR_QUE: " + yytext()); return new Symbol(MAYOR_QUE, yyline, yycolumn, yytext()); }
    "="                     { System.out.println("IGUAL: " + yytext()); return new Symbol(IGUAL, yyline, yycolumn, yytext()); }
    "<="                    { System.out.println("MENOR_IGUAL: " + yytext()); return new Symbol(MENOR_IGUAL, yyline, yycolumn, yytext()); }
    ">="                    { System.out.println("MAYOR_IGUAL: " + yytext()); return new Symbol(MAYOR_IGUAL, yyline, yycolumn, yytext()); }
    "<>"                    { System.out.println("DIFERENTE: " + yytext()); return new Symbol(DIFERENTE, yyline, yycolumn, yytext()); }
    "["                     { System.out.println("CORCHETE_A: " + yytext()); return new Symbol(CORCHETE_A, yyline, yycolumn, yytext()); }
    "]"                     { System.out.println("CORCHETE_C: " + yytext()); return new Symbol(CORCHETE_C, yyline, yycolumn, yytext()); }
    {NUMEROCONSULTA}        { System.out.println("NUMERO_CONSULTA: " + yytext()); return new Symbol(NUMERO_CONSULTA, yyline, yycolumn, yytext()); }
    {CADENACONSULTA}        { System.out.println("CADENA_CONSULTA: " + yytext()); return new Symbol(CADENA_CONSULTA, yyline, yycolumn, yytext()); }
    {IDENTIFICADOR}         { System.out.println("IDENTIFICADOR: " + yytext()); return new Symbol(IDENTIFICADOR, yyline, yycolumn, yytext()); }
    {Ignore}        {/* Ignorar */}
    {ALLCHARACTERSNOSPACE}  { System.out.println("ALLCHARNOSPACE: " + yytext()); return new Symbol(ALLCHARACTERSNOSPACE, yyline, yycolumn, yytext()); }
    
}

[^] {

}