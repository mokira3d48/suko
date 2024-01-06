/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.List;

/**
 *
 * @author mokira3d48
 * @param <T>
 */
public class SequenceIterator<T> {
	private final T[] sequence;
	private int index;
	
	public SequenceIterator(T[] sequence) {
		this.sequence = sequence;
		this.index = -1;
	}
	
	public void reset() {
		this.index = -1;
	}

	public boolean hasNext() {
		return this.index < this.sequence.length - 1;
	}
	
	public boolean hasPrev() {
		return this.index > 0;
	}

	public T get() {
		if (this.hasNext()) {
			this.index += 1;
			return this.sequence[this.index];
		}

		return null;
	}
	
	public T getPrev() {
		if (this.hasPrev())
			return this.sequence[this.index - 1];
		
		return null;
	}
	
	public T getNext() {
		if (this.hasNext()) {
			return this.sequence[this.index + 1];
		}

		return null;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public boolean atBegin() {
		return this.index == 0;
	}
	
	public boolean atEnd() {
		return this.index == this.sequence.length - 1;
	}
	
	public void advance(int step) {
		if (this.hasNext())
			this.index += step;
	}
	
	public void goBack(int step) {
		if (this.index > 0)
			this.index -= step;
	}
	
	/**
	 *
	 * @param list
	 * @return
	 */
	public static <T> SequenceIterator getFrom(List<T> list) {
		T arr[] = (T[]) list.toArray();
		return new SequenceIterator<>(arr);
	}
	
}
