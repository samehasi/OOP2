package OOP2.Solution;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;


public class EdgeImpl implements Edge {

	private Vertex _endPoint;
	
	public EdgeImpl(Vertex endPoint) {
		_endPoint = endPoint;
	}
	@Override
	public Vertex getEndpoint() {
		return _endPoint;
	}

}
