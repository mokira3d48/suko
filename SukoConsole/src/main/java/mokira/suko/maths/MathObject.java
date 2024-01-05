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
  
  @Override
  public String toString() {
    return this.tag;
  }
}
