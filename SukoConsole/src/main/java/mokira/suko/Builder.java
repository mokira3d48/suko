/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko;

/**
 *
 * @author mokira3d48
 */
public interface Builder<T> {

  public void reset();

  public void setOperators();

  public void setNonTerminalExpressions();

  public void setAnalyser();

  public T getResult();
}
