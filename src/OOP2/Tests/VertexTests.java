package OOP2.Tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Vertex;
import OOP2.Solution.VertexImpl;

public class VertexTests
{

	@Test
	public void sizeTest()
	{
		Vertex a = new VertexImpl("a",0);
		Assert.assertEquals(a.size(), 1);
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
		Assert.assertEquals(a.size(), 12);
		Assert.assertEquals(l.size(), 12);
		Assert.assertEquals(h.size(), 12);
		Assert.assertEquals(g.size(), 12);
		Assert.assertEquals(k.size(), 1);
		a.getSuccessors().removeAll(a.getSuccessors());
		Assert.assertEquals(a.size(), 12);
		System.out.println("you passed the size test!");

	}

	@Test
	public void findTest()
	{
		Vertex a = new VertexImpl("a",0);
		Assert.assertEquals(a.size(), 1);
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
		Collection<Vertex> temp = j.find(a);
		Assert.assertEquals(temp.isEmpty(), true);
		temp = a.find(a);
		Assert.assertEquals(temp.size(), 1);
		temp = l.find(a);
		Assert.assertEquals(temp.size(), 2);
		temp = e.find(a);
		Assert.assertNotEquals(temp.isEmpty(), true);
		temp = c.find(a);
		Assert.assertNotEquals(temp.isEmpty(), true);
		temp = a.find(i);
		Assert.assertNotEquals(temp.isEmpty(), true);
		temp = a.find(d);
		Assert.assertNotEquals(temp.isEmpty(), true);
		
		System.out.println("you passed the find test!");

	}

	
}
