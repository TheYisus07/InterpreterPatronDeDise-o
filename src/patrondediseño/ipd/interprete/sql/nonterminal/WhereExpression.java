/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete.sql.nonterminal;

import patrondediseño.ipd.interprete.sql.*;  

/**
 *
 * @author INNOVA TEC
 */
public class WhereExpression implements AbstractSQLExpression {
    
    private StatementExpression statement;   
     
    public WhereExpression(StatementExpression statement) {   
        this.statement = statement;   
    }   
    
    @Override   
    public Void interpret(Context context) throws InterpreteException {   
        context.createRowIterator();   
        while (context.nextRow()) {   
            if (statement == null) {   
                context.addCurrentRowToResults();   
            } else {   
                Boolean result = (Boolean) statement.interpret(context);   
                if (result) {   
                    context.addCurrentRowToResults();   
                }   
            }   
        }   
        return null;   
    }   
    
    @Override   
    public String toString() {   
        if (statement != null) {   
            return "WHERE " + statement.toString();   
        } else {   
            return "";   
        }   
    }
    
}
