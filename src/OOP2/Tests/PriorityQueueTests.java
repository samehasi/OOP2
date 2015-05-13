package OOP2.Tests;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.PriorityQueue;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;
import OOP2.Solution.PriorityQueueImpl;
import OOP2.Solution.VertexImpl;

import java.util.ConcurrentModificationException;

public class PriorityQueueTests {

	@Test
	public void enqueueDequeuePeekTest() {
		Vertex a = new VertexImpl("a",0);
		Vertex b = new VertexImpl("b",1);
		Vertex c = new VertexImpl("c",0);
		Vertex d = new VertexImpl("d",1);
		Vertex e = new VertexImpl("e",0);
		Vertex f = new VertexImpl("f",1);
		Vertex g = new VertexImpl("g",0);
		Vertex h = new VertexImpl("h",1);
		Vertex i = new VertexImpl("i",0);
		PriorityQueue pq = new PriorityQueueImpl();
		Assert.assertEquals(pq.isEmpty(), true);
		pq.enqueue(a, 1);
		pq.enqueue(b, 3);
		pq.enqueue(c, 2);
		pq.enqueue(d, 3);
		pq.enqueue(e, 1);
		pq.enqueue(f, 4);
		pq.enqueue(g, 5);
		pq.enqueue(h, 5);
		pq.enqueue(i, 4);
		Assert.assertEquals(pq.isEmpty(), false);
		try{
		@SuppressWarnings("unused")
		Vertex temp = pq.dequeue();
		temp = pq.peek();
		temp = pq.peek();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		temp = pq.dequeue();
		}catch(QueueEmptyException e1){
			Assert.assertTrue(false);
		}
		
		try{
			pq.peek();
		} catch(QueueEmptyException e1){
			System.out.println("expected: throws QueueEmptyException!");
		}
		try{
			pq.dequeue();
		} catch(QueueEmptyException e1){
			System.out.println("expected: throws QueueEmptyException!");
		}
		
		System.out.println("you passed the enqueue dequeue test!");

	}

		@Test
	public void iteratorTest() {
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
			PriorityQueue pq = new PriorityQueueImpl();
			Assert.assertEquals(pq.isEmpty(), true);
			pq.enqueue(a, 1);
			pq.enqueue(b, 3);
			pq.enqueue(c, 2);
			pq.enqueue(d, 3);
			pq.enqueue(e, 1);
			pq.enqueue(f, 4);
			pq.enqueue(g, 5);
			pq.enqueue(h, 5);
			pq.enqueue(i, 4);
			pq.enqueue(j, 1);
			pq.enqueue(k, 3);
			pq.enqueue(l, 2);
			
			try{
				String[] testArray = {"a", "e", "j", "c", "l", "b", "d", "k", "f", "i", "g", "h"};
				int index = 0;
				for(Vertex v : (PriorityQueueImpl)pq)
				{
					Assert.assertEquals(((VertexImpl) v).getName(), testArray[index]);
					index++;	
				}
			} catch(ConcurrentModificationException exp)
			{
				Assert.assertTrue(false);
			}
			
			System.out.println("you passed the iterator test!");

		}

}
