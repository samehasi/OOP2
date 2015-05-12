package OOP2.Solution;

import java.util.Iterator;

import OOP2.Provided.Edge;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

public abstract class GenericGraphWalk {
	private PriorityQueueImpl _openVertexes;
	private LinkedList<Vertex> _ClosedVertexes;
	private Vertex _currentVertex;
	private int _currentVertexPriority;
	
	abstract int getNextTag();
	
	private final int INITIAL_PRIORITY = 1;
	
	
	public GenericGraphWalk(Vertex rootVertex){
		_openVertexes = new PriorityQueueImpl();
		_ClosedVertexes = new LinkedList<Vertex>();
		
		_openVertexes.enqueue(rootVertex, INITIAL_PRIORITY);
		
		try{
			_currentVertex = _openVertexes.peek();	
			_currentVertexPriority = _openVertexes.peekPriority();
		}
		catch(Exception e){
			//can't really happen
		}	
				
	}
	
	void goToNextStep(){
		boolean bNextVertexFound = false;
		
		
		try {
			while(!bNextVertexFound)
			{
				Vertex tempVertex = _openVertexes.peek();
			
				if(_ClosedVertexes.contains(tempVertex))
				{
					bNextVertexFound = true;
					
					for (Iterator<Edge> iterator = tempVertex.getSuccessors().iterator(); iterator
							.hasNext();) {
						Edge nextEdge = (Edge) iterator.next();
						_openVertexes.enqueue(nextEdge.getEndpoint(), getNextTag());				
					}
				
				
				}
			}
									
			
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
