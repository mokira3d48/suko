/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Handler;

/**
 *
 * @author mokira3d48
 */
public class Preprocess implements Handler<String, Context, String> {

  @Override
  public String process(String input, Context context) {
    String returned = "";
    char characters;
    for (int i = 0; i < input.length(); i++) {
      characters = input.charAt(i);
      switch (input.charAt(i)) {
        case 'x':
          returned += '*';
          break;
        default:
          returned += characters;
      }
    }

    return returned;
  }
  
 
  
}
