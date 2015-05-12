package OOP2.Tests;


import java.util.Iterator;

import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;
import OOP2.Solution.VertexImpl;
import OOP2.Solution.LinkedList;
import OOP2.Solution.PriorityQueueImpl;
;
public class Tester {
	
	public static void main(String[] args) {
		//SortedMap <Integer> sortedMap;
		VertexImpl v1 = new VertexImpl("v1",1);
		VertexImpl v2 = new VertexImpl("v2",2);
		VertexImpl v3 = new VertexImpl("v3",3);
		VertexImpl v4 = new VertexImpl("v4",4);
		VertexImpl v5 = new VertexImpl("v5",5);
		
		PriorityQueueImpl prQueue = new PriorityQueueImpl();
		prQueue.enqueue(v1, 10);
		prQueue.enqueue(v2, 5);
		prQueue.enqueue(v3, 7);
		prQueue.enqueue(v4, 2);
		prQueue.enqueue(v5, 16);
		
		
		//System.out.println(prQueue.peek().toString());
		
			try {
				Vertex peek = prQueue.peek();
				System.out.println(peek.toString());
			} catch (QueueEmptyException e) {
			System.err.println("queue is empty!!");
			}	
			
			try {
				prQueue.dequeue();
				prQueue.dequeue();
				prQueue.dequeue();
				prQueue.dequeue();
				prQueue.dequeue();
				prQueue.peek();
				
			} catch (QueueEmptyException e) {
				System.err.println("queue is empty!!");
			}
		
			assert prQueue.isEmpty();
			
			prQueue.enqueue(v2, 7);
			System.out.println("~~~~~~~");
		for (Iterator<Vertex> iterator = prQueue.iterator(); iterator.hasNext();) {
			Vertex vertex = (Vertex) iterator.next();
			System.out.println(vertex.toString());		
			
		}
			prQueue.enqueue(v3, 7);
			System.out.println("~~~~~~~");
		for (Iterator<Vertex> iterator = prQueue.iterator(); iterator.hasNext();) {
			Vertex vertex = (Vertex) iterator.next();
			System.out.println(vertex.toString());		
			
		}
			prQueue.enqueue(v4,7 );
			System.out.println("~~~~~~~");
		for (Iterator<Vertex> iterator = prQueue.iterator(); iterator.hasNext();) {
			Vertex vertex = (Vertex) iterator.next();
			System.out.println(vertex.toString());		
			
		}
			prQueue.enqueue(v5, 7);
			System.out.println("~~~~~~~");
		for (Iterator<Vertex> iterator = prQueue.iterator(); iterator.hasNext();) {
			Vertex vertex = (Vertex) iterator.next();
			System.out.println(vertex.toString());		
			
		}
			
			System.out.println("~~~~~~~");
		for (Iterator<Vertex> iterator = prQueue.iterator(); iterator.hasNext();) {
			Vertex vertex = (Vertex) iterator.next();
			System.out.println(vertex.toString());		
			
		}
		v2.connect(v4);
		v2.connect(v5);
		v1.connect(v2);
		v1.connect(v3);
		
		LinkedList<Integer> ls = new LinkedList<Integer>();
		
		ls.addFirst(1);
		ls.addFirst(2);
		ls.addFirst(1);
		ls.addFirst(2);
		ls.addFirst(1);
		System.out.println(ls.getFirst());
		ls.removeFirst();
		System.out.println(ls.getFirst());
		ls.removeFirst();
		System.out.println(ls.getFirst());
		ls.removeFirst();
		System.out.println(ls.getFirst());
		System.out.println("#####");
		for (Iterator<Integer> iterator = ls.iterator(); iterator.hasNext();) {
			Integer ret = (Integer) iterator.next();
			
			System.out.println(ret);
			
		}
		
	}

}
