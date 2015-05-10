package OOP2.Tests;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;
import OOP2.Solution.VertexImpl;
;
public class Tester {
	public static void main(String[] args) {
		VertexImpl v1 = new VertexImpl("v1",1);
		VertexImpl v2 = new VertexImpl("v2",2);
		VertexImpl v3 = new VertexImpl("v3",3);
		VertexImpl v4 = new VertexImpl("v4",4);
		VertexImpl v5 = new VertexImpl("v5",5);
		v2.connect(v4);
		v2.connect(v5);
		v1.connect(v2);
		v1.connect(v3);

		for (Vertex v : v1.find(v3)) {
			
			System.out.println(v.Value());
			
		}
	}

}
