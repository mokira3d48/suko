/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
public interface Builder {
  
  public void reset();
  
  public void setLexicalMatchers();
  
  public void setLexicalParsers();
  
  public void setSyntaxMatchers();
  
  public void setSyntaxParsers();
  
  public void setSemanticMatchers();
  
  public void setExecuter();
}
