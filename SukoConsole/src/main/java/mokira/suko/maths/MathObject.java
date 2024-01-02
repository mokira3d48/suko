/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author mokira3d48
 */
public abstract class MathObject {

//  public class Pattern {
//    protected String string;    // The regex string of this pattern
//    protected int minMatching;  // The minimum number of matching
//    protected int maxMatching;  // The maximum number of matching
//    
//    public Pattern() {
//      /**
//       * If the number of matching is equal -1, the number is not defined.
//       */
//      this.string = "";
//      this.minMatching = -1;
//      this.maxMatching = -1;
//    }
//    
//    /**
//     *
//     * @param string
//     * @param min
//     * @param max
//     */
//    public Pattern(String string, int min, int max) {
//      this();
//      this.string = string;
//      this.minMatching = min;
//      this.maxMatching = max;
//    }
//    
//    public String getString() {
//      return this.string;
//    }
//
//    public int getMinMatching() {
//      return this.minMatching;
//    }
//
//    public int getMaxMatching() {
//      return this.maxMatching;
//    }
//  }
  
  private static long idCounter = 0x0;
  protected long id;
  protected String tag;

  {
    this.id = idCounter; 
    idCounter += 1;
  }

  public String getTag() {
    return this.tag;
  }

//  public static Pattern getPatternString() {
//    if (patternString != null && !patternString.isEmpty())
//      return Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
//
//    return null;
//  }
//
//  public static boolean match(String str) {
//    Pattern pattern = getPatternString();
//    Matcher matcher = pattern.matcher(str);
//    return matcher.find();
//  }
  
  @Override
  public String toString() {
    return this.tag;
  }
}
