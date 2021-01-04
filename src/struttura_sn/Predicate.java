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
public class Predicate {
    
    private final Variable v1;
    private final String operation;
    private Variable v2 = null;
    private ColourClass c = null;
    private final boolean invert_result;
    
    public Predicate(Variable v1, String op, Variable v2, boolean not){
        this.v1 = v1;
        this.operation = op;
        this.v2 = v2;
        this.invert_result = not;
    }
    
    public Predicate(Variable v1, String op, ColourClass c, boolean not){
        this.v1 = v1;
        this.operation = op;
        this.c = c;
        this.invert_result = not;
    }    
    public boolean is_satisfied(){
        boolean sat = false;
        int v2_com = 0;
        
        if(this.v2 != null){
             v2_com = this.v1.get_current_assignment().get_Token_value().compareTo(
                      this.v2.get_current_assignment().get_Token_value());
        }
        
        switch(this.operation){
            case ">":
                if(v2_com == 1){
                    sat = true;
                }
            case "<":
                if(v2_com == -1){
                    sat = true;
                }
            case ">=":
                if(v2_com == 1 || v2_com == 0){
                    sat = true;
                }
            case "<=":
                if(v2_com == -1 || v2_com == 0){
                    sat = true;
                }
            case "=":
                if(v2_com == 0){
                    sat = true;
                }
            case "!=":
                if(v2_com != 0 ){
                    sat = true;
                }
            case "in":
                if(this.c.is_available(this.v1.get_current_assignment())){
                    sat = true;
                }     
            case "!in":
                if(!this.c.is_available(this.v1.get_current_assignment())){
                    sat = true;
                }
        }
        
        return sat && this.invert_result;
    }
    
    
}
