/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struttura_sn;

/**
 *
 * @author dell
 */
public class Token {
    
    private final String name;
    private ColourClass class_type = null;
    private Domain domain_type = null;
    private Place current_place;
    
    //can't be token of colour domain and colour class at the same time
    public Token(String name, ColourClass type){
        this.name = name;
        this.class_type = type;
    }
    
    public Token(String name, Domain type){
        this.name = name;
        this.domain_type = type;
    }
    
    public Object get_type(){
        return (this.class_type == null) ? this.domain_type : this.class_type;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public Place current_place(){
        return this.current_place;
    }
    
    
}
