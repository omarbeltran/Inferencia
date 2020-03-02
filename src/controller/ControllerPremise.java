/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static control.ValidateInferenceLaw.solveInference;
import static control.ValidateInferenceLaw.solverInference;
import static control.Validation.verifyDataPremise;
import entities.Premise;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public class ControllerPremise {
    private static ArrayList<Premise> premises;
    
    public ControllerPremise(){
        premises = new ArrayList<>();
        loadDefaultPremise();
    }
    
    private void loadDefaultPremise() {
        
        /*Premise premise1 = new Premise(1, "P->S");
        if(verifyDataPremise(premise1.getIdPremise(), premise1.getExpression())) {
            addPremise(premise1);
        }
        
        Premise premise2 = new Premise(2, "~P->S");
        if(verifyDataPremise(premise2.getIdPremise(), premise2.getExpression())) {
            addPremise(premise2);
        }
        
        Premise premise3 = new Premise(3, "P->~S");
        if(verifyDataPremise(premise3.getIdPremise(), premise3.getExpression())) {
            addPremise(premise3);
        }
        
        Premise premise4 = new Premise(4, "~P");
        if(verifyDataPremise(premise4.getIdPremise(), premise4.getExpression())) {
            addPremise(premise4);
        }
             
        Premise premise5 = new Premise(5, "R^T");
        if(verifyDataPremise(premise5.getIdPremise(), premise5.getExpression())) {
            addPremise(premise5);
        }
        
        Premise premise6 = new Premise(6, "~R^T");
        if(verifyDataPremise(premise6.getIdPremise(), premise6.getExpression())) {
            addPremise(premise6);
        }
        
        Premise premise7 = new Premise(7, "Pv~S");
        if(verifyDataPremise(premise7.getIdPremise(), premise7.getExpression())) {
            addPremise(premise7);
        }
        
        Premise premise8 = new Premise(8, "RvR");
        if(verifyDataPremise(premise8.getIdPremise(), premise8.getExpression())) {
            addPremise(premise8);
        }
        
        Premise premise9 = new Premise(9, "~S");
        if(verifyDataPremise(premise9.getIdPremise(), premise9.getExpression())) {
            addPremise(premise9);
        }
        
        Premise premise10 = new Premise(10, "S");
        if(verifyDataPremise(premise10.getIdPremise(), premise10.getExpression())) {
            addPremise(premise10);
        }
        
        Premise premise11 = new Premise(11, "QvT");
        if(verifyDataPremise(premise11.getIdPremise(), premise11.getExpression())) {
            addPremise(premise11);
        }
        
        Premise premise12 = new Premise(12, "~Q");
        if(verifyDataPremise(premise12.getIdPremise(), premise12.getExpression())) {
            addPremise(premise12);
        }
        
        Premise premise13 = new Premise(13, "P");
        if(verifyDataPremise(premise13.getIdPremise(), premise13.getExpression())) {
            addPremise(premise13);
        }
        
        Premise premise14 = new Premise(14, "~R->~Q");
        if(verifyDataPremise(premise14.getIdPremise(), premise14.getExpression())) {
            addPremise(premise14);
        }
        
        Premise premise15 = new Premise(15, "(S^P)->~R");
        if(verifyDataPremise(premise15.getIdPremise(), premise15.getExpression())) {
            addPremise(premise15);
        }*/
        Premise premise1 = new Premise(1, "(Q^P)vR");
        if(verifyDataPremise(premise1.getIdPremise(), premise1.getExpression())) {
            addPremise(premise1);
        }
        
        Premise premise2 = new Premise(2, "S->~R");
        if(verifyDataPremise(premise2.getIdPremise(), premise2.getExpression())) {
            addPremise(premise2);
        }
        
        Premise premise3 = new Premise(3, "T->~R");
        if(verifyDataPremise(premise3.getIdPremise(), premise3.getExpression())) {
            addPremise(premise3);
        }
        
        Premise premise4 = new Premise(4, "SvT");
        if(verifyDataPremise(premise4.getIdPremise(), premise4.getExpression())) {
            addPremise(premise4);
        }
    }

    private boolean addPremise(Premise premiseNew) {
        boolean flag = false;
        if(premises.isEmpty()){
            premises.add(premiseNew);
            flag = true;
        }    
        else {
            for (int index = 0; index < premises.size() ; index++) {
                if(findPremiseById(premiseNew.getIdPremise()) == null) {//if not exist, agree premise
                   premises.add(premiseNew);
                   flag = true;
                   index = premises.size();
                }
            }
        }
        return flag;
    }
    
    private static Premise findPremiseById(int id) {      
        Premise premise;
        //se esta insertando el primer registro
        if(premises.isEmpty()) {
            return null;
        }    
        else {
            //recorrido del ArrayList usando un iterador
            Iterator it = premises.iterator();
            while(it.hasNext()) {
                premise = (Premise)it.next();//casting del iterador al objeto Premise
                if(premise.getIdPremise()== id) {
                    return premise;
                }    
            }    
        }       
        return null;
    }
    
    public void printAllPremise() {      
        Premise premise;
        //se esta insertando el primer registro
        if(!premises.isEmpty()) {
            //recorrido del ArrayList usando un iterador
            Iterator it = premises.iterator();
            System.out.println("\n\nLISTADO DE LAS PREMISAS ACEPTADAS");
            while(it.hasNext()) {
                premise = (Premise)it.next();//casting del iterador al objeto Premise
                System.out.print(premise.getIdPremise()+"\t");
                System.out.print(premise.getExpression()+"\n");
            }    
        }       
    }
    
    public void solve(String conclusion) {
        
        ArrayList<String> premisesString = new ArrayList<>();
        Premise premise;
        Iterator it = premises.iterator();
        while(it.hasNext()) {
            premise = (Premise)it.next();//casting del iterador al objeto Premise
            premisesString.add(premise.getExpression());
        }   
        System.out.println("\n\nDEMOSTRAR "+conclusion);
        System.out.println("\n\nSOLUCION");
        ArrayList<String> solveSteps = solverInference(premisesString, conclusion);
        for(int index = 0 ; index < solveSteps.size() ; index++) {
            System.out.println(solveSteps.get(index));
        }
    }
}
