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
    
    private final String value;
    private ColourClass class_type = null;
    private Domain domain_type = null;
    private Place current_place;
   
    //can't be token of colour domain and colour class at the same time
    public Token(String value, ColourClass type){
        this.value = value;
        this.class_type = type;
    }
    
    public Token(String value, Domain type){
        this.value = value;
        this.domain_type = type;
    }
    
    public Object get_type(){
        return (this.class_type == null) ? this.domain_type : this.class_type;
    }
    
    public String get_Token_value(){
        return this.value;
    }
    
    public Place get_current_place(){
        return this.current_place;
    }
    /*
    public void set_type(ColourClass type) throws Exception{
        if(this.domain_type != null){
            throw new Exception("Type conflict: Trying to assign same token to different types");
        }
        this.class_type = type;
    }
    
    public void set_type(Domain type) throws Exception{
        if(this.class_type != null){
            throw new Exception("Type conflict: Trying to assign same token to different types");
        }
         this.domain_type = type;
    }
    */
    
    
}
