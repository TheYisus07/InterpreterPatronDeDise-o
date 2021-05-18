/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondediseño.ipd.interprete;

import java.text.SimpleDateFormat;   
import java.util.*;   
import patrondediseño.ipd.interprete.sql.*;   
import patrondediseño.ipd.interprete.sql.nonterminal.*;   
import patrondediseño.ipd.interprete.sql.terminal.*; 

/**
 *
 * @author INNOVA TEC
 */
public class Interprete {
 public static void main(String[] args) {   
     //Arbol Sintactico Abstracto   
     SelectExpression select = getById();   
     System.out.println(select.toString());  
     Context context = new Context("META_INF/Employee.xls");   
     context.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));   
     try {   
         List<Object[]> output = select.interpret(context);   
         for (Object[] object : output) {   
             System.out.println(Arrays.toString(object));   
         }   
     } catch (InterpreteException e) {   
         e.printStackTrace();   
     } finally {

         context.destroy();   
     }   
 }   
 
 public static SelectExpression getById() {   
     SelectExpression select = new SelectExpression(   
             new TargetExpression(   
                     new LiteralExpression("FIRST_NAME"),   
                     new LiteralExpression("LAST_NAME")   
             ),   
             new FromExpression(
                    new LiteralExpression("EMPLOYEES")),   
             new WhereExpression(   
                     new BooleanExpression(   
                            new LiteralExpression("ID"),   
                            new LiteralExpression("="),   
                            new NumericExpression(10)   
                    )   
            )   
    );   
    return select;   
}   

public static SelectExpression findByDate() {   
    SelectExpression select = new SelectExpression(   
            new TargetExpression(   
                    new LiteralExpression("ID"),   
                    new LiteralExpression("BORN_DATE"),   
                    new LiteralExpression("DEPARTMENT"),
                    new LiteralExpression("FIRST_NAME"),   
                    new LiteralExpression("LAST_NAME")
            ),


                    new FromExpression(   
                            new LiteralExpression("EMPLOYEES")),   
                    new WhereExpression(
                             new BooleanExpression(   
                                     new LiteralExpression("BORN_DATE"),   
                                     new LiteralExpression(">"),   
                                     new DateExpression("01/01/1990")   
                             )   
                    )   
            );   
    return select;   
}
public static SelectExpression findByTwoID() {   
    SelectExpression select = new SelectExpression(   
            new TargetExpression(   
                    
                    new LiteralExpression("FIRST_NAME"),   
                    new LiteralExpression("DEPARTMENT"),
                     new LiteralExpression("ID")   
            ),

            new FromExpression(   
                    new LiteralExpression("EMPLOYEES")),   
            new WhereExpression( 
                            new OrExpression(   
                                    new BooleanExpression(   
                                            new LiteralExpression("ID"),   
                                            new LiteralExpression("="),   
                                            new NumericExpression(5)   
                                    ),   
                                    new BooleanExpression(   
                                            new LiteralExpression("ID"),   
                                            new LiteralExpression("="),   
                                            new NumericExpression(14)   
                                    )   
                            )   
                    )   
            );   
    return select;   
}   

public static SelectExpression complexQuery() {   
    SelectExpression select = new SelectExpression(   
            new TargetExpression(   
                    new LiteralExpression("FIRST_NAME"),   
                    
                    new LiteralExpression("LAST_NAME")   
            ),   
            new FromExpression(   
                    new LiteralExpression("EMPLOYEES")),   
            new WhereExpression(   
                    new AndExpression(   
                            new BooleanExpression(   
                                    
                                    new LiteralExpression("STATUS"),   
                                    new LiteralExpression("="),   
                                    new TextExpression("Activo")   
                            ),   
                            new AndExpression(   
                                    new BooleanExpression(   
                                            new LiteralExpression("BORN_DATE"),   
                                            new LiteralExpression("<="),   
                                            new DateExpression("01/01/1981")   
                                    ),   
                                    new OrExpression(   
                                            new BooleanExpression(   
                                                    new LiteralExpression("DEPARTMENT"),   
                                                    new LiteralExpression("="),   
                                                    new TextExpression("Sistemas")   
                                            ),   
                                            new BooleanExpression(   
                                                    new LiteralExpression("DEPARTMENT"),   
                                                    new LiteralExpression("="),   
                                                    new TextExpression("Contabilidad")   
                                            )   
                                    )   

                            )   
                    )   
            )   
    );   
    return select;   
}
    
}
