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
public class DaPontuacaoDestinoPage {
    
    private String nomeDestino;
    private String pontDestino;
    
    public DaPontuacaoDestinoPage(){
        
    }
    
    public DaPontuacaoDestinoPage(String nomeDest, String pontDest){
        this.nomeDestino=nomeDest;
        this.pontDestino=pontDest;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public String getPontDestino() {
        return pontDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }
    
    public void setPontDestino(String pontDestino) {
        this.pontDestino = pontDestino;
    }
    
    
}
