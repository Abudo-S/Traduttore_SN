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
    protected ArrayList<Guard> guard_classORdomain; //[guard]<variable> || [guard]<variable,variable,...> 
    protected ArrayList<Integer> multiplicity; 
    protected ArrayList<Variable[]> vars; //<variable> case of colourClass|| <variable,variable,...> case od domain
    
    public void add_guard_colourClassORdomain(Guard g){
        this.guard_classORdomain.add(g);
    }
    
    public void add_mult_varOfcolourClass(Variable v, int mult){ //ex: 2<x>
        this.vars.add(new Variable[]{v});
        this.multiplicity.add(mult);
    }
    
    public void add_mult_varsOfdomain(Variable[] vars, int mult){ //ex: 2<x,y>
        this.vars.add(vars);
        this.multiplicity.add(mult);
    }
    
    public ArrayList<Guard> get_guards(){
        return this.guard_classORdomain;
    }
    
    public ArrayList<Integer> get_mult(){
        return this.multiplicity;
    }
    
    public ArrayList<Variable[]> get_vars(){
        return this.vars;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public int get_level(){
        return this.level;
    }
}
