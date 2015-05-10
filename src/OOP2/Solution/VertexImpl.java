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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
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
	

}
