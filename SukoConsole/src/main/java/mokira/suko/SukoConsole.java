/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * http://www.java2s.com/Code/Java/Design-Pattern/InterpreterPatternCalculator.htm
 */

package mokira.suko;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

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
    calc.setExpression("code + x2 * x3 - x4 * x4 + x4 * (x1 + code) + x6");

    calc.getVariableNames().add("x1");
    calc.getVariableNames().add("x2");
    calc.getVariableNames().add("x3");
    calc.getVariableNames().add("x4");
    calc.getVariableNames().add("x5");
    calc.getVariableNames().add("x6");
    calc.getVariableNames().add("code");

    ctx.assign("x1", 0);
    ctx.assign("x2", 12);
    ctx.assign("x3", 10);
    ctx.assign("x4", 65);
    ctx.assign("x5", 32);
    ctx.assign("code", 12);
    ctx.assign("x6", 10);

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
    System.out.println(" Expression = " + calc.getExpression());
    System.out.println(" Result = " + calc.evaluate());

//    String expr = "x1x2x1x3";
//		Pattern pattern = Pattern.compile("x1", Pattern.CASE_INSENSITIVE);
//		Matcher matcher = pattern.matcher(expr);
//		matcher.results().forEach(e -> System.out.println(e.));
  }

}
