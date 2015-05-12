package OOP2.Solution;


import java.util.Iterator;

import OOP2.Provided.Vertex;

public class DFSGraphWalk extends GenericGraphWalk  implements Iterable<Vertex> {

	
	/*
	 * you must implement a constructor that takes an initial vertex for the iteration.
	 */
	public DFSGraphWalk(Vertex origin) {
		super(origin);	
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new GraphIterator(this) ;
	}

	@Override
	int getNextTag() {
		return INITIAL_PRIORITY;
	}

}
