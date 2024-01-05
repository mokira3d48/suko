/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.lexical;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mokira.suko.compiler.analysers.MathObjectAnalyser;

import mokira.suko.compiler.Context;
import mokira.suko.compiler.base.Handler;
import mokira.suko.maths.MathObject;

/**
 *
 * @author mokira3d48
 */
public class LexicalParsing implements Handler<String, Context, MathObject[]> {
  private final MathObjectAnalyser[] patterns;

  public LexicalParsing(MathObjectAnalyser[] patterns) {
    this.patterns = patterns;
  }

  /**
   *
   * @param input
   * @param context
   * @return
   */
  @Override
  public MathObject[] process(String input, Context context) {
    List<MathObject> tokensList = new ArrayList<>();
    String[] parts = (String[])context.get("stringsArray");
    String temp = "";
    MathObjectAnalyser prevAnalyser = null;

    for (int i = 0; i < parts.length; i++) {
      for (MathObjectAnalyser analyser: this.patterns) {
        if (analyser.match(parts[i])) {
          if (analyser == prevAnalyser){
            temp += parts[i];
          }
          else {
            if (!temp.isEmpty())
              tokensList.add(prevAnalyser.parse(temp));
            temp = parts[i];
            prevAnalyser = analyser;
            // System.out.println(tokensList.toString());
            // System.out.println("------------------");
          }
        }
      }
    }

    if (!temp.isEmpty())
      tokensList.add(prevAnalyser.parse(temp));

    return this.toArray(tokensList);
  }

  private MathObject[] toArray(List<MathObject> list) {
    MathObject[] elements = new MathObject[list.size()];
    for (int i = 0; i < list.size(); i ++)
      elements[i] = list.get(i);

    return elements;
  }
}
