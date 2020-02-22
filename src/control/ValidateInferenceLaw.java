/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import static control.Validation.verifySintaxisMPP;
import static control.Validation.verifySintaxisMTT;
/**
 *
 * @author Omar Beltr�n, Javier Esteban
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
    
    public static ArrayList<String> solveInference(ArrayList<String> premises, String conclusion) {
        ArrayList<String> premisesChanged = changeSymbolIntoPremises(premises, "->");
        String consequent = null;
        if(!premises.isEmpty())
        {
            for(int index1 = 0 ; index1 < (premisesChanged.size())-1 ; index1++) {
                for(int index2 = index1+1 ; index2 < (premisesChanged.size()) ; index2++) {
                    if(verifySintaxisMPP(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getMPP(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, getMPP(premisesChanged.get(index1), premisesChanged.get(index2)),"MPP");
                        }
                    }    
                    if(verifySintaxisMTT(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getMTT(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, getMTT(premisesChanged.get(index1), premisesChanged.get(index2)),"MTT");
                        }
                    } 
                }
            }
        } 
        return solveSteps;
    }
    
    /**Modus Tollendo Tollens ? MTT
     * Esta regla se�ala que si la implicaci�n de premisas es verdadera y su 
     * consecuente es falso, entonces su antecedente es necesariamente falso.
     */
    private static String getMTT(String premise1, String premise2) {
        //ALT + 175 �
        String consequent = null;
        boolean flag = false;
        String [] cadenas1 = premise1.split("[�]");//obtener cada una de las proposiciones que conforman la premisa
        String [] cadenas2 = premise2.split("[�]");//obtener cada una de las proposiciones que conforman la premisa
        
        if(cadenas1[1].length() > 1 && cadenas2[0].length() == 1) {
            if (cadenas2[0].compareTo(String.valueOf(cadenas1[1].charAt(1))) == 0) {
                flag = true;
            }
        } 
        else if(cadenas2[0].length() > 1 && cadenas1[1].length() == 1) {
            if (cadenas1[1].compareTo(String.valueOf(cadenas2[0].charAt(1))) == 0) {
                flag = true;
            }
        }
       
        if(flag) {
            if(cadenas1[0].length() > 1) {
                consequent = String.valueOf(cadenas1[0].charAt(1));
            }
            else {
                consequent = "~"+cadenas1[0];
            }
        }
        return consequent;
    }
    
    /**Modus Ponendo Ponens MPP
     * Esta regla establece que si la implicaci�n de premisas y su antecedente 
     * son verdaderos, su consecuente es necesariamente verdadero.
     */
    private static String getMPP(String premise1, String premise2) {
        //ALT + 175 �
        String [] cadenas1 = premise1.split("[�]");//obtener cada una de las proposiciones que conforman la premisa
        String [] cadenas2 = premise2.split("[�]");//obtener cada una de las proposiciones que conforman la premisa
        
        return ((cadenas1[0].compareTo(cadenas2[0])) == 0) ? cadenas1[1] : null;
    }
    
    private static ArrayList<String> changeSymbolIntoPremises(ArrayList<String> premises, String symbol) {
        ArrayList<String> premisesChanged = new ArrayList<>();
        if(!premises.isEmpty())
        {
            for(int index = 0 ; index < premises.size() ; index++) {
                premisesChanged.add(premises.get(index).replaceFirst(symbol, "�"));//reemplazar la simbolog�a de "entonces"
            }
        }
        return premisesChanged;
    }
    
    private static void addSolveStep(int index1, int index2, String conclusion, String inferenceLaw) {
        solveSteps.add(conclusion+ " "+inferenceLaw+ " ("+index1+","+index2+")");
    }
}
