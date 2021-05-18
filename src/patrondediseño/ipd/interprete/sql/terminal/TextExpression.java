/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete.sql.terminal;

import patrondediseño.ipd.interprete.sql.Context; 

/**
 *
 * @author INNOVA TEC
 */
public class TextExpression extends LiteralExpression {
    
    public TextExpression(String literal) {   
        super(literal);   
    }   
    
    @Override   
    public String interpret(Context context) {   
        return literal;   
    }   
    @Override   
    public String toString() {   
        return "'"+literal+"'";   
    }
    
}
