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
public class SN {
    
    private static ArrayList<Place> P = new ArrayList<>();
    private static ArrayList<Transition> T = new ArrayList<>();
    private static ArrayList<ColourClass> C = new ArrayList<>();
    private static ArrayList<Domain> DC = new ArrayList<>();
    private static ArrayList<Variable> V = new ArrayList<>();
    private static Marking m0;
    
    public SN(){
       
    }
    
    public void add_place(Place p){
        SN.P.add(p);
    }
    
    public void add_transition(Transition t){
        SN.T.add(t);
    }
    
    public void add_colourClass(ColourClass c){
        SN.C.add(c);
    }
    
    public void add_domain(Domain d){
        SN.DC.add(d);
    }
    
    public void add_variable(Variable v){
        SN.V.add(v);
    }
    
    public void set_initial_marking(Marking m0){
        SN.m0 = m0;
    }
    
    public Place find_place(String place_name){
        
        for (Place p : SN.P) {
            if(p.get_name().equals(place_name)){
                return p;
            }
        }
        return null;
    }
    
    public Transition find_transition(String transition_name){
        
        for(Transition t : SN.T){
            if(t.get_name().equals(transition_name)){
                return t;
            }
        }
        return null;
    }
    
    public ColourClass find_colourClass(String name){
        
        for(ColourClass c : SN.C){
            if(c.get_colour_name().equals(name)){
                return c;
            }
        }
        return null;
    }
    
    public Domain find_domain(String domain_name){
        
        for(Domain d : SN.DC){
            if(d.get_name().equals(domain_name)){
                return d;
            }
        }
        return null;
    }
    
    public Variable find_variable(String variable_name){
        
        for(Variable v : SN.V){
            if(v.get_name().equals(variable_name)){
                return v;
            }
        }
        return null;
    }
    
    public Marking get_initial_marking(){
        return SN.m0;
    }
    
}
