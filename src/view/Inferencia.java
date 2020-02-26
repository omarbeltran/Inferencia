/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerInferenceLaw;
import Controller.ControllerPremise;

/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public class Inferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerInferenceLaw CIL = new ControllerInferenceLaw();
        CIL.printAllInferenceLaw();//mostrar las leyes de inferencia que est� aceptando
        ControllerPremise CP = new ControllerPremise();
        CP.printAllPremise();
        CP.solve("P^Q");
    }
}
