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
public class InferenceLaw {

    /**
     * @return the inferenceShortName
     */
    public String getInferenceShortName() {
        return inferenceShortName;
    }

    /**
     * @param inferenceShortName the inferenceShortName to set
     */
    public void setInferenceShortName(String inferenceShortName) {
        this.inferenceShortName = inferenceShortName;
    }

    /**
     * @return the inferenceName
     */
    public String getInferenceName() {
        return inferenceName;
    }

    /**
     * @param inferenceName the inferenceName to set
     */
    public void setInferenceName(String inferenceName) {
        this.inferenceName = inferenceName;
    }

    /**
     * @return the idInferenceLaw
     */
    public int getIdInferenceLaw() {
        return idInferenceLaw;
    }

    /**
     * @param idInferenceLaw the idInferenceLaw to set
     */
    public void setIdInferenceLaw(int idInferenceLaw) {
        this.idInferenceLaw = idInferenceLaw;
    }

    /**
     * @return the inferenceLaw
     */
    public String getInferenceLaw() {
        return inferenceLaw;
    }

    /**
     * @param inferenceLaw the inferenceLaw to set
     */
    public void setInferenceLaw(String inferenceLaw) {
        this.inferenceLaw = inferenceLaw;
    }

    //constructores
    public InferenceLaw(int id, String law, String shortName, String name) {
        this.idInferenceLaw = id;
        this.inferenceLaw = law;
        this.inferenceShortName = shortName;
        this.inferenceName = name;
    }
    
    public InferenceLaw(String id, String law, String shortName, String name) {
        this.idInferenceLaw = Integer.parseInt(id);
        this.inferenceLaw = law;
        this.inferenceShortName = shortName;
        this.inferenceName = name;
    }
    
    private int idInferenceLaw;
    private String inferenceLaw;
    private String inferenceShortName;
    private String inferenceName;
    
}
