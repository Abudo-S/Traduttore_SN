/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author dell
 */
public abstract class Arc {
    
    protected String name;
    protected int level;
    protected ArrayList<Guard> guard_classORdomain; //[guard]<variable> || [guard]<variable,variable,...> 
    protected HashMap<Variable[], Integer> multiplied_arc; //<variable> case of colourClass|| <variable,variable,...> case of domain
    
    public void add_guard_colourClassORdomain(Guard g){
        this.guard_classORdomain.add(g);
    }
    
    public void add_mult_varOfcolourClass(Variable v, int mult){ //ex: 2<x>
        this.multiplied_arc.put(new Variable[]{v}, mult);
    }
    
    public void add_mult_varsOfdomain(Variable[] vars, int mult){ //ex: 2<x,y>
        this.multiplied_arc.put(vars, mult);
    }
    
    public ArrayList<Guard> get_guards(){
        return this.guard_classORdomain;
    }
    
    public HashMap<Variable[], Integer> arc_multiplicity(){
        return this.multiplied_arc;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public int get_level(){
        return this.level;
    }
}
