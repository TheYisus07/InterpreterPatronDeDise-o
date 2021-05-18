/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete.sql.terminal;

import patrondediseño.ipd.interprete.sql.Context;   
import patrondediseño.ipd.interprete.sql.InterpreteException;   
import patrondediseño.ipd.interprete.sql.AbstractSQLExpression;  

/**
 *
 * @author INNOVA TEC
 */
public class LiteralExpression  implements AbstractSQLExpression {
    
    protected String literal;   
    public LiteralExpression(String literal) {   
        this.literal = literal;   
    }   
    @Override   
    public Object interpret(Context context) throws InterpreteException {   
        return literal;   
    }   
    @Override   
    public String toString() {   
        return literal;   
    }  
    
}
