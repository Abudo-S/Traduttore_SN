/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public class Inhibitor extends Arc{
    
    public Inhibitor(String name, int lvl){
        this.name = name;
        this.level = lvl;
        this.multiplied_arc = new HashMap<>();
        this.guard_classORdomain = new ArrayList<>();
    }
    
}
