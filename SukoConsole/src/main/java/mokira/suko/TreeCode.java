/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.ArrayList;
import java.util.List;
import mokira.suko.maths.Variable;

/**
 *
 * @author mokira3d48
 */
public class TreeCode extends ArrayList<Layer> {
	
	public List<Variable> getOutputs() {
		List<Variable> outputs = this.get(this.size() - 1).getOutputs();
		return outputs;
	}

	/**
	 * Fonction d'evaluation des couches d'operation contenu dans l'abre de calcul
	 * @throws Exception
	 */
	public void eval() throws Exception {
		for (Layer layer: this)
			layer.eval();
	}

}
