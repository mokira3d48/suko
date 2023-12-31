/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Handler;

/**
 *
 * @author mokira3d48
 */
public class LexicalParsing implements Handler<String, Context, String[]> {
  private final Pattern[] patterns;

  public LexicalParsing(Pattern[] patterns) {
    this.patterns = patterns;
  }

  /**
   *
   * @param input
   * @param context
   * @return
   */
  @Override
  public String[] process(String input, Context context) {
    List<String> tokensList = new ArrayList<>();
    String[] parts = (String[])context.get("stringsArray");
    String temp = "";
    boolean matched;
    Pattern prevPatt = null;

    for (int i = 0; i < parts.length; i++) {
      for (Pattern pattern: this.patterns) {
        Matcher matcher = pattern.matcher(parts[i]);
        matched = matcher.find();
        if (matched) {
          if (pattern == prevPatt){
            temp += parts[i];
          }
          else {
            tokensList.add(temp);
            temp = parts[i];
            prevPatt = pattern;
            // System.out.println(tokensList.toString());
            // System.out.println("------------------");
          }
        }
      }
    }
    
    if (!temp.isEmpty())
      tokensList.add(temp);

    return this.toArray(tokensList);
  }
  
  private String[] toArray(List<String> list) {
    String[] elements = new String[list.size()];
    for (int i = 0; i < list.size(); i ++)
      elements[i] = list.get(i);
    
    return elements;
  }

}
