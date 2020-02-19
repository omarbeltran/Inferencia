/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.util.regex.Pattern.matches;

/**
 *
 * @author Omar Beltr�n
 */
public final class Validation {
    
    /**Este método permite determinar si una cadena de caracteres cualesquiera está
     * conformada unicamente por carácteres alfabeticos, los caracteres alfabeticos válidos son:
     * - Letras mayúsculas [A-Z]
     * - Letras minúsculas [a-z]
     * - Caracteres especiales como:
     *      - Vocales con acentuación
     *      - Espacio en blanco
     *      - Los caracteres Ñ, ñ
     * @param cadena contiene la cadena de caracteres que se desea evaluar
     * @return true si el parámetro de entrada satisface las reglas validadas
     *         false en cualquier otro caso
     */
    public static boolean isStringName(String cadena)
    {
        boolean flag = true;//se asume que la cadena es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < cadena.length(); index++) {
            if((cadena.charAt(index)< 65 || cadena.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (cadena.charAt(index)< 97 || cadena.charAt(index) > 122) &&//letras min�sculas 
               (cadena.charAt(index) != '�' && cadena.charAt(index) != '�' && //la � � se considera caracter especial
                cadena.charAt(index) != '�' && cadena.charAt(index) != '�' &&
                cadena.charAt(index) != '�' && cadena.charAt(index) != '�' &&    
                cadena.charAt(index) != '�' &&//validar las vocales con t�lde   
                cadena.charAt(index) != '.' &&//el punto debe ser permitido                    
                cadena.charAt(index) != ' ')){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = cadena.length()+1;//cuando se encuentra un car�cter inv�lido se debe finalizar el bucle
            }//end if 
        }//end for index 
        return flag;
    }//end isString
    
    /**Evalúa si los valores contenidos en el parametro son solo digitos
     * @param id valor que se desea verificar
     * @return true si id contiene solo digitos
     *         false en cualquier otro caso
     */
    public static boolean isDigit(String id)
    {    
        return matches("[0-9]+",id);
    }
    
    public static boolean isValue(String cadena)
    {    
        boolean flag = true;//se asume que la cadena es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < cadena.length(); index++) {
            if((cadena.charAt(index) < 47 || cadena.charAt(index) > 57) && //acepta números
               cadena.charAt(index) == '.'){
                flag = false;//como no cumple la regla el retorno se cambia a false
                index = cadena.length()+1;//cuando se encuentra un carácter inválido se debe finalizar el bucle
            }    
        }
        return flag;
    }
    
    private boolean isStringAlphaNumeric(String cadena){
        boolean flag = true;//se asume que la cadena es válida por tanto se deja por defecto true
        int index;
        for (index = 0; index < cadena.length(); index++) {
            if((cadena.charAt(index) < 47 || cadena.charAt(index) > 57) && //acepta n�meros
              ((cadena.charAt(index)< 65 || cadena.charAt(index)> 90) && //LETRAS MAYUSCULAS 
               (cadena.charAt(index)< 97 || cadena.charAt(index) > 122) &&//letras min�sculas
               (cadena.charAt(index) != '�' && cadena.charAt(index) != '�' && //la � � se considera caracter especial
                cadena.charAt(index) != '�' && cadena.charAt(index) != '�' &&
                cadena.charAt(index) != '�' && cadena.charAt(index) != '�' &&    
                cadena.charAt(index) != '�' &&//validar las vocales con t�lde     
                cadena.charAt(index) != '.' &&//el punto debe ser permitido                    
                cadena.charAt(index) != ' '))){//el espacio en blanco debe ser permitido                   
                    flag = false;//como no cumple la regla el retorno se cambia a false
                    index = cadena.length()+1;//cuando se encuentra un car�cter inv�lido se debe finalizar el bucle
            }//end if 
        }//end for index  
        return flag; 
    }
   
    public static boolean verifyDataInferenceLaw(String id, String law, String shortName, String name){
        return isDigit(id) && isStringName(name) && isStringName(shortName);
    }
    
    public static boolean verifyDataInferenceLaw(int id, String law, String shortName, String name){
        return isDigit(String.valueOf(id)) && isStringName(name) && isStringName(shortName);
    }
    
}
