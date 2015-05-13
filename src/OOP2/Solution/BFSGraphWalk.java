package OOP2.Solution;

import java.util.Iterator;

import OOP2.Provided.Edge;
import OOP2.Provided.QueueEmptyException;
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
		super();
		_openVertexes.enqueue(origin, INITIAL_PRIORITY);
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new GraphIterator(this) ;
	}


	@Override
	void goToNextVertex() {
		{
			boolean bNextVertexFound = false;
			
			
			try {
				
					Vertex tempVertex = _openVertexes.peek();
					
					/* add all connected vertexes to the open vertexes*/
					for (Iterator<Edge> iterator = tempVertex.getSuccessors().iterator(); iterator
							.hasNext();) {
						Edge nextEdge = (Edge) iterator.next();
						_openVertexes.enqueue(nextEdge.getEndpoint(), INITIAL_PRIORITY);
																		
					}
					
					_openVertexes.dequeue();
					_ClosedVertexes.addFirst(tempVertex);
					
					while(!bNextVertexFound)
					{
						tempVertex = _openVertexes.peek();
					if(!_ClosedVertexes.contains(tempVertex))
					{
						/*found next unvisited vertex*/
						bNextVertexFound = true;
						break;			
					}else{
						_openVertexes.dequeue();
					}//end else
					
				}//end while
										
				
			} catch (QueueEmptyException e) {
				//_currentVertex =null;
			}
		}		
	}

}
