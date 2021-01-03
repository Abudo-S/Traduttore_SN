/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Guard {
    
    private ArrayList<Predicate> predicates;
    private ArrayList<String> seperationTypes; //contains: and , or
    
    public Guard(){
        this.predicates = new ArrayList<>();
        this.seperationTypes = new ArrayList<>();
    }
    
    
    public boolean is_satisfied(){
        if(this.predicates.isEmpty()){
            return true;
        }
        
        return false;
    }
    
    public void add_predicate(Predicate pd){
        this.predicates.add(pd);
    }
    
    public void add_separation(String type){
        this.seperationTypes.add(type);
    }
    
    private boolean satisfy_predicate(Variable v1,String operation, Variable v2){
        return false;
    }
    
    private boolean satisfy_predicate(Variable v1, String operation, ColourClass c){
        return false;
    }
}
