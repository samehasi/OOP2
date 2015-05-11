package OOP2.Tests;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;
import OOP2.Solution.VertexImpl;
import OOP2.Solution.LinkedList;
;
public class Tester {
	
	public static void main(String[] args) {
		//SortedMap <Integer> sortedMap;
		VertexImpl v1 = new VertexImpl("v1",1);
		VertexImpl v2 = new VertexImpl("v2",2);
		VertexImpl v3 = new VertexImpl("v3",3);
		VertexImpl v4 = new VertexImpl("v4",4);
		VertexImpl v5 = new VertexImpl("v5",5);
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
		for (Iterator<Integer> iterator = ls.iterator(); iterator.hasNext();) {
			Integer ret = (Integer) iterator.next();
			
			System.out.println(ret);
			
		}
		
	}

}
