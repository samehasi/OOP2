package OOP2.Solution;


import java.util.Iterator;

import OOP2.Provided.PriorityQueue;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;
import OOP2.Solution.LinkedList;

public class PriorityQueueImpl implements PriorityQueue,Iterable<Vertex> {
	
	private class PriQueueNode{
		public Vertex _vertex;
		public int _priority;
	}
	
	private LinkedList<PriQueueNode> _linkedList;
	
	
	/*
	 * must have a constructor that does not take arguments.
	 */
	public PriorityQueueImpl() {
		_linkedList = new LinkedList<PriQueueNode>();
	}

	@Override
	public void enqueue(Vertex v, int tag) {
		PriQueueNode toAddAfter = null;
		PriQueueNode nodeToAdd = new PriQueueNode();
		nodeToAdd._priority = tag;
		nodeToAdd._vertex = v;
		
		for (Iterator<PriQueueNode> iterator = _linkedList.iterator(); iterator.hasNext();) {
			PriQueueNode queueIter = (PriQueueNode) iterator.next();
			
			if(queueIter._priority > tag){
				break;
			}else{
				toAddAfter = queueIter;
			}
			
		}
		if(toAddAfter == null){
			_linkedList.addFirst(nodeToAdd);
		}else{
			_linkedList.addAfter(nodeToAdd, toAddAfter);
		}
		
		
	}

	@Override
	public Vertex dequeue() throws QueueEmptyException {
		// TODO check if correct behavior
		if(isEmpty()){
			throw new QueueEmptyException();
		}
		Vertex vertexToReturn = _linkedList.getFirst()._vertex;
		_linkedList.removeFirst();
		return vertexToReturn;
	}

	@Override
	public Vertex peek() throws QueueEmptyException {
		if(isEmpty()){
			throw new QueueEmptyException();
		}
		
		return _linkedList.getFirst()._vertex;
	}
	
	public int peekPriority()  throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException();
		}		
		return _linkedList.getFirst()._priority;
	}

	@Override
	public boolean isEmpty() {
		return (_linkedList.size() == 0);
	}

	public Iterator<Vertex> iterator() {
		return new priQueueIterator(_linkedList);
	}
	
	class priQueueIterator implements Iterator<Vertex>{

		Iterator<PriQueueNode> priQueueIterator;
		
		public priQueueIterator(LinkedList<PriQueueNode> list){
			priQueueIterator = list.iterator();
		}
		@Override
		public boolean hasNext() {
			return priQueueIterator.hasNext();
		}

		@Override
		public Vertex next() {
			return priQueueIterator.next()._vertex;

		}
		
	}
	

}
