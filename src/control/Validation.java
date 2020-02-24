/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.util.regex.Pattern.matches;

/**
 *
 * @author Omar Beltr�n, Javier Esteban
 */
public final class Validation {
    
    /**Este m�todo permite determinar si una string de caracteres cualesquiera est�
     * conformada unicamente por car�cteres alfabeticos, los caracteres alfabeticos v�lidos son:
     * - Letras may�sculas [A-Z]
     * - Letras min�sculas [a-z]
     * - Caracteres especiales como:
     *      - Vocales con acentuaci�n
     *      - Espacio en blanco
     *      - Los caracteres �, �
     * @param string contiene la string de caracteres que se desea evaluar
     * @return true si el par�metro de entrada satisface las reglas validadas
     *         false en cualquier otro caso
     */
    private static boolean isStringName(String string)
    {
        boolean flag = true;//se asume que la string es v�lida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index)< 65 || string.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (string.charAt(index)< 97 || string.charAt(index) > 122) &&//letras min�sculas 
               (string.charAt(index) != '�' && string.charAt(index) != '�' && //la � � se considera caracter especial
                string.charAt(index) != '�' && string.charAt(index) != '�' &&
                string.charAt(index) != '�' && string.charAt(index) != '�' &&    
                string.charAt(index) != '�' &&//validar las vocales con t�lde   
                string.charAt(index) != '.' &&//el punto debe ser permitido                    
                string.charAt(index) != ' ')){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = string.length()+1;//cuando se encuentra un car�cter inv�lido se debe finalizar el bucle
            }//end if 
        }//end for index 
        return flag;
    }//end isString
    
    /**
     * Eval�a si los valores contenidos en el par�metro son solo digitos
     * La expresi�n regular eval�a existencia de al menos una valor num�rico
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
        boolean flag = true;//se asume que la string es v�lida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index) < 47 || string.charAt(index) > 57) && //acepta n�meros
               string.charAt(index) == '.'){
                flag = false;//como no cumple la regla el retorno se cambia a false
                index = string.length()+1;//cuando se encuentra un carácter inv�lido se debe finalizar el bucle
            }    
        }
        return flag;
    }
    
    private boolean isStringAlphaNumeric(String string){
        boolean flag = true;//se asume que la string es v�lida por tanto se deja por defecto true
        int index;
        for (index = 0; index < string.length(); index++) {
            if((string.charAt(index) < 47 || string.charAt(index) > 57) && //acepta n�meros
              ((string.charAt(index)< 65 || string.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (string.charAt(index)< 97 || string.charAt(index) > 122) &&//letras min�sculas
               (string.charAt(index) != '�' && string.charAt(index) != '�' && //la � � se considera caracter especial
                string.charAt(index) != '�' && string.charAt(index) != '�' &&
                string.charAt(index) != '�' && string.charAt(index) != '�' &&    
                string.charAt(index) != '�' &&//validar las vocales con t�lde     
                string.charAt(index) != '.' &&//el punto debe ser permitido                    
                string.charAt(index) != ' '))){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = string.length()+1;//cuando se encuentra un car�cter inv�lido se debe finalizar el bucle
            }//end if 
        }//end for index  
        return flag; 
    }
   
    /**
     * este metodo debe validar la expresion ingresada como ley de inferencia
     * https://regexper.com/ para evaluar las expresiones regulares 
     */
    private static boolean isSintaxisInferenceLaw(String stringLaw) {
        return matches(("((^~?[PQRST])(((->|v|\\^)(~?[PQRST]))?))((,((~?[PQRST])(((->|v|\\^)(~?[PQRST]))?))){0,2})"
                        + "(:((~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)))"),stringLaw);
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
    
    /**------------------------------END--------------------------------------*/
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
}
