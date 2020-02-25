/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import static control.Validation.verifySintaxisMPP;
import static control.Validation.verifySintaxisMTP;
import static control.Validation.verifySintaxisMTT;
import static control.Validation.verifySintaxisLA;
import static control.Validation.verifySintaxisLS;
import static control.Validation.verifySintaxisLC;
import static control.Validation.verifySintaxisConm;
import static control.Validation.verifySintaxisLDS;
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
    
    public static ArrayList<String> solveInference(ArrayList<String> premises, String conclusion){
        solveInferenceOnePremise(premises, conclusion);
        solveInferenceTwoPremise(premises, conclusion);
        
        return solveSteps;
    }
    
    public static void solveInferenceOnePremise(ArrayList<String> premises, String conclusion) {
        ArrayList<String> premisesChanged = changeSymbolIntoPremises(premises, "->");
        String consequent = null;
        if(!premises.isEmpty()) {
            for(int index1 = 0 ; index1 < (premisesChanged.size()) ; index1++){
                if(verifySintaxisLS(premises.get(index1))) {
                    consequent = getLS(premisesChanged.get(index1));
                    if(consequent != null) {
                        addSolveSteps(index1+1, consequent, "LS");
                    }
                }
                if(verifySintaxisConm(premises.get(index1))) {
                    consequent = getConm(premisesChanged.get(index1));
                    if(consequent != null) {
                        addSolveSteps(index1+1, consequent, "Conmutativa");
                    }
                }
                if(verifySintaxisLDS(premises.get(index1))) {
                    consequent = getLDS(premisesChanged.get(index1));
                    if(consequent != null) {
                        addSolveSteps(index1+1, consequent, "LDS");
                    }
                }
            }
        }
    }

    public static void solveInferenceTwoPremise(ArrayList<String> premises, String conclusion) {
        ArrayList<String> premisesChanged = changeSymbolIntoPremises(premises, "->");
        String consequent = null;
        if(!premises.isEmpty()) {
            for(int index1 = 0 ; index1 < (premisesChanged.size())-1 ; index1++) {
                for(int index2 = index1+1 ; index2 < (premisesChanged.size()) ; index2++) {
                    if(verifySintaxisMPP(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getMPP(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, consequent, "MPP");
                        }
                    }    
                    if(verifySintaxisMTT(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getMTT(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, consequent, "MTT");
                        }
                    } 
                    if(verifySintaxisMTP(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getMTP(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, consequent, "MTP");
                        }
                    }
                    if(verifySintaxisLA(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getLA(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, consequent, "LA");
                        }
                    }
                    if(verifySintaxisLC(premises.get(index1)+","+premises.get(index2))) {
                        consequent = getLC(premisesChanged.get(index1), premisesChanged.get(index2));
                        if(consequent != null) {
                            addSolveStep(index1+1, index2+1, consequent, "LC");
                        }
                    }
                }
            }
        } 
    }
    
    /**Modus Tollendo Tollens ? MTT
     * Esta regla señala que si la implicación de premisas es verdadera y su 
     * consecuente es falso, entonces su antecedente es necesariamente falso.
     */
    private static String getMTT(String premise1, String premise2) {
        //ALT + 175 »
        String consequent = null;
        boolean flag = false;
        String [] cadenas1 = premise1.split("[»]");//obtener cada una de las proposiciones que conforman la premisa
        String [] cadenas2 = premise2.split("[»]");//obtener cada una de las proposiciones que conforman la premisa
        
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
     * Esta regla establece que si la implicación de premisas y su antecedente 
     * son verdaderos, su consecuente es necesariamente verdadero.
     */
    private static String getMPP(String premise1, String premise2) {
        //ALT + 175 »
        String [] cadenas1 = premise1.split("[»]");//obtener cada una de las proposiciones que conforman la premisa
        String [] cadenas2 = premise2.split("[»]");//obtener cada una de las proposiciones que conforman la premisa
        
        return ((cadenas1[0].compareTo(cadenas2[0])) == 0) ? cadenas1[1] : null;
    }
    
    private static String getMTP(String premise1, String premise2) {
        boolean flag = false;
        String [] cadenas1 = premise1.split("[v]");//obtener cada una de las proposiciones que conforman la premisa
        if(premise2.length() > 1 && cadenas1[1].length() == 1) {
            if (cadenas1[0].compareTo(String.valueOf(premise2.charAt(1))) == 0) {
                flag = true;
            }
        } 
        return flag == true ? cadenas1[1] : null;
    }
    
    private static String getLA(String premise1, String premise2) {
        return premise1+"v"+premise2;
    }
    
    private static String getLS(String premise1) {
        String [] cadena1 = premise1.split("[\\^]");
        return cadena1[1];
    }
    
    private static String getLC(String premise1, String premise2) {
        return premise1+"^"+"("+premise2+")";
    }
    
    private static String getConm(String premise1) {
        String [] cadenas1 = premise1.split("[v]");
        return cadenas1[1]+"v"+cadenas1[0];
    }
    
    private static String getLDS(String premise1) {
        String [] cadenas1 = premise1.split("[v]");
        return ((cadenas1[0].compareTo(cadenas1[1])) == 0) ? cadenas1[0] : null;
    }
    
    private static ArrayList<String> changeSymbolIntoPremises(ArrayList<String> premises, String symbol) {
        ArrayList<String> premisesChanged = new ArrayList<>();
        if(!premises.isEmpty()) {
            for(int index = 0 ; index < premises.size() ; index++) {
                premisesChanged.add(premises.get(index).replaceFirst(symbol, "»"));//reemplazar la simbolog�a de "entonces"
            }
        }
        return premisesChanged;
    }
    
    private static void addSolveStep(int index1, int index2, String conclusion, String inferenceLaw) {
        solveSteps.add(conclusion+ " "+inferenceLaw+ " ("+index1+","+index2+")");
    }
    
    private static void addSolveSteps(int index1, String conclusion, String inferenceLaw) {
        solveSteps.add(conclusion+ " "+inferenceLaw+ " ("+index1+")");
    }
}
