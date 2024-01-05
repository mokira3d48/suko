/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
public class Director {
  private Builder builder;
  
  public Director(Builder builder) {
    this.builder = builder;
  }
  
  public void changeBuilder(Builder newBuilder) {
    this.builder = newBuilder;
  }
  
  public void makeBuild() {
    this.builder.setLexicalMatchers();
    this.builder.setLexicalParsers();
    this.builder.setSyntaxMatchers();
    this.builder.setSyntaxParsers();
    this.builder.setExecuter();
  }
}
