package OOP2.Solution;

import java.util.Iterator;





import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

public abstract class GenericGraphWalk {

	protected PriorityQueueImpl _openVertexes;
	protected LinkedList<Vertex> _ClosedVertexes;
	//private  Vertex _currentVertex;
		
	protected final int INITIAL_PRIORITY = 1;
	
	
	public GenericGraphWalk(){

		
		_openVertexes = new PriorityQueueImpl();
		_ClosedVertexes = new LinkedList<Vertex>();								
	}
	
	abstract void goToNextVertex();
	
	
	protected class GraphIterator implements Iterator<Vertex>
	{
		GenericGraphWalk _genericGraph;
		
		 public GraphIterator(GenericGraphWalk genericGraph) {
			 _genericGraph = genericGraph;
		}
		@Override
		public boolean hasNext() {
			return !(_openVertexes.isEmpty());
		}

		@Override
		public Vertex next() {
			Vertex vertexToReturn;
			try {
				vertexToReturn = _openVertexes.peek();
			} catch (QueueEmptyException e) {
				vertexToReturn = null;
			}
			
			goToNextVertex();		
			
			return vertexToReturn;
		}
		
	}
	
	
	void travelToNextVertexToVisit() throws QueueEmptyException{
		
		boolean bNextVertexFound = false;
		while(!bNextVertexFound  && !_openVertexes.isEmpty() )
		{
			Vertex tempVertex = _openVertexes.peek();
		if(!_ClosedVertexes.contains(tempVertex))
		{
			/*found next unvisited vertex*/
			bNextVertexFound = true;
			break;			
		}else{
			_openVertexes.dequeue();
		}//end else
		}
	}

}
