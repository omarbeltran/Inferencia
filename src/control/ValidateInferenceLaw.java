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
public final class ValidateInferenceLaw {
    
    private static String verifyMTT(String premise1, String premise2) {
        
        /**
         * acepta caracteres P, Q, R, S, o T 
         * ~R
         * T
         * P->Q
         * P->~P
         * ~P->Q
         * ~P->~P
         * Pv~P
         * ~PvQ
         * ~Pv~P
         * P^~P
         * ~P^Q
         * ~P^~P
        //((^~?[PQRST])(((->|v|\\^)(~?[PQRST]))?)) 
        return  matches(("(^~?[PQRST])((->|v|\\^)(~?[PQRST]))?"),stringLaw);*/
        /**
        /** acepta MPP, MTT, MTP
        //return matches(("(^~?[PQRST])((->|v|\\^)(~?[PQRST]))?((,)(~?[PQRST])(:)(~?[PQRST]))?"),stringLaw);*/
        //return  matches(("(^~?[PQRST])((->| v |\\^)(~?[PQRST]))?"),stringLaw);
        return "";
    }
    
    public static String getMTT(String premise1, String premise2) {
        return verifyMTT(premise1, premise2);
    }
    
    private boolean isMTTSintaxis(String stringLaw){
        return matches(("(^~?[PQRST])((->|v|\\^)(~?[PQRST]))?((,)(~?[PQRST])(:)(~?[PQRST]))?"),stringLaw);
    }
}
