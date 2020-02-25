/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.util.regex.Pattern.matches;

/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public final class Validation {
    
    /**Este método permite determinar si una string de caracteres cualesquiera está
     * conformada unicamente por carácteres alfabeticos, los caracteres alfabeticos válidos son:
     * - Letras mayúsculas [A-Z]
     * - Letras minúsculas [a-z]
     * - Caracteres especiales como:
     *      - Vocales con acentuación
     *      - Espacio en blanco
     *      - Los caracteres ñ, Ñ
     * @param string contiene la string de caracteres que se desea evaluar
     * @return true si el parámetro de entrada satisface las reglas validadas
     *         false en cualquier otro caso
     */
    private static boolean isStringName(String string)
    {
        boolean flag = true;//se asume que la string es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index)< 65 || string.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (string.charAt(index)< 97 || string.charAt(index) > 122) &&//letras minúsculas 
               (string.charAt(index) != 'ñ' && string.charAt(index) != 'Ñ' && //la ñ Ñ se considera caracter especial
                string.charAt(index) != 'á' && string.charAt(index) != 'é' &&
                string.charAt(index) != 'í' && string.charAt(index) != 'ó' &&    
                string.charAt(index) != 'ú' &&//validar las vocales con tílde   
                string.charAt(index) != '.' &&//el punto debe ser permitido                    
                string.charAt(index) != ' ')){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = string.length()+1;//cuando se encuentra un carácter inválido se debe finalizar el bucle
            }//end if 
        }//end for index 
        return flag;
    }//end isString
    
    /**
     * Evalúa si los valores contenidos en el parámetro son solo digitos
     * La expresión regular evalúa existencia de al menos una valor numérico
     * @param id valor que se desea verificar
     * @return true si id contiene solo digitos
     *         false en cualquier otro caso
     */
    private static boolean isDigit(String id)
    {    
        return matches("[0-9]+",id);
    }
    
    private static boolean isValue(String string)
    {    
        boolean flag = true;//se asume que la string es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index) < 47 || string.charAt(index) > 57) && //acepta números
               string.charAt(index) == '.'){
                flag = false;//como no cumple la regla el retorno se cambia a false
                index = string.length()+1;//cuando se encuentra un carácter inválido se debe finalizar el bucle
            }    
        }
        return flag;
    }
    
    private boolean isStringAlphaNumeric(String string){
        boolean flag = true;//se asume que la string es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index) < 47 || string.charAt(index) > 57) && //acepta números
              ((string.charAt(index)< 65 || string.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (string.charAt(index)< 97 || string.charAt(index) > 122) &&//letras minúsculas
               (string.charAt(index) != 'ñ' && string.charAt(index) != 'Ñ' && //la ñ Ñ se considera caracter especial
                string.charAt(index) != 'á' && string.charAt(index) != 'é' &&
                string.charAt(index) != 'í' && string.charAt(index) != 'ó' &&     
                string.charAt(index) != 'ú' &&//validar las vocales con tílde     
                string.charAt(index) != '.' &&//el punto debe ser permitido                    
                string.charAt(index) != ' '))){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = string.length()+1;//cuando se encuentra un carácter inválido se debe finalizar el bucle
            }//end if 
        }//end for index  
        return flag; 
    }
   
    /**
     * este metodo debe validar la expresion ingresada como ley de inferencia
     * https://regexper.com/ para evaluar las expresiones regulares 
     */
    private static boolean isSintaxisInferenceLaw(String stringLaw) {                
        return matches(("((^~?[PQRST])(((->|v|\\^)(~?[PQRST]))?))((,((~?[PQRST])(((->|v|\\^)(~?[PQRST]))?))){0,2})(:((~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)))"),stringLaw)||
               matches("(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(,(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?))(:(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?))",stringLaw);
    }
    
    private static boolean isSintaxisPremise(String stringLaw) {
        return matches(("((^~?[PQRST])(((->|v|\\^)(~?[PQRST]))?))"),stringLaw);
    } 
    
    /**-----------------------------BEGIN--------------------------------------
     * Methods for evalue the sintaxis of regular expresions used for define 
     * inference laws
     -----------------------------------------------------------------------
     * All methods contains in this block are composed by:
     * @param stringLaw contains the string that represents the regular expression 
     * @return true if matches, false in other cases*/
    
    private static boolean isSintaxisMPP(String stringLaw) {
        return matches(("(^~?[PQRST])((->)(~?[PQRST]))(,)(~?[PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisMTT(String stringLaw) {
        return matches(("(^~?[PQRST])((->)(~?[PQRST]))(,)(~?[PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisMTP(String stringLaw) {
        return matches(("(^[PQRST])((v)([PQRST]))(,)(~[PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisLA(String stringLaw) {
        return matches(("(^~?[PQRST])(,)(~?[PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisLS(String stringLaw) {
        return matches(("^[PQRST](\\^)([PQRST])"),stringLaw);
    }
    private static boolean isSintaxisLC(String stringLaw) {
        return matches(("(^~[PQRST])(,)(([PQRST])(v)([PQRST]))"),stringLaw);
    }
    
    private static boolean isSintaxisConm(String stringLaw) {
        return matches(("^[PQRST](v)([PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisLDS(String stringLaw) {
        return matches(("^[PQRST](v)([PQRST])"),stringLaw);
    }
    
    private static boolean isSintaxisSH(String stringLaw) {
        return matches("(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(,(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?))(:(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?)(->|v|\\^)(\\(?(~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)\\)?))",stringLaw);
    }
    
    private static boolean isSintaxisDC(String stringLaw) {
        return matches(("(^~?[PQRST])((->)(~?[PQRST]))(,)(^~?[PQRST])((->)(~?[PQRST]))(,)(^~?[PQRST])((v)(~?[PQRST]))"),stringLaw);
    }
    //------------------------------END-------------------------------------
    /** 
     * @param stringLaw-
     * @return */
    public static boolean verifyInferenceLaw(String stringLaw) {
        return isSintaxisInferenceLaw(stringLaw);
    }
    
    public static boolean verifyDataInferenceLaw(String id, String law, String shortName, String name) {
        return isDigit(id) && isStringName(name) && isStringName(shortName);
    }
    
    public static boolean verifyDataInferenceLaw(int id, String law, String shortName, String name) {
        return isDigit(String.valueOf(id)) && isStringName(name) && isStringName(shortName) &&
                isSintaxisInferenceLaw(law);
    }
    public static boolean verifyDataPremise(String id, String expression) {
        return isDigit(id);
    }
    
    public static boolean verifyDataPremise(int id, String expression) {
        return isDigit(String.valueOf(id)) && isSintaxisPremise(expression);
    }
    
    public static boolean verifySintaxisMPP(String expression) {
        return isSintaxisMPP(expression);
    }
    
    public static boolean verifySintaxisMTT(String expression) {
        return isSintaxisMTT(expression);
    }
    
    public static boolean verifySintaxisMTP(String expression) {
        return isSintaxisMTP(expression);
    }
    
    public static boolean verifySintaxisLA(String expression) {
        return isSintaxisLA(expression);
    }
    
    public static boolean verifySintaxisLS(String expression) {
        return isSintaxisLS(expression);
    }
    
    public static boolean verifySintaxisLC(String expression) {
        return isSintaxisLC(expression);
    }
    public static boolean verifySintaxisConm(String expression) {
        return isSintaxisConm(expression);
    }
    
    public static boolean verifySintaxisLDS(String expression) {
        return isSintaxisLDS(expression);
    }
    
    public static boolean verifySintaxisSH(String expression) {
        return isSintaxisSH(expression);
    }
    
    public static boolean verifySintaxisDC(String expression) {
        return isSintaxisDC(expression);
    }
}

