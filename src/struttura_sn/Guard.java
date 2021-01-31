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
    private final boolean invert_result;
    private final Variable[] var_tuple;
    
    public Guard(boolean not, Variable[] var_tuple){
        this.predicates = new ArrayList<>();
        this.seperationTypes = new ArrayList<>();
        this.invert_result = not;
        this.var_tuple = var_tuple;
    }
    
    public Variable[] get_tuple(){
        return this.var_tuple;
    }
    
    public boolean is_satisfied(){
        boolean sat = true;
        
        if(this.predicates.isEmpty()){
            return true;
        }
        if(this.predicates.size() == 1){
            return this.predicates.get(0).is_satisfied() && this.invert_result;
        }
        for(var i=0; i<this.seperationTypes.size(); i++){
            Predicate p1 = this.predicates.get(i);
            Predicate p2 = this.predicates.get(i+1);
                
            if(this.seperationTypes.get(i).equals("and")){ //&&
                sat = sat && (p1.is_satisfied() && p2.is_satisfied());                
            }else{ //or
                sat = sat && (p1.is_satisfied() || p2.is_satisfied());
            }
        }
        return sat && this.invert_result;
    }
    
    public void add_predicate(Predicate pd){
        this.predicates.add(pd);
    }
    
    public void add_separation(String type){
        this.seperationTypes.add(type);
    }
    
}
