/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operazioni_XML;

/**
 *
 * @author dell
 */
public class XMLScanner {
    //Guard: \s*(!)?[(]*\s*[(]*predicate[)]*\s*[)]*(([&]{2}|[|]{2})[(]*\s*[(]*predicate[)]*\s*[)]*)*[)]*\s*
    //predicate: [(]*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*(<=|>=|<|>|=|!\s*=|\s+in\s+|\s*!\s*in\s+)\s*([_a-zA-Z]+[_a-zA-Z0-9]*)[)]*
    //Guard uses predicate:
    /* 
    \s*(!)?[(]*\s*[(]*([(]*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*(<=|>=|<|>|=|!\s*=|\s+in\s+|\s*!\s*in\s+)\s*
    ([_a-zA-Z]+[_a-zA-Z0-9]*)[)]*)[)]*\s*[)]*(([&]{2}|[|]{2})[(]*\s*[(]*()[(]*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*
    (<=|>=|<|>|=|!\s*=|\s+in\s+|\s*!\s*in\s+)\s*([_a-zA-Z]+[_a-zA-Z0-9]*)[)]*[)]*\s*[)]*)*[)]*\s* 
    */    
    //tuple: [&lt;]\s*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*[,]?(\s*([_a-zA-Z]+[_a-zA-Z0-9]*)\s*)*[&gt;]
    
}
