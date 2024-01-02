/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.atomic_analyser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import mokira.suko.maths.MathObject;

/**
 *
 * @author mokira3d48
 */
public abstract class MathObjectAnalyser {
  protected String patternString;
  
  /**
   *
   * @return
   */
  public Pattern getPatternString() {
    if (patternString != null && !patternString.isEmpty())
      return Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

    return null;
  }

  /**
   *
   * @param str
   * @return
   */
  public boolean match(String str) {
    Pattern pattern = getPatternString();
    Matcher matcher = pattern.matcher(str);
    return matcher.find();
  }
  
  /**
   *
   * @param str
   * @return
   */
  public abstract MathObject parse(String str);
}
