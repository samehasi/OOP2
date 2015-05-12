package OOP2.Solution;

import java.util.Iterator;

import OOP2.Provided.Vertex;

public class BFSGraphWalk extends GenericGraphWalk implements Iterable<Vertex>{
	
	/*
	 * you need to implement Iterable<Vertex>.
	 * you can inherit other classes or implement other interfaces in addition to Iterable<Vertex>. 
	 */
	
	
	/*
	 * you must implement a constructor that takes an initial vertex for the iteration.
	 */
	public BFSGraphWalk(Vertex origin) {
		super(origin);
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new GraphIterator(this) ;
	}

	@Override
	int getNextTag() {
		// TODO Auto-generated method stub
		return _currentVertexPriority+1;
	}

}
