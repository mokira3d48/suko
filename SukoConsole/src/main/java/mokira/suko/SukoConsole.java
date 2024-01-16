/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * http://www.java2s.com/Code/Java/Design-Pattern/InterpreterPatternCalculator.htm
 */

package mokira.suko;

import mokira.suko.interpreter.SemanticError;


/**
 *
 * @author mokira3d48
 */
public class SukoConsole {

  public static void main(String[] args) {
    // Buildong of the calculator
    Builder<Calculator> b = new CalculatorBuilder();
    Director director = new Director(b);
    director.makeBuild(); 
    Calculator calc = b.getResult();

    // instantiate the context
    Context ctx = new Context();
    
    ctx.assign("alpha", 8);
    ctx.assign("x1", 0);
    ctx.assign("x2", 12);
    ctx.assign("x3", 10);
    ctx.assign("x4", 65);
    ctx.assign("x5", 32);
    ctx.assign("x6", 10);

    // set the expression to evaluate
    calc.setExpression("alpha + x2 * x3 - x4 * x4 + x4 * (x1 + alpha) + x5 / (x3 * x2)");

//    calc.setExpression("a+b*c-d*d+e-d*(a+c)");
//    
//    ctx.assign("a", 0);
//    ctx.assign("b", 12);
//    ctx.assign("c", 10);
//    ctx.assign("d", 65);
//    ctx.assign("e", 32);

    // configure the calculator with the
    // Context
    calc.setContext(ctx);

    // Display the result
    System.out.println(ctx);
    System.out.println("Expression = " + calc.getExpression());

    try {
      	Double result = calc.evaluate();
        System.out.println("Result = " + result.intValue());
    } catch (SemanticError e) {
      System.out.println("SemanticError: \t" + e);
    } catch (Exception e) {
      // System.out.println(e);
      e.printStackTrace();
    }
  }

}
