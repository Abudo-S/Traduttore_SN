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
    
    private ArrayList<String> predicates;
    private ArrayList<String> seperationTypes; //contains: and , or
    
    Guard(){
        this.predicates = new ArrayList<>();
        this.seperationTypes = new ArrayList<>();
    }
    
    
    public boolean is_satisfied(){
        return false;
    }
    
    public void add_predicate(String pd){
        this.predicates.add(pd);
    }
    
    public void add_separation(String type){
        this.seperationTypes.add(type);
    }
    
    public boolean satisfy_predicate(Variable v1, Variable v2){
        return false;
    }
    
}
