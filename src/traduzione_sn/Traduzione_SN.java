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
        
        Transition t0 = new Transition("t0", new Guard(false));
        Transition t1 = new Transition("t1", new Guard(false));
        Transition t2 = new Transition("t2", new Guard(false));
        p0.add_next_Node(new TArc("arc0",0),t0);
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
        
        
        sn.SN_all_data();
        
    }
    
}
