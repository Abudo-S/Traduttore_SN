/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

/**
 *
 * @author dell
 */
public class Variable {
    
    private final String variable_name;
    private final ColourClass colour_type;
    private Token current_assignment;
    
    public Variable(String variable_name, ColourClass colour_type){
        this.variable_name = variable_name;
        this.colour_type = colour_type;
    }
    
    public String get_name(){
        return this.variable_name;
    }
    
    public ColourClass get_colourClass(){
        return this.colour_type;
    }
    
    public void set_current_assignment(Token t){
        this.current_assignment = t;
    }
    
    public Token get_current_assignment(){
        return this.current_assignment;
    }
    
}
