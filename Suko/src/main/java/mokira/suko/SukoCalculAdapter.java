/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mokira.suko.calc.Builder;
import mokira.suko.calc.Calculator;
import mokira.suko.calc.CalculatorBuilder;
import mokira.suko.calc.Context;
import mokira.suko.calc.Director;


/**
 *
 * @author mokira3d48
 */
public class SukoCalculAdapter implements SukoCalculator {
  private Calculator calculator;
  
  public SukoCalculAdapter() {
    // Buildong of the calculator
    Builder<Calculator> b = new CalculatorBuilder();
    Director director = new Director(b);
    director.makeBuild(); 
    this.calculator = b.getResult();
  }

  private static List<String> getTerms(String expr) {
    List<String> termsFound = new ArrayList<>();
    Pattern pattern = Pattern.compile("^-[0-9]+|[0-9]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(expr);
    matcher.results().forEach(e -> termsFound.add(expr.substring(e.start(), e.end())));
    return termsFound;
  }
  
  private static String getVarNameFrom(int index) {
    String varName = "";

    if (index < 26){
      char letter = (char)(index + 64);
      varName += letter;
    }
    else {
      int rest = 0;
      int quot = 0;
      int divd = index;
      do {
				quot = (divd / 26);
        rest = divd - quot * 26;
        divd = quot;
        char letter = (char)(rest + 64);
        varName += letter;
      } while (quot > 0);
    }

    return varName;
  }

  private Map<String, String> transformTerm2Var(List<String> terms) {
    Map<String, String> varNames = new HashMap<>();
    for (int i = 0; i < terms.size(); i++) {
      varNames.put(getVarNameFrom(i + 1), terms.get(i));
    }

    return varNames;
  }

  private String mapValueToVar(String expr, Map<String, String> vars) {
    String exprResult = expr;
    for (Map.Entry<String, String> entry : vars.entrySet()) {
      exprResult = exprResult.replaceFirst(entry.getValue(), entry.getKey());
    }
    return exprResult;
  }

  @Override
  public Double calculate(String expr) throws Exception {
    // System.out.println("Original expression: \t" + expr);
    // Recuperer les termes de l'expression
    List<String> terms = getTerms(expr);
    // Transformer les termes en varibles x1=v1, x2=v2, ... xn=vn
    Map<String, String> vars = transformTerm2Var(terms);
    
    // Creation du context de calcule
    Context ctx = new Context();
    // System.out.println("-------------VARIABLES LIST -------------------------");
    for (Map.Entry<String, String> entry : vars.entrySet()) {
      String varName = entry.getKey();
      Double value = Double.valueOf(entry.getValue());

      ctx.assign(varName, value);
      // System.out.println(varName + " = " + value);
    }
    
    // Remplacer les valeurs par leur nom de variables respectives
    // dans l'expression originelle
    String exprMapped = mapValueToVar(expr, vars);
    // System.out.println("Mapped expression: \t" + exprMapped);

    // Renseigner l'expression a evaluer
    this.calculator.setEquation(exprMapped);

    //
    this.calculator.setContext(ctx);

    Double doubleResult = this.calculator.evaluate();
    String longResult = "" + Math.round(doubleResult.doubleValue());
    return Double.valueOf(longResult);
  }

}
