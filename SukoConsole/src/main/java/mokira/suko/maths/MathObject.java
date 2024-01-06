/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths;

import java.util.ArrayList;
import java.util.List;
import mokira.suko.SyntaxError;


/**
 *
 * @author mokira3d48
 */
public abstract class MathObject {
	public static abstract class Analyser {
		protected List<MathObject> mathObjsFound;
		protected List<Integer> indexesWillRemoved;

		public Analyser() {
			this.mathObjsFound = new ArrayList<>();
		}

		public List<MathObject> getMathObjectFound() {
			return this.mathObjsFound;
		}
		
		public List<Integer> getIndexesWillRemoved() {
			return this.indexesWillRemoved;
		}
		
		/**
		 *
		 * @param input
		 * @return
		 */
		public abstract void search(List<MathObject> input) throws SyntaxError;

	}

  private static long idCounter = 0x0;
  protected long id;
  protected String tag;

  {
    this.id = idCounter; 
    idCounter += 1;
  }

  public String getTag() {
    return this.tag;
  }
  
  @Override
  public String toString() {
    return this.tag;
  }
}
