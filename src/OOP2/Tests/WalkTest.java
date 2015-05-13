package OOP2.Tests;


import java.util.LinkedList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.*;
import OOP2.Solution.*;


public class WalkTest{
	@Test
	public void BFSTest() {

//      v0
//      /\
//     v1 v2
//     /  /\
//    v3  v4 v5
//       /
//      v6
// the walk: v0-v1-v2-v3-v4-v5-v6

		LinkedList<Vertex> vertexes = new LinkedList<Vertex>();
		LinkedList<Vertex> walk = new LinkedList<Vertex>();
		
		for(int i=0; i<7; i++)
			vertexes.addLast(new VertexImpl("v"+i, 0));


		walk.addAll(vertexes);

		vertexes.get(0).connect(vertexes.get(1));
		vertexes.get(0).connect(vertexes.get(2));
		vertexes.get(1).connect(vertexes.get(3));
		vertexes.get(2).connect(vertexes.get(4));
		vertexes.get(2).connect(vertexes.get(5));
		vertexes.get(4).connect(vertexes.get(6));

		BFSGraphWalk bfs = new BFSGraphWalk(vertexes.get(0));

		for( Vertex v : bfs){
			Assert.assertEquals(v, walk.getFirst());
			Assert.assertEquals(walk.getFirst(), v);
			walk.removeFirst();
		}
	}


	@Test
	public void BFSTestComplicated() {  
//                          ______                                              
//                         |      |<---------|                                   
//                 _______+|  v0  |++_____   |                                        
//                |        |______|        | +                                    
//                |              +         | +                         
//              __v___           +       __v_+_                                      
//             |      |          +      |      |                                     
//             |  v1  |          |    ++|  v2  |+___                                     
//             |______|          |   |  |______|    |                                 
//                + ^            |   |              |                    
//                | +            |   |              |                   
//                | +            |   |              |                    
//              __v_+_           v___v_          ___v__              
//             |      |         |      |        |      |                             
//             |  v3  |++------>|  v4  |+------>|  v5  |                             
//             |______|         |______|<------+|______|                             
//                  +              +^                                                 
//                  |              +|                                                
//                  |              ||                                  
//                  |            __v+__                                              
//                  |           |      |                                             
//                  |---------->|  v6  |                                             
//                              |______|                                             
//                                            
// walk_1: v0-v1-v2-v4-v3-v5-v6
// walk_2: v6-v4-v5
// walk_3: v1-v3-v6-v4-v5
// walk_4: v2-v5-v4-v0-v6-v1-v3
// walk_5: v3-v6-v4-v1-v5

		
		Vertex v0 = new VertexImpl("v0", 0);
		Vertex v1 = new VertexImpl("v1", 0);
		Vertex v2 = new VertexImpl("v2", 0);
		Vertex v3 = new VertexImpl("v3", 0);
		Vertex v4 = new VertexImpl("v4", 0);
		Vertex v5 = new VertexImpl("v5", 0);
		Vertex v6 = new VertexImpl("v6", 0);

		v0.connect(v1);
		v0.connect(v2);
		v0.connect(v4);
		v1.connect(v3);
		v2.connect(v5);
		v2.connect(v4);
		v2.connect(v0);
		v3.connect(v6);
		v3.connect(v4);
		v3.connect(v1);
		v4.connect(v5);
		v4.connect(v6);
		v5.connect(v4);
		v6.connect(v4);

		LinkedList<Vertex> walk_1 = new LinkedList<Vertex>(Arrays.asList(v0,v1,v2,v4,v3,v5,v6));
		LinkedList<Vertex> walk_2 = new LinkedList<Vertex>(Arrays.asList(v6,v4,v5));
		LinkedList<Vertex> walk_3 = new LinkedList<Vertex>(Arrays.asList(v1,v3,v6,v4,v5));
		LinkedList<Vertex> walk_4 = new LinkedList<Vertex>(Arrays.asList(v2,v5,v4,v0,v6,v1,v3));
		LinkedList<Vertex> walk_5 = new LinkedList<Vertex>(Arrays.asList(v3,v6,v4,v1,v5));

		BFSGraphWalk bfs_1 = new BFSGraphWalk(v0);
		BFSGraphWalk bfs_2 = new BFSGraphWalk(v6);
		BFSGraphWalk bfs_3 = new BFSGraphWalk(v1);
		BFSGraphWalk bfs_4 = new BFSGraphWalk(v2);
		BFSGraphWalk bfs_5 = new BFSGraphWalk(v3);


		for( Vertex v : bfs_1)
			Assert.assertEquals(v, walk_1.removeFirst());

		for( Vertex v : bfs_2)
			Assert.assertEquals(v, walk_2.removeFirst());

		for( Vertex v : bfs_3)
			Assert.assertEquals(v, walk_3.removeFirst());

		for( Vertex v : bfs_4)
			Assert.assertEquals(v, walk_4.removeFirst());

		for( Vertex v : bfs_5)
			Assert.assertEquals(v, walk_5.removeFirst());
	}

