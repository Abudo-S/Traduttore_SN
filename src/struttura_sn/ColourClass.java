/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dell
 */
public class ColourClass {
    
   private final String ColourClass_name;
   private final Token[] available_tokens; // tokens that don't belong to a subclass
   private ArrayList<SubColourClass> subClasses;
   //private HashMap<String, Token[]> Sub_classes; // each subclass has a finite set of colors 
   
   public ColourClass(String name, String[] available_token_values){
       this.ColourClass_name = name;
       this.available_tokens = new Token[available_token_values.length];
       this.create_available_tokens(available_token_values);
       this.subClasses = new ArrayList<>();
       //this.Sub_classes = new HashMap<>();
   }
   
   public String get_colour_name(){
       return this.ColourClass_name;
   }
   
   public boolean is_available(Token t){
       return Arrays.binarySearch(available_tokens, t) >= 0;
   }
   
   public Token[] get_tokens(){
       return this.available_tokens;
   }
   
   private void create_available_tokens(String[] values){
       for(var i=0; i<values.length; i++){
           this.available_tokens[i] = new Token(values[i], this);
       }
   }
   
//   public void add_subclass(String subclass_name, Token[] tokens){
//       this.Sub_classes.put(subclass_name, tokens);
//   }
//   
//   public Token[] get_tokens_of_subclass(String subclass_name){
//       return this.Sub_classes.get(subclass_name);
//   }
//   
//   public HashMap<String, Token[]> get_all_subclasses(){
//       return this.Sub_classes;
//   }
   
   public void add_subclass(SubColourClass sc){
       this.subClasses.add(sc);
   }
   
   private SubColourClass get_subClassByname(String subclass_name){
        for(SubColourClass sc : this.subClasses){
           if(sc.get_colour_name().equals(subclass_name)){
             return sc;
           }
        }
       return null;
   }
   
   public Token[] get_tokens_of_subclass(String subclass_name){
       try{
           return this.get_subClassByname(subclass_name).get_tokens();
       }catch(Exception e){
           System.out.println(e + " in ColourClass/get_tokens_of_subclass");
       }
       return null;
   }
   
   public Token find_token(String token_name){

       for(Token t : this.available_tokens){
           if(t.get_Token_value().equals(token_name)){
               return t;
           }
       }
       Token[] subtokens;
       for(SubColourClass subc : this.subClasses){
           subtokens = subc.get_tokens();
           for(Token t : subtokens){
               if(t.get_Token_value().equals(token_name)){
                    return t;
               }
           }
       }
       return null;
   }
   
   public boolean is_availableInSubclass(Token t, String subclass_name){
       return this.get_subClassByname(subclass_name).is_available(t);
   }
   
   public class SubColourClass extends ColourClass{

       public SubColourClass(String name, String[] available_token_values){
           super(name, available_token_values);
       }
       
       @Override
       public void add_subclass(SubColourClass sc) throws NullPointerException {
         throw new NullPointerException("Can't create subclasses from a subclass!"); 
       }
   }
   
}

