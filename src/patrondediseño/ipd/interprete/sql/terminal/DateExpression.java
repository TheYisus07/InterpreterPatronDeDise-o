/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete.sql.terminal;

import java.text.SimpleDateFormat;     
import patrondediseño.ipd.interprete.sql.Context;     
import patrondediseño.ipd.interprete.sql.InterpreteException;   

/**
 *
 * @author INNOVA TEC
 */
public class DateExpression extends LiteralExpression {
    public DateExpression(String literal) {     
        super(literal);     
    }     
    @Override     
    public Object interpret(Context context) throws InterpreteException {     
        try {     
            SimpleDateFormat dateFormat = context.getDateFormat();     
            return dateFormat.parse(literal);     
        } catch (Exception e) {     
            throw new InterpreteException("Formato de fecha inválido '"+literal+"'");    
        }     
    }     
    
    @Override     
    public String toString() {     
        return "'"+literal+"'";     
    }
    
}
