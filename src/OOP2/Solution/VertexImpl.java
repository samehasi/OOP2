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

	@Override
	public Collection<Vertex> find(Vertex target) {
		
		/*allocate collection to return*/
		LinkedList<Vertex> retCollection = new LinkedList<Vertex>();
		
		/*search for path recursively*/
		recFind(retCollection, this, target);
		
		/*return the collection*/
		return retCollection;
	}

	@Override
	public int size() {
		//TODO: need to fix it , that is not what hilal wants
		int retVal = _Connections.size();
		return retVal;
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
}
