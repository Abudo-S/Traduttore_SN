/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.HashMap;

/**
 *
 * @author dell
 */
public class Place extends Node{
    
    
    public Place(String name){
        this.name = name;
        this.Next = new HashMap();
        this.previous = new HashMap();
    }
    
    //next/previous node of a place is a transition
    //next arc of a place might be an inhibitor or a transitioning arc
    public void add_next_Node(Arc arc, Transition t){
        this.Next.put(arc, t);
    }
    
    //previous arc of a place is a transitioning arc
    public void add_previous_Node(TArc arc, Transition t){
        this.previous.put(arc, t);
    }
    
    public Node get_next_by_Arc(Arc arc){
        return this.Next.get(arc);
    }
    
    public Node get_previous_by_Arc(TArc arc){
        return this.previous.get(arc);
    }
}
