/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths.ops;

import java.util.ArrayList;
import java.util.List;
import mokira.suko.SyntaxError;
import mokira.suko.SequenceIterator;
import mokira.suko.maths.MathObject;
import mokira.suko.maths.Variable;
import mokira.suko.maths.TermNotDefined;

/**
 *
 * @author mokira3d48
 */
public class Addition extends BinaryOperation {
	public static class Analyser extends MathObject.Analyser {

		@Override
		public void search(List<MathObject> input) throws SyntaxError {
			SequenceIterator<MathObject> iterator = SequenceIterator.getFrom(input);
			MathObject selected;
			Integer currentIndex;

			while (iterator.hasNext()) {
				selected = iterator.get();
				currentIndex = iterator.getIndex();

				if (selected instanceof Addition) {
					if (iterator.atBegin())
						throw new SyntaxError("`+` operation must be formatted like x + y. Never located at begin of operation.");
					
					if (iterator.atEnd())
						throw new SyntaxError("`+` operation must be formatted like x + y. Never located at end of operation.");
					
					if (!(iterator.getPrev() instanceof Variable) || !(iterator.getNext() instanceof Variable))
						throw new SyntaxError("`+` operation must be located between two variables or numbers like x + y. ");

					Addition addOp = (Addition)selected;
					addOp.setVar1((Variable)iterator.getPrev());
					addOp.setVar2((Variable)iterator.getNext());

					this.mathObjsFound.add(addOp);
					this.indexesWillRemoved.add(currentIndex);
					this.indexesWillRemoved.add(currentIndex - 1);
					this.indexesWillRemoved.add(currentIndex + 1);

					input.set(currentIndex, addOp.getReturned());
				}
			}
		}
		
	}

  public Addition() {
    super();
    this.tag = "+";
  }

  /**
   *
   * @throws TermNotDefined
   */
  @Override
  public void eval() throws TermNotDefined {
    Double value1 = this.var1.getValue();
    Double value2 = this.var2.getValue();

    if (value1 == null || value2 == null)
      throw new TermNotDefined("Some terms is missing at operation ID: " + this.id);

    Double value3 = value1 + value2;
    this.returned.setValue(value3);
  }
}
