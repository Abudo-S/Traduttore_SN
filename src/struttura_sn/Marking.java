/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author dell
 */
public class Marking {
    
    private HashMap<Place, HashMap<Token, Integer>> marking; // place -> token of multiplicity n
    
    public Marking(){
        this.marking = new HashMap<>();
    }
    
    public void mark_place(Place p, Token[] tokens, int[] multiplicity){
        HashMap<Token, Integer> mark = new HashMap<>();
        
        for(var i=0; i<multiplicity.length;i++ ){
            mark.put(tokens[i], multiplicity[i]);
        }
        this.marking.put(p, mark);
    }
    
    public Set<Place> get_all_marked_Places(){
        return this.marking.keySet();
    }
    
    public HashMap<Token, Integer> get_marking_of_place(Place p){
        return this.marking.get(p);
    }
}
