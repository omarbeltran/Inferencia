/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import static control.Validation.isSintaxisMPP;
/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public final class ValidateInferenceLaw {
    
    private static ArrayList<String> solveSteps = new ArrayList<>();
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
        isMPP(premise1, premise2);
        return isMPP(premise1, premise2) ? premise2:"";
    }

    private static String getMPP(String premise1, String premise2) {
        isMPP(premise1, premise2);
        String [] cadenas1 = premise1.split("[»]");//obtener cada una de las proposiciones que conforman la premisa 
        return cadenas1[1];
    }
    public static String solveInference(String premise1, String premise2) {
        if (isMPP(premise1, premise2))
            return "MTT";
        return "2";
    }
    
    public static ArrayList<String> solveInference(ArrayList<String> premises, String conclusion) {
        ArrayList<String> premisesChanged = changeSymbolIntoPremises(premises, "->");
        if(!premises.isEmpty())
        {
            for(int index1 = 0 ; index1 < (premisesChanged.size())-1 ; index1++) {
                for(int index2 = index1+1 ; index2 < (premisesChanged.size()) ; index2++) {
                    if(isSintaxisMPP(premises.get(index1)+","+premises.get(index2))) {
                        if(isMPP(premisesChanged.get(index1), premisesChanged.get(index2))) {
                            addSolveStep(index1+1, index2+1, getMPP(premisesChanged.get(index1), premisesChanged.get(index2)),"MPP");
                        }
                    }    
                }
            }
        } 
        return solveSteps;
    }
    
       
    
    /**Modus Tollendo Tollens ? MTT
     * Esta regla señala que si la implicación de premisas es verdadera y su 
     * consecuente es falso, entonces su antecedente es necesariamente falso.
     */
    
    /**Modus Ponendo Ponens MPP
     * Esta regla establece que si la implicación de premisas y su antecedente 
     * son verdaderos, su consecuente es necesariamente verdadero.
     */
    private static boolean isMPP(String premise1, String premise2) {
        //ALT + 175 »
        String [] cadenas1 = premise1.split("[»^v]");//obtener cada una de las proposiciones que conforman la premisa
        String [] cadenas2 = premise2.split("[»^v]");//obtener cada una de las proposiciones que conforman la premisa
        
        return (cadenas1[0].compareTo(cadenas2[0])) == 0;
    }
    
    private static ArrayList<String> changeSymbolIntoPremises(ArrayList<String> premises, String symbol) {
        ArrayList<String> premisesChanged = new ArrayList<>();
        if(!premises.isEmpty())
        {
            for(int index = 0 ; index < premises.size() ; index++) {
                premisesChanged.add(premises.get(index).replaceFirst(symbol, "»"));//reemplazar la simbología de "entonces"
            }
        }
        return premisesChanged;
    }
    
    private static void addSolveStep(int index1, int index2, String conclusion, String inferenceLaw) {
        solveSteps.add(conclusion+ " "+inferenceLaw+ " ("+index1+","+index2+")");
    }
}
