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
public interface StatementExpression extends AbstractSQLExpression {
    
    @Override   
    public Object interpret(Context context)throws InterpreteException;   
    
}
