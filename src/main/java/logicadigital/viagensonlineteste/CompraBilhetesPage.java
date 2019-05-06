/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.viagensonlineteste;

/**
 *
 * @author Armando
 */
public class CompraBilhetesPage {
    
    private String idViagem;
    private String numBilhetes;
    
    public CompraBilhetesPage(){
        
    }
    
    public CompraBilhetesPage(String id, String num){
        this.idViagem=id;
        this.numBilhetes=num;
    }

    public String getIdViagem() {
        return idViagem;
    }

    public String getNumBilhetes() {
        return numBilhetes;
    }

    public void setIdViagem(String idViagem) {
        this.idViagem = idViagem;
    }

    public void setNumBilhetes(String numBilhetes) {
        this.numBilhetes = numBilhetes;
    }

}
