/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko;

/**
 *
 * @author mokira3d48
 */
public interface SukoCalculator {
  
  /**
   * Methode permettant d'effectuer le calcul contenu
   * dans la chaine de l'expression passee en argument.
   *
   * @param expr: L'expression sous forme de chaine.
   * @return Le résultat du calcul effectue.
   */
  public Double calculate(String expr);
  
}
