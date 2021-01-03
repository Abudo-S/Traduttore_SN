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
    
    private final ColourClass[] ColourClasses;
    private final String name;
    
    public Domain(String name, ColourClass[] classes){
        this.name = name;
        this.ColourClasses = classes;
    }
    
    public int get_colour_index(ColourClass colour){
        return Arrays.binarySearch(this.ColourClasses, colour); // returns -1 if isn't found
    }
    
    public String get_name(){
        return this.name;  
    }
    
}
