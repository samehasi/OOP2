package OOP2.Solution;

import java.util.Iterator;



import OOP2.Provided.Edge;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

public abstract class GenericGraphWalk {
	private boolean _bHasNext;
	private PriorityQueueImpl _openVertexes;
	private LinkedList<Vertex> _ClosedVertexes;
	private  Vertex _currentVertex;
	protected int _currentVertexPriority;
	
	abstract int getNextTag();
	
	protected final int INITIAL_PRIORITY = 1;
	
	
	public GenericGraphWalk(Vertex rootVertex){
		_bHasNext = true;
		
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
	
	void goToNextVertex(){
		boolean bNextVertexFound = false;
		
		
		try {
			while(!bNextVertexFound)
			{
				Vertex tempVertex = _openVertexes.peek();
			
				if(!_ClosedVertexes.contains(tempVertex))
				{
					/*found next unvisited vertex*/
					bNextVertexFound = true;
					
					/*update next vertex to visit*/
					_currentVertex = tempVertex;
					_currentVertexPriority = _openVertexes.peekPriority();
					
					/* add all connected vertexes to the open vertexes*/
					for (Iterator<Edge> iterator = tempVertex.getSuccessors().iterator(); iterator
							.hasNext();) {
						Edge nextEdge = (Edge) iterator.next();
						_openVertexes.enqueue(nextEdge.getEndpoint(), getNextTag());
						
						
						
					}
					
//				/*remove the next vertex to visit from open vertexes*/
//				/*we have pointer to it in _currentVertex           */
//					_openVertexes.dequeue();
				
				}else{
					_openVertexes.dequeue();
				}
			}
									
			
		} catch (QueueEmptyException e) {
			_bHasNext = false;
			_currentVertex =null;
		}
	}
	
	

	protected class GraphIterator implements Iterator<Vertex>
	{
		GenericGraphWalk _genericGraph;
		
		 public GraphIterator(GenericGraphWalk genericGraph) {
			 _genericGraph = genericGraph;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return _genericGraph._bHasNext;
		}

		@Override
		public Vertex next() {
			Vertex vertexToReturn = _currentVertex;
			goToNextVertex();		
			return vertexToReturn;
		}
		
	}

}
