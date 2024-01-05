/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

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
  public boolean lexMatch(String str) {
    Pattern pattern = getPatternString();
    Matcher matcher = pattern.matcher(str);
    return matcher.find();
  }

  /**
   *
   * @param str
   * @return
   */
  public abstract MathObject lexParse(String str);

  /**
   * Function to perform syntax matching
   *
   * @param moSeq
   * @param pos
   * @return
   */
  public abstract boolean synMatch(MathObject[] moSeq, int pos);

  /**
   * Function to perform lexical matching
   *
   * @param moSeq
   */
  public abstract void synParse(MathObject[] moSeq);
}
