/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.Arrays;

/**
 *
 * @author dell
 */
public class Domain {
    
    private final String[] ColourClass_names;
    private final String name;
    
    public Domain(String name, String[] classes){
        this.name = name;
        this.ColourClass_names = classes;
    }
    
    public int get_colour_index(String colour){
        return Arrays.binarySearch(this.ColourClass_names, colour);
    }
    
    public String get_name(){
        return this.name;  
    }
    
}
