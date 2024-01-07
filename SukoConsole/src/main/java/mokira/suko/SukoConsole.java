/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * http://www.java2s.com/Code/Java/Design-Pattern/InterpreterPatternCalculator.htm
 */

package mokira.suko;

/**
 *
 * @author mokira3d48
 */
public class SukoConsole {

  public static void main(String[] args) {
    Calculator calc = new Calculator();
    // instantiate the context
    Context ctx = new Context();

    // set the expression to evaluate
    calc.setExpression("a+b*c-d*d+e-d*(a+c)");
    
    ctx.assign("a", 0);
    ctx.assign("b", 12);
    ctx.assign("c", 10);
    ctx.assign("d", 65);
    ctx.assign("e", 32);

    // configure the calculator with the
    // Context
    calc.setContext(ctx);

    // Display the result
    System.out.println(ctx);
    System.out.println(" Expression = " + calc.getExpression());
    System.out.println(" Result = " + calc.evaluate());
  }

}
