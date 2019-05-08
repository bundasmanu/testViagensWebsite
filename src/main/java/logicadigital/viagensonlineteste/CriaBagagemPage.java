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
public class CriaBagagemPage {
    
    private int pesoBagagem;
    private int idCliente;
    private int idViagem;
    
    public CriaBagagemPage(){
        
    }
    
    public CriaBagagemPage(int peso){
        this.pesoBagagem=peso;
    }
    
    public CriaBagagemPage(int peso, int idCli, int idV){
        this.pesoBagagem=peso;
        this.idCliente=idCli;
        this.idViagem=idV;
    }

    public int getPesoBagagem() {
        return pesoBagagem;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setPesoBagagem(int pesoBagagem) {
        this.pesoBagagem = pesoBagagem;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }
    
}
