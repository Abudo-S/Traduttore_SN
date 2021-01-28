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
public class DomainToken {
    private final Domain domain_type;
    private final Token[] value;
    
    public DomainToken(Domain domain_type, Token[] value){
        this.domain_type = domain_type;
        this.value = value;
    }
    
    public Domain get_type(){
        return this.domain_type;
    }
    
    public Token[] get_value(){
        return this.value;
    }
    
    public boolean is_token_available(Token t){
        return Arrays.binarySearch(value, t) >= 0;
    }
    
}
