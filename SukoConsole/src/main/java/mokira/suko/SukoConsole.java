/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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

    // configure the calculator with the
    // Context
    calc.setContext(ctx);

    // Display the result
    System.out.println(" Variable Values: " + "a=" + ctx.getValue("a")
        + ", b=" + ctx.getValue("b") + ", c=" + ctx.getValue("c")
        + ", d=" + ctx.getValue("d"));
    System.out.println(" Expression = (a+b)*(c-d)");
    System.out.println(" Result = " + calc.evaluate());

    Calculator calc1 = new Calculator();
    Context cty = new Context();
    cty.assign("a", 0);
    cty.assign("b", 12);
    cty.assign("c", 10);
    cty.assign("d", 65);
    cty.assign("e", 32);

    // set the expression to evaluate
    calc1.setExpression("a+b*c-d*d+e-d*(a+c)");

    // configure the calculator with the
    // Context
    calc1.setContext(cty);
    System.out.println(calc.evaluate());
  }

}
