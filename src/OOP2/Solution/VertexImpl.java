package OOP2.Solution;



import java.util.Collection;
import java.util.LinkedList;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;


public class VertexImpl implements Vertex {
	private int _val;
	private String _name;
	private LinkedList<Vertex> _Connections;
	
	/*
	 * a constructor that takes a name and initial integer value.
	 */
	public VertexImpl(String name,int val) {
		_val = val;
		_name = name;
		_Connections = new LinkedList<Vertex>();
	}

	@Override
	public void connect(Vertex vertexToAdd) {
		_Connections.addLast(vertexToAdd);
	}
	
	public Vertex getconnectingEdge(Vertex vertex){
		
		Vertex retVal = null; //return null if nut found
	for( Edge v : this.getSuccessors()){
		VertexImpl vImp = (VertexImpl)v.getEndpoint();
		if(vImp.hasPathToVertex(vertex)){
			retVal =v.getEndpoint();
			break;
		}			
	}
	return retVal;	
	}

	@Override
	public Collection<Vertex> find(Vertex target) {
		if(target == null){
			return null;
		}
		
				
		/*allocate collection to return*/
		LinkedList<Vertex> retCollection = new LinkedList<Vertex>();
		
		if(equals(target))
		{
			retCollection.addLast(this);
			return retCollection;
		}
		
		
		if(!this.hasPathToVertex(target)){
			return retCollection;
		}
		
		VertexImpl vertexIter = this;
		
		retCollection.addLast(vertexIter);
		
		while(!vertexIter.equals(target)){
			Vertex connector =vertexIter.getconnectingEdge(target);
			retCollection.addLast(connector);
			vertexIter = (VertexImpl) connector;
		}
		
		
		/*return the collection*/
		return retCollection;
	}

	@Override
	public int size() {
		int i = 0;
		BFSGraphWalk walker = new BFSGraphWalk(this);
		for(@SuppressWarnings("unused") Vertex v:walker){
			i++;
		}
	return i;
	}

	@Override
	public Collection<Edge> getSuccessors() {
		LinkedList<Edge> ls = new LinkedList<Edge>();
		for (Vertex x : _Connections) {
			ls.addLast(new EdgeImpl(x));
		}
		return ls;
	}

	@Override
	public int Value() {
		return _val;
	}

	@Override
	public int setValue(int val) {
		_val = val;
		return val;
	}
	
public static boolean recFind(LinkedList<Vertex> linkedList,Vertex source , Vertex target){
	if(source.getSuccessors().isEmpty()){
		return false;
	}
		
	linkedList.addLast(source);
	
	if(source.equals(target)){
		return true;
	}
	
	for (Edge edge : source.getSuccessors()) {
		Vertex nextVertex = edge.getEndpoint();
		
		if(nextVertex.equals(target))
		{
			linkedList.addLast(target);
			return true;
		}
		boolean ret = recFind(linkedList,nextVertex,target);
		if(ret){
			return true;
		}else{
			continue;
		}
	}
	linkedList.removeLast();
	return false;
}
	
@Override
public boolean equals(Object obj) {
	if(!(obj instanceof VertexImpl)){
		return false;
	}
	VertexImpl otherVertex = (VertexImpl) obj;
	return _name.equals(otherVertex._name);
}

@Override
public String toString(){
	return _name;
}

public Object getName() {
	return _name;
}

private boolean hasPathToVertex(Vertex vertex){
	BFSGraphWalk bfs = new BFSGraphWalk(this);
	boolean bRetVal = false;
	
	for( Vertex v : bfs){
		
		if(vertex.equals(v)){
			bRetVal = true;
					break;
		}			
	}
	return bRetVal;	
}





}
