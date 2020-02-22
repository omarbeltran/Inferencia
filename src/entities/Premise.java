/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Omar Beltrán, Javier Esteban
 */
public class Premise {

    /**
     * @return the idPremise
     */
    public int getIdPremise() {
        return idPremise;
    }

    /**
     * @param idPremise the idPremise to set
     */
    public void setIdPremise(int idPremise) {
        this.idPremise = idPremise;
    }

    /**
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    //constructores
    public Premise(int id, String expression) {
        this.idPremise = id;
        this.expression = expression;
        
    }
    
    public Premise(String id, String expression) {
        this.idPremise = Integer.parseInt(id);
        this.expression = expression;
    }
    
    private int idPremise;
    private String expression;
}
