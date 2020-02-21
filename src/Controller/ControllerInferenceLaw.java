/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static control.Validation.verifyDataInferenceLaw;
import entities.InferenceLaw;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public final class ControllerInferenceLaw {
    
    private static ArrayList<InferenceLaw> inferenceLaws;
    
    public ControllerInferenceLaw(){
        inferenceLaws = new ArrayList<>();
        loadDefaultInferenceLaw();
    }
    
    //ALT + 126 = ~
    //ALT + 94 = ^
    /**
     * This method create objects type InferenceLaw.
     * The constructor InferenceLaw have 4 parameters, that order is:
     *  1. Identification or ID
     *  2. Sintaxis of inference law
     *  3. Abbreviation or short name of inference law
     *  4. Full name of inference law
     * 
     */ 
    private void loadDefaultInferenceLaw() { 
        
        InferenceLaw inferenceLaw111 = new InferenceLaw(111, "~P", "MTT", "Modus Tollendus Tollens");
        if(verifyDataInferenceLaw(inferenceLaw111.getIdInferenceLaw(), inferenceLaw111.getInferenceLaw(), 
                inferenceLaw111.getInferenceShortName(), inferenceLaw111.getInferenceName()))
            addInferenceLaw(inferenceLaw111);
        InferenceLaw inferenceLaw222 = new InferenceLaw(222, "P->~Q", "MTT", "Modus Tollendus Tollens");
        if(verifyDataInferenceLaw(inferenceLaw222.getIdInferenceLaw(), inferenceLaw222.getInferenceLaw(), 
                inferenceLaw222.getInferenceShortName(), inferenceLaw222.getInferenceName()))
            addInferenceLaw(inferenceLaw222);
        
        InferenceLaw inferenceLaw = new InferenceLaw(1, "P->Q,~Q:~P", "MTT", "Modus Tollendus Tollens");
        if(verifyDataInferenceLaw(inferenceLaw.getIdInferenceLaw(), inferenceLaw.getInferenceLaw(), 
                inferenceLaw.getInferenceShortName(), inferenceLaw.getInferenceName()))
            addInferenceLaw(inferenceLaw);
        
        InferenceLaw inferenceLaw1 = new InferenceLaw(2, "P->Q,Q:P", "MPP", "Modus Ponendus Ponens");
        if(verifyDataInferenceLaw(inferenceLaw1.getIdInferenceLaw(), inferenceLaw1.getInferenceLaw(), 
                inferenceLaw1.getInferenceShortName(), inferenceLaw1.getInferenceName()))
            addInferenceLaw(inferenceLaw1);
        
        InferenceLaw inferenceLaw2 = new InferenceLaw(3, "P->Q,~P:Q", "MTP", "Modus Tollendus Ponens");
        if(verifyDataInferenceLaw(inferenceLaw2.getIdInferenceLaw(), inferenceLaw2.getInferenceLaw(), 
                inferenceLaw2.getInferenceShortName(), inferenceLaw2.getInferenceName()))
            addInferenceLaw(inferenceLaw2);
        
        InferenceLaw inferenceLaw3 = new InferenceLaw(4, "P,Q:PvQ", "LA", "Ley de la Adjunción");
        if(verifyDataInferenceLaw(inferenceLaw3.getIdInferenceLaw(), inferenceLaw3.getInferenceLaw(), 
                inferenceLaw3.getInferenceShortName(), inferenceLaw3.getInferenceName()))
            addInferenceLaw(inferenceLaw3);
        
        //(P) LA SINTAIX AUN NO EVALUA ESTA CADENA
        InferenceLaw inferenceLaw4 = new InferenceLaw(5, "~R,PvQ:~R^(PvQ)", "LC", "Ley de Conjunción");
        if(verifyDataInferenceLaw(inferenceLaw4.getIdInferenceLaw(), inferenceLaw4.getInferenceLaw(), 
                inferenceLaw4.getInferenceShortName(), inferenceLaw4.getInferenceName()))
            addInferenceLaw(inferenceLaw4);
        
        InferenceLaw inferenceLaw5 = new InferenceLaw(6, "P^Q:P", "LS", "Ley de la Simplificación");
        if(verifyDataInferenceLaw(inferenceLaw5.getIdInferenceLaw(), inferenceLaw5.getInferenceLaw(), 
                inferenceLaw5.getInferenceShortName(), inferenceLaw5.getInferenceName()))
            addInferenceLaw(inferenceLaw5);
        
        InferenceLaw inferenceLaw6 = new InferenceLaw(7, "P->Q,Q->R:P->R", "SH", "Silogismo Hipotético");
        if(verifyDataInferenceLaw(inferenceLaw6.getIdInferenceLaw(), inferenceLaw6.getInferenceLaw(), 
                inferenceLaw6.getInferenceShortName(), inferenceLaw6.getInferenceName()))
            addInferenceLaw(inferenceLaw6);
        
        InferenceLaw inferenceLaw7 = new InferenceLaw(8, "P^Q:Q^P", "C", "Conmutativa");
        //OJO!!!!!! esta ley aplica tanto para conjunción como para disyunción
        if(verifyDataInferenceLaw(inferenceLaw7.getIdInferenceLaw(), inferenceLaw7.getInferenceLaw(), 
                inferenceLaw7.getInferenceShortName(), inferenceLaw7.getInferenceName()))
            addInferenceLaw(inferenceLaw7);
        
        InferenceLaw inferenceLaw8 = new InferenceLaw(9, "PvP:P", "LDS", "Idempotencia");
        if(verifyDataInferenceLaw(inferenceLaw8.getIdInferenceLaw(), inferenceLaw8.getInferenceLaw(), 
                inferenceLaw8.getInferenceShortName(), inferenceLaw8.getInferenceName()))
            addInferenceLaw(inferenceLaw8);
        
        InferenceLaw inferenceLaw9 = new InferenceLaw(10, "P:PvQ", "LA", "Ley de la Adición");
        if(verifyDataInferenceLaw(inferenceLaw9.getIdInferenceLaw(), inferenceLaw9.getInferenceLaw(), 
                inferenceLaw9.getInferenceShortName(), inferenceLaw9.getInferenceName()))
            addInferenceLaw(inferenceLaw9);
        
        InferenceLaw inferenceLaw10 = new InferenceLaw(11, "P->S,Q->~R,PvQ:Sv~R", "DC", "Dilema Constructivo");
        if(verifyDataInferenceLaw(inferenceLaw10.getIdInferenceLaw(), inferenceLaw10.getInferenceLaw(), 
                inferenceLaw10.getInferenceShortName(), inferenceLaw10.getInferenceName()))
            addInferenceLaw(inferenceLaw10);
    }
    
    private boolean addInferenceLaw(InferenceLaw inferenceLawNew)
    {
        boolean flag = false;
        if(inferenceLaws.isEmpty()){
            inferenceLaws.add(inferenceLawNew);
            flag = true;
        }    
        else
        {
            for (int index = 0; index < inferenceLaws.size() ; index++)
            {
                if(findInferenceLawById(inferenceLawNew.getIdInferenceLaw()) == null)
                {//if not exist, agree person
                   inferenceLaws.add(inferenceLawNew);
                   flag = true;
                   index = inferenceLaws.size();
                }
            }
        }
        return flag;
    }
    
    private static InferenceLaw findInferenceLawById(int id)
    {      
        InferenceLaw inferenceLaw;
        //se esta insertando el primer registro
        if(inferenceLaws.isEmpty())
        {
            return null;
        }    
        else
        {
            //recorrido del ArrayList usando un iterador
            Iterator it = inferenceLaws.iterator();
            while(it.hasNext())
            {
                inferenceLaw = (InferenceLaw)it.next();//casting del iterador al objeto InferenceLaw
                if(inferenceLaw.getIdInferenceLaw()== id)
                {
                    return inferenceLaw;
                }    
            }    
        }       
        return null;
    }
    
    public void printAllInferenceLaw()
    {      
        InferenceLaw inferenceLaw;
        //se esta insertando el primer registro
        if(!inferenceLaws.isEmpty())
        {
            //recorrido del ArrayList usando un iterador
            Iterator it = inferenceLaws.iterator();
            while(it.hasNext())
            {
                inferenceLaw = (InferenceLaw)it.next();//casting del iterador al objeto CuentaContable
                System.out.print(inferenceLaw.getIdInferenceLaw()+"\t");
                System.out.print(inferenceLaw.getInferenceLaw()+"\t");
                System.out.print(inferenceLaw.getInferenceShortName()+"\t");
                System.out.print(inferenceLaw.getInferenceName()+"\n");
            }    
        }       
    }
}
