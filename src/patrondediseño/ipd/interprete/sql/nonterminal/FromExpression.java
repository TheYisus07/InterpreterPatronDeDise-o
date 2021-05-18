/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete.sql.nonterminal;

import patrondediseño.ipd.interprete.sql.*;
import patrondediseño.ipd.interprete.sql.terminal.*;

/**
 *
 * @author INNOVA TEC
 */
public class FromExpression implements AbstractSQLExpression {
    private LiteralExpression table;   
    
    public FromExpression(LiteralExpression from){   
        this.table = from;   
            }  
    @Override   
    public Object interpret(Context context)    
            throws InterpreteException{   
        String tableName =    
                table.interpret(context).toString();   
        if(!context.tableExist(tableName)){   
            throw new InterpreteException(   
                    "La tabla '"+tableName+"' no existe");   
        }   
        return null;   
    }   
    
    @Override   
    public String toString() {   
        return "FROM " + table.toString();   
    }
}
