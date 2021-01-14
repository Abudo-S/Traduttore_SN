/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public abstract class Arc {
    
    protected String name;
    protected int level;
    protected ArrayList<Variable> ExVars;
    protected Guard guard; // will be removed
    protected Guard[] guard_class;
    protected Guard[] guard_domain;
    protected int multiplicity; // will be removed
    protected HashMap<Variable, Integer> mult_class;
    protected HashMap<Variable[], Integer> mult_domain;
    
    public void add_expressionVar(Variable v){
        this.ExVars.add(v);
    }
    
}