	@Test
	public void DFSTest() {
//      v0
//      /\
//     v1 v2
//     /  /\
//    v3  v4 v5
//       /
//      v6
// the walk: v0-v1-v3-v2-v4-v6-v5

		LinkedList<Vertex> vertexes = new LinkedList<Vertex>();
		LinkedList<Vertex> walk = new LinkedList<Vertex>();
		
		for(int i=0; i<7; i++)
			vertexes.addLast(new VertexImpl("v"+i, 0));

		vertexes.get(0).connect(vertexes.get(1));
		vertexes.get(0).connect(vertexes.get(2));
		vertexes.get(1).connect(vertexes.get(3));
		vertexes.get(2).connect(vertexes.get(4));
		vertexes.get(2).connect(vertexes.get(5));
		vertexes.get(4).connect(vertexes.get(6));

		walk.addLast(vertexes.get(0));
		walk.addLast(vertexes.get(1));
		walk.addLast(vertexes.get(3));
		walk.addLast(vertexes.get(2));
		walk.addLast(vertexes.get(4));
		walk.addLast(vertexes.get(6));
		walk.addLast(vertexes.get(5));

		DFSGraphWalk dfs = new DFSGraphWalk(vertexes.get(0));

		for( Vertex v : dfs){
			Assert.assertEquals(v, walk.getFirst());
			Assert.assertEquals(walk.getFirst(), v);
			walk.removeFirst();
		}
	}

		@Test
	public void DFSTestComplicated() {  
//                          ______                                              
//                         |      |<---------|                                   
//                 _______+|  v0  |++_____   |                                        
//                |        |______|        | +                                    
//                |              +         | +                         
//              __v___           +       __v_+_                                      
//             |      |          +      |      |                                     
//             |  v1  |          |    ++|  v2  |+___                                     
//             |______|          |   |  |______|    |                                 
//                + ^            |   |              |                    
//                | +            |   |              |                   
//                | +            |   |              |                    
//              __v_+_           v___v_          ___v__              
//             |      |         |      |        |      |                             
//             |  v3  |++------>|  v4  |+------>|  v5  |                             
//             |______|         |______|<------+|______|                             
//                  +              +^                                                 
//                  |              +|                                                
//                  |              ||                                  
//                  |            __v+__                                              
//                  |           |      |                                             
//                  |---------->|  v6  |                                             
//                              |______|                                             
//                                            
// walk_1: v0-v1-v3-v6-v4-v5-v2
// walk_2: v6-v4-v5
// walk_3: v2-v5-v4-v6-v0-v1-v3
// walk_4: v3-v6-v4-v5-v1

		//
		
		Vertex v0 = new VertexImpl("v0", 0);
		Vertex v1 = new VertexImpl("v1", 0);
		Vertex v2 = new VertexImpl("v2", 0);
		Vertex v3 = new VertexImpl("v3", 0);
		Vertex v4 = new VertexImpl("v4", 0);
		Vertex v5 = new VertexImpl("v5", 0);
		Vertex v6 = new VertexImpl("v6", 0);

		v0.connect(v1);
		v0.connect(v2);
		v0.connect(v4);
		v1.connect(v3);
		v2.connect(v5);
		v2.connect(v4);
		v2.connect(v0);
		v3.connect(v6);
		v3.connect(v4);
		v3.connect(v1);
		v4.connect(v5);
		v4.connect(v6);
		v5.connect(v4);
		v6.connect(v4);

		LinkedList<Vertex> walk_1 = new LinkedList<Vertex>(Arrays.asList(v0,v1,v3,v6,v4,v5,v2));
		LinkedList<Vertex> walk_2 = new LinkedList<Vertex>(Arrays.asList(v6,v4,v5));
		LinkedList<Vertex> walk_3 = new LinkedList<Vertex>(Arrays.asList(v2,v5,v4,v6,v0,v1,v3));
		LinkedList<Vertex> walk_4 = new LinkedList<Vertex>(Arrays.asList(v3,v6,v4,v5,v1));

		DFSGraphWalk dfs_1 = new DFSGraphWalk(v0);
		DFSGraphWalk dfs_2 = new DFSGraphWalk(v6);
		DFSGraphWalk dfs_3 = new DFSGraphWalk(v2);
		DFSGraphWalk dfs_4 = new DFSGraphWalk(v3);


		// System.out.println("expecting: v0,v1,v3,v6,v4,v5,v2");

		for( Vertex v : dfs_1)
			Assert.assertEquals(v, walk_1.removeFirst());

		for( Vertex v : dfs_2)
			Assert.assertEquals(v, walk_2.removeFirst());

		for( Vertex v : dfs_3)
			Assert.assertEquals(v, walk_3.removeFirst());

		for( Vertex v : dfs_4)
			Assert.assertEquals(v, walk_4.removeFirst());

	}
}
