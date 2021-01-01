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
public class ColourClass {
    
   private final String ColourClass_name;
   private final Token[] available_tokens;
   
   public ColourClass(String name, Token[] available_tokens){
       this.ColourClass_name = name;
       this.available_tokens = available_tokens;
   }
   
   public String get_colour_name(){
       return this.ColourClass_name;
   }
   
   public boolean is_available(Token t){
       return Arrays.binarySearch(available_tokens, t) >= 0;
   }
    
}
