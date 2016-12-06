package OOP2.Solution;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import OOP2.Provided.Edge;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

// koko reko
public class DFSGraphWalk extends GenericGraphWalk  implements Iterable<Vertex> {

	private int _maxPriority;
	private int _currentPriority;
	/*
	 * you must implement a constructor that takes an initial vertex for the iteration.
	 */
	public DFSGraphWalk(Vertex origin) {
		super();	
		_maxPriority =_currentPriority = origin.size();
		_openVertexes.enqueue(origin, _maxPriority);
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new GraphIterator(this) ;
	}


	
Collection<Edge> revertCololection(Collection<Edge> collectionToRevert)
{
	LinkedList<Edge> revertedList = new LinkedList<Edge>();
	for(Edge e : collectionToRevert){
		revertedList.addFirst(e);
	}
	return revertedList;
	
}
	
	@Override
	void goToNextVertex() {
		try {
			
			Vertex tempVertex = _openVertexes.peek();
			_openVertexes.dequeue();
			_ClosedVertexes.addFirst(tempVertex);	
			
			Collection<Edge> revertedList = revertCololection(tempVertex.getSuccessors());
			for(Edge e : revertedList){
				
				if(!_ClosedVertexes.contains(e.getEndpoint())){
					_openVertexes.enqueue(e.getEndpoint(),--_currentPriority);
				}
			}
			
					
			travelToNextVertexToVisit();
								
		} catch (QueueEmptyException e) {
			//do nothing
		} 
		
	}

}
