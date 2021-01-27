/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operazioni_XML;

import java.util.ArrayList;
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
    
    public void add_place(){
       
    }
    
    public void add_transition(){
        
    }
    
    public void connect_nodes_via_arcs(){
        
    }
    
    public void create_Marking(){
        
    }
    
    public SN get_sn(){
        return sn;
    }
}
