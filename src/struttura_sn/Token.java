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
    
    private final String value; //in case of domain token then it will be value1,value2,...
    private final ColourClass class_type ;
    private Place current_place;
   
    //can't be token of colour domain and colour class at the same time
    public Token(String value, ColourClass type){
        this.value = value;
        this.class_type = type;
    }
    
    public ColourClass get_type(){
        return this.class_type;
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
