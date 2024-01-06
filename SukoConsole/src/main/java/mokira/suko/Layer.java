/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.ArrayList;
import java.util.List;
import mokira.suko.maths.Variable;
import mokira.suko.maths.ops.Operation;

/**
 *
 * @author mokira3d48
 */
public class Layer extends ArrayList<Operation> {

	/**
	 * Fonction de calcule des operations contenu dans une couche
	 * @throws Exception
	 */
	public void eval() throws Exception {
		for (Operation op: this)
			op.eval();
	}

	/**
	 * Fonction d'optention de la liste des variables de soirtie
	 * @return liste des variables de retour de chaque operation de cette couche.
	 */
	public List<Variable> getOutputs() {
		List<Variable> outputs = new ArrayList<>();
		for (Operation op: this)
			outputs.add(op.getReturned());
		
		return outputs;
	}
	
}
