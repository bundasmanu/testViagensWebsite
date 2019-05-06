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
public class LoginPage {
    
    String email;
    String pass;
    
    public LoginPage(){
        
    }
    
    public LoginPage(String e, String p){
        this.email=e;
        this.pass=p;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
