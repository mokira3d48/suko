/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Handler;


/**
 *
 * @author mokira3d48
 */
public class ExpressionMatcher implements Handler<String, Context, Boolean> {
  private final Pattern[] patterns;

  public ExpressionMatcher(Pattern[] patterns) {
    this.patterns = patterns;
  }

  /**
   * Function of lexical matching
   *
   * @param input
   * @param context
   * @return True, if lexical matching is success, otherwise False.
   * @throws LexicalError
   */
  @Override
  public Boolean process(String input, Context context) throws LexicalError {
    // throw new UnsupportedOperationException("Not supported yet.");
    // Pattern pattern = Pattern.compile("[0-9]?", Pattern.CASE_INSENSITIVE);
    // Matching for each pattern in patterns list
    String[] parts = input.split("");
    boolean matched = true;
    for (String charString: parts) {
      for (Pattern pattern: this.patterns) {
        Matcher matcher = pattern.matcher(charString);
        matched = matcher.find();
        if (matched)
          break;
      }

      if (!matched)
        throw new LexicalError(charString + " is not permuted.");
    }

    context.put("stringsArray", parts);
    return true;
  }
}
