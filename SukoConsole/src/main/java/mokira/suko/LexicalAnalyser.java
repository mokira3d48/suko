/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mokira.suko.maths.MathObject;

/**
 *
 * @author mokira3d48
 */
public class LexicalAnalyser implements Handler<String, List<MathObject>> {
	Map<Pattern, Function<String, MathObject>> config;

	public LexicalAnalyser(Map<Pattern, Function<String, MathObject>> config) {
		this.config = config;
	}

  @Override
  public List<MathObject> process(String input) throws Exception {
		List<MathObject> sequence = new ArrayList<>(); // liste des objets mathematiques
		Pattern prevPatt = null;											 // Le pattern qui a matche le caractere precedent
		String matchedSeq = "";												 // La chaine matchee
		boolean noPattMatched = true;									 // Indique qu'aucun pattern n'a matche

		// separer les l'expression en tableau de caracteres
		String[] stringTab = input.split("");

		for (String character: stringTab) {
			/* Matcher le caractere selectionne avec chaque pattern
			   et si le matching est valid pour un pattern, alors
			   on instancie pour ce caractere, l'objet mathematique
			   correspondant
			*/
			for (Pattern pattern: this.config.keySet()) {
				Matcher matcher = pattern.matcher(character);
				if (matcher.find()) {
					// Il y a au moins un pattern qui vient de matcher
					noPattMatched = false;
					if (pattern == prevPatt) {
						matchedSeq += character;
					} else {
						/* Si le pattern qui a matche le caractere precedent
							 n'est plus le meme que celui qui vient de matcher
							 le caractere actuel, alors on enregistre en premier
							 toute la sequence matchee precedement en instanciant
							 l'objet mathematique correspondant, avant de garder
							 le caractere actuellement matche et son pattern.
						*/
						if (!matchedSeq.isEmpty()) {
							Function getinst = this.config.get(prevPatt);
							sequence.add((MathObject)getinst.apply(matchedSeq));
						}
						
						matchedSeq = character;
						prevPatt = pattern;
					}
				}
			}

			if (noPattMatched)
				throw new LexicalError(character + " is not recogned !");
			else
				// pour le caractere suivant
				noPattMatched = true;
		}

		/* Avant de retourner toute la sequence d'objet mathematique
			 on s'assure qu'il n'y a pas d'autre chaine de caracteres
			 precedement matchees. Et si c'est le cas, on ajoute aussi
			 a la sequence qu'on veut retourner.
		*/
		if (!matchedSeq.isEmpty()) {
			Function getinst = this.config.get(prevPatt);
			sequence.add((MathObject)getinst.apply(matchedSeq));
		}

		return sequence;
  }

}
