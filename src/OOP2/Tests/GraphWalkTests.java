package OOP2.Tests;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Vertex;
import OOP2.Solution.BFSGraphWalk;
import OOP2.Solution.DFSGraphWalk;
import OOP2.Solution.VertexImpl;

public class GraphWalkTests {

	@Test
	public void BFSTest() {
		Vertex a = new VertexImpl("a",0);
		Vertex b = new VertexImpl("b",1);
		Vertex c = new VertexImpl("c",0);
		Vertex d = new VertexImpl("d",1);
		Vertex e = new VertexImpl("e",0);
		Vertex f = new VertexImpl("f",1);
		Vertex g = new VertexImpl("g",0);
		Vertex h = new VertexImpl("h",1);
		Vertex i = new VertexImpl("i",0);
		Vertex j = new VertexImpl("j",1);
		Vertex k = new VertexImpl("k",0);
		Vertex l = new VertexImpl("l",1);
		a.connect(b);
		a.connect(c);
		b.connect(d);
		b.connect(e);
		b.connect(f);
		c.connect(f);
		c.connect(g);
		d.connect(h);
		e.connect(h);
		f.connect(h);
		f.connect(i);
		g.connect(i);
		g.connect(l);
		h.connect(i);
		h.connect(j);
		i.connect(k);
		i.connect(l);
		l.connect(a);
		BFSGraphWalk bfs = new BFSGraphWalk(a);
		
		String[] testArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "l", "j", "k"};
		int index = 0;
		for(Vertex v : bfs)
		{
			Assert.assertEquals(((VertexImpl) v).getName(), testArray[index]);
			index++;	
		}
		
		System.out.println("you passed the BFS test!");

	}

	@Test
	public void DFSTest() {
		Vertex a = new VertexImpl("a",0);
		Vertex b = new VertexImpl("b",1);
		Vertex c = new VertexImpl("c",0);
		Vertex d = new VertexImpl("d",1);
		Vertex e = new VertexImpl("e",0);
		Vertex f = new VertexImpl("f",1);
		Vertex g = new VertexImpl("g",0);
		Vertex h = new VertexImpl("h",1);
		Vertex i = new VertexImpl("i",0);
		Vertex j = new VertexImpl("j",1);
		Vertex k = new VertexImpl("k",0);
		Vertex l = new VertexImpl("l",1);
		a.connect(b);
		a.connect(c);
		b.connect(d);
		b.connect(e);
		b.connect(f);
		c.connect(f);
		c.connect(g);
		d.connect(h);
		e.connect(h);
		f.connect(h);
		f.connect(i);
		g.connect(i);
		g.connect(l);
		h.connect(i);
		h.connect(j);
		i.connect(k);
		i.connect(l);
		l.connect(a);
		DFSGraphWalk dfs = new DFSGraphWalk(a);
		
		int size = a.size();
		
		String[] testArray = {"a", "b", "d", "h", "i", "k", "l", "j", "e", "f", "c", "g"};
		//String[] testArray = {"a", "c", "g", "l", "i", "k", "f", "h", "j", "b", "e", "d"};
		
		Assert.assertEquals(size, testArray.length);
		int index = 0;
		for(Vertex v : dfs)
		{
			Assert.assertEquals(((VertexImpl) v).getName(), testArray[index]);
			index++;	
		}
		
		System.out.println("you passed the DFS test!");
	}
}
