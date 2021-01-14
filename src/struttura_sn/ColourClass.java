/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public class ColourClass {
    
   private final String ColourClass_name;
   private final Token[] available_tokens;
   private HashMap<String, Token[]> Sub_classes; // each subclass has a finite colors 
   
   public ColourClass(String name, String[] available_token_values){
       this.ColourClass_name = name;
       this.available_tokens = new Token[available_token_values.length];
       this.create_available_tokens(available_token_values);
   }
   
   public String get_colour_name(){
       return this.ColourClass_name;
   }
   
   public boolean is_available(Token t){
       return Arrays.binarySearch(available_tokens, t) >= 0;
   }
   
   private void create_available_tokens(String[] values){
       for(var i=0; i<values.length; i++){
           this.available_tokens[i] = new Token(values[i], this);
       }
   }
   
   public void add_subclass(String subclass_name, Token[] tokens){
       this.Sub_classes.put(subclass_name, tokens);
   }
   
   public Token[] get_tokens_of_subclass(String subclass_name){
       return this.Sub_classes.get(subclass_name);
   }
   
   public HashMap<String, Token[]> get_all_subclasses(){
       return this.Sub_classes;
   }
}
