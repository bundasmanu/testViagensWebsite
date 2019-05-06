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
public class RegisterPage {
    
    String email;
    String nome;
    String pass;
    String confPass; 
    
    public RegisterPage(){
        
    }
    
    public RegisterPage(String e, String n, String p, String c){
        this.email=e;
        this.nome=n;
        this.pass=p;
        this.confPass=c;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPass() {
        return pass;
    }

    public String getConfPass() {
        return confPass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setConfPass(String confPass) {
        this.confPass = confPass;
    }

}
