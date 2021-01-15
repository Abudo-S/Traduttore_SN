/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traduzione_sn;

import java.util.Arrays;
import struttura_sn.*;

/**
 *
 * @author dell
 */
public class Traduzione_SN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creation of SN test 
         SN sn = new SN();
        //Token[] tokens_Processo = new Token[]{new Token("p1"), new Token("p2"), new Token("p3")}; 
        //Token[] tokens_Risorsa = new Token[]{new Token("r1"), new Token("r2"), new Token("r3")}; 
        ColourClass c1 = new ColourClass("Processo", new String[]{"p1", "p2", "p3"});
        ColourClass c2 = new ColourClass("Risorsa", new String[]{"r1", "r2", "r3"});
        //Arrays.stream(tokens_Processo).map(x -> x.set_type(c1));
        sn.add_colourClass(c1);
        sn.add_colourClass(c2);
        Domain d = new Domain("PD", new ColourClass[]{c1,c2});
        sn.add_domain(d);
        Variable x = new Variable("x1", c1);
        Variable y1 = new Variable("y1", c2);
        Variable y2 = new Variable("y2", c2);
        sn.add_variable(x);
        sn.add_variable(y1);
        sn.add_variable(y2);
        Place p0 = new Place("p0", c1);
        Place p1 = new Place("p1", c1);
        Place p2 = new Place("p2", d);
        Place p3 = new Place("p3", d);
        Place p4 = new Place("p4", c2);
        Place p5 = new Place("p5", c2);
        Place p6 = new Place("p6", c1);
        
        Guard guard = new Guard(false);
        Predicate p = new Predicate(y1, "!=", y2, false);
        guard.add_predicate(p);
        
        Transition t0 = new Transition("t0", guard);
        Transition t1 = new Transition("t1", new Guard(false));
        Transition t2 = new Transition("t2", new Guard(false));
        
        Arc arc0 = new TArc("arc0",0);
        arc0.add_mult_varOfcolourClass(x,1);
        
        Arc arc1 = new TArc("arc1",0);
        arc1.add_mult_varOfcolourClass(y1, 1);
        arc1.add_mult_varOfcolourClass(y2, 1);
        
        TArc arc2 = new TArc("arc2",1);
        arc2.add_mult_varOfcolourClass(x,1);
        
        TArc arc3 = new TArc("arc3",1);
        arc3.add_mult_varOfcolourClass(y1, 1);
        arc3.add_mult_varOfcolourClass(y2, 1);
        
        Arc arc4 = new TArc("arc4",2);
        arc4.add_mult_varOfcolourClass(x,1);
        
        Arc arc5 = new TArc("arc5",2);
        arc5.add_mult_varOfcolourClass(y1, 1);
        arc5.add_mult_varOfcolourClass(y2, 1);
        
        TArc arc6 = new TArc("arc6",3);
        arc6.add_mult_varsOfdomain(new Variable[]{x, y1}, 1);
        
        Arc arc7 = new TArc("arc7",4);
        arc7.add_mult_varsOfdomain(new Variable[]{x, y1}, 1);
        
        Arc arc8 = new Inhibitor("arc8",4);
        arc8.add_mult_varOfcolourClass(x,2);
        
        TArc arc9 = new TArc("arc9",5);
        arc9.add_mult_varsOfdomain(new Variable[]{x, y1}, 1);
        
        t0 = p0.add_next_Node(arc0,t0);
        t0 = p4.add_next_Node(arc1,t0);
        
        p1 = t0.add_next_Node(arc2, p1);
        p5 = t0.add_next_Node(arc3, p5);
         
        t1 = p1.add_next_Node(arc4,t1);
        t1 = p5.add_next_Node(arc5,t1);
        
        p2 = t1.add_next_Node(arc6, p2);
        
        t2 = p2.add_next_Node(arc7,t2);
        t2 = p6.add_next_Node(arc8,t2);
        
        p3 = t2.add_next_Node(arc9, p3);
        
        Marking m0 = new Marking();
        
        Token[] tokens_p1 = new Token[]{new Token("p1",c1), new Token("p2",c1)}; 
        Token[] tokens_p4 = new Token[]{new Token("p1",c1), new Token("p2",c1)}; 
        Token[] tokens_p6 = new Token[]{new Token("p1",c1), new Token("p2",c1)}; 
        m0.mark_place(p1, tokens_p1, new int[]{1,1});
        m0.mark_place(p4, tokens_p4, new int[]{2,2});
        m0.mark_place(p6, tokens_p6, new int[]{1});
        
        sn.add_place(p0);
        sn.add_place(p1);
        sn.add_place(p2);
        sn.add_place(p3);
        sn.add_place(p4);
        sn.add_place(p5);
        sn.add_place(p6);
        sn.add_transition(t0);
        sn.add_transition(t1);
        sn.add_transition(t2);
        sn.set_initial_marking(m0);
        
        sn.SN_all_data();
        
    }
    
}
