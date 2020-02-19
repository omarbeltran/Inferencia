/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.util.regex.Pattern.matches;

/**
 *
 * @author Omar Beltrán
 */
public final class Validation {
    
    /**Este método permite determinar si una string de caracteres cualesquiera está
     * conformada unicamente por carácteres alfabeticos, los caracteres alfabeticos válidos son:
     * - Letras mayúsculas [A-Z]
     * - Letras minúsculas [a-z]
     * - Caracteres especiales como:
     *      - Vocales con acentuación
     *      - Espacio en blanco
     *      - Los caracteres Ñ, ñ
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
               (string.charAt(index) != 'ñ' && string.charAt(index) != 'Ñ' && //la Ñ ñ se considera caracter especial
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
                index = string.length()+1;//cuando se encuentra un carÃ¡cter inválido se debe finalizar el bucle
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
               (string.charAt(index) != 'ñ' && string.charAt(index) != 'Ñ' && //la Ñ ñ se considera caracter especial
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
     */
    private static boolean isSintaxisInferenceLaw(String stringLaw) {
        return matches("[~| ]?[PQRST]",stringLaw);
    }
    
    public static boolean verifyInferenceLaw(String stringLaw) {
        return isSintaxisInferenceLaw(stringLaw);
    }
    public static boolean verifyDataInferenceLaw(String id, String law, String shortName, String name){
        return isDigit(id) && isStringName(name) && isStringName(shortName);
    }
    
    public static boolean verifyDataInferenceLaw(int id, String law, String shortName, String name){
        return isDigit(String.valueOf(id)) && isStringName(name) && isStringName(shortName) &&
                isSintaxisInferenceLaw(law);
    }
    
}
