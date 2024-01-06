/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths.ops;

import mokira.suko.maths.MathObject;
import mokira.suko.maths.Variable;

/**
 *
 * @author mokira3d48
 */
public abstract class Operation extends MathObject {
  protected Variable returned;

	/**
	 * Retourn la valeur de returned
	 * @return this.returned
	 */
	public Variable getReturned() {
		return this.returned;
	}

	/**
	 * Fontion abtraite destiner a realiser le calcul de l'operation 
	 * @throws Exception
	 */
	public abstract void eval() throws Exception;

}
