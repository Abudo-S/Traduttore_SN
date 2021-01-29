/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operazioni_XML;

import java.util.ArrayList;
import java.util.HashMap;
import struttura_sn.*;

/**
 *
 * @author dell
 */
public class DataParser {
    
    private static SN sn;
    
    public DataParser(SN sn){
        DataParser.sn = sn;
    }
    //predicate: [(]*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*(<=|>=|<|>|=|!\s*=|\s+in\s+|\s*!\s*in\s+)\s*([_a-zA-Z]+[_a-zA-Z0-9]*)[)]*
    //Guard: (!)?[(]*\s*[(]*predicate[)]*\s*[)]*(([&]{2}|[|]{2})[(]*\s*[(]*predicate[)]*\s*[)]*)*[)]* 
     
    public void add_colourClass(String class_name, String[] available_tokens){
        sn.add_colourClass(new ColourClass(class_name, available_tokens));
    }
    
    public void add_colourClass(String class_name, String[] available_tokens, String[] subclasses_names, ArrayList<String[]> subclasses_tokens){
        ColourClass c = new ColourClass(class_name, available_tokens);
        
        for(var i = 0; i < subclasses_names.length; i++){
            c.add_subclass(c.new SubColourClass(subclasses_names[i], subclasses_tokens.get(i)));
            sn.add_colourClass(c);
        }
    }
    
    public void add_domain(String domain_name, String[] Colourclasses_names){
        sn.add_domain(new Domain(domain_name, this.extract_colourclasses(Colourclasses_names)));
    }
    
    private ColourClass[] extract_colourclasses(String[] Colourclasses_names){
        ColourClass[] classes = new ColourClass[Colourclasses_names.length];
        
        for(var i = 0; i < Colourclasses_names.length; i++){
            classes[i] = sn.find_colourClass(Colourclasses_names[i]);
        }
        return classes;
    }
    
    public void add_variable(String variable_name, String class_name){
        sn.add_variable(new Variable(variable_name,sn.find_colourClass(class_name)));
    }
    
    public void add_place(String place_name, String ColourClass_name){
       sn.add_place(new Place(place_name, sn.find_colourClass(ColourClass_name)));
    }
    
    //note: Case (normal_arch)-> "from/to" can be a place name or a transiton name
    //note: Case (inhibitor)-> "from" will be a place name, "to" will be a transition name
    public void connect_nodes_via_arc(String from, String to, String arc_type, String arc_name) throws NullPointerException{
        Place p;
        Transition t;
        
        switch(arc_type){
            
            case "tarc": 
                TArc arc = new TArc(arc_name, 0); //lvl 0 will be modified                
                p = sn.find_place(from);
                if(p == null){
                    t = sn.find_transition(from);
                    p = sn.find_place(to);
                    t.add_next_Node(arc, p);
                    sn.update_nodes_via_arc(p, t);
                }else{ 
                    t = sn.find_transition(to);
                    p.add_next_Node(arc, t);
                    sn.update_nodes_via_arc(p, t);
                }
            case "inhibitor":
                Inhibitor inb = new Inhibitor(arc_name, 0); //lvl 0 will be modified
                p = sn.find_place(from);
                t = sn.find_transition(to);
                p.add_next_Node(inb, t);
                sn.update_nodes_via_arc(p, t);
                
            default:
                throw new NullPointerException("Arc type isn't found: "+arc_type);
        }
    }
    
    public void add_arc_guard(){
        
    }
    
    public void add_arc_muliplicity(){
        
    }
    
    //for coloured/neutral places
    public void add_initial_Marking(String place_name, String[] tokens_names, int[] multiplicity){
        try{
            Place p = sn.find_place(place_name);
            ColourClass place_typeC = sn.find_colourClass(p.get_type());
            Token[] tokens = new Token[tokens_names.length];

            for(var i = 0; i< tokens.length; i++){
                tokens[i] = place_typeC.find_token(tokens_names[i]);
            }

            Marking m0 = new Marking();
            m0.mark_place(p, tokens, multiplicity);
            sn.set_initial_marking(m0);   
            
        }catch(Exception e){
            System.out.println(e + " ,Can't mark " + place_name);
        }
    }
    
    //for domained places
    public void add_initial_marking(String place_name, String[][] tokens_names, int[] multiplicity){
        
        try{
            Place p = sn.find_place(place_name);
            ColourClass place_typeC = sn.find_colourClass(p.get_type());
            Token[][] tokens = new Token[tokens_names.length][tokens_names[0].length];
            
            for(var i = 0; i< tokens.length; i++){
                for(var j = 0; j< tokens[i].length; j++){
                    tokens[i][j] = place_typeC.find_token(tokens_names[i][j]);
                }
            }
            Marking m0 = new Marking();
            m0.mark_place(p, tokens, multiplicity);
            sn.set_initial_marking(m0);   
            
        }catch(Exception e){
            System.out.println(e + " ,Can't mark " + place_name);
        }
    }
    
    public SN get_sn(){
        return sn;
    }
}
