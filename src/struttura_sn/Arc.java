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
public abstract class Arc {
    
    protected String name;
    protected int level;
    protected ArrayList<Variable> ExVars;
    protected Guard guard;
    protected int multiplicity;
    
    public void add_expressionVar(Variable v){
        this.ExVars.add(v);
    }
    
}
