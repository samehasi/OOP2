/**
 * 
 */
package OOP2.Solution;

import java.util.Iterator;


/**
 * @author SAMEH
 *
 */
public class LinkedList<T> implements Iterable<T> {
	
	
	class Node<S>{
		public S _data;
		public Node<S> _next;
		Node(S data){
			_data = data;
			_next = null;
		}
	}
	
	private Node<T> _headDummy;
	private Node<T> _tailDummy;
	private int _size;
	
	public LinkedList(){
		
		/*allocate dummies and set data to null*/
		_headDummy = new Node<T>(null);
		_tailDummy = new Node<T>(null);
				
		/*Initialize pointers*/
		_headDummy._next = _tailDummy;
		_tailDummy._next = null;
		
		/*reset size*/
		_size = 0;
	}
	
	public int size(){
		return _size;
	}
	
	public void addFirst(T toAdd){
		Node<T> nodeToAdd = new Node<T>(toAdd);
		nodeToAdd._next = _headDummy._next;
		_headDummy._next = nodeToAdd;
		_size++;
		
	}
	
	public void addAfter(T toAdd ,T toAddAfter){
		Node<T> nodeToAddAfter = find(toAddAfter);
		
		if(nodeToAddAfter != null){
			Node<T> nodeToAdd = new Node<T>(toAdd);
			nodeToAdd._next = nodeToAddAfter._next;
			nodeToAddAfter._next = nodeToAdd;
			_size++;
		}
	}
	
	
	public T getFirst(){
		return _headDummy._next._data;
	}
	
	public void removeFirst(){
		if(_size > 0){
			_headDummy._next = _headDummy._next._next;
			_size--;
		}
	}
	
private Node<T> find(T toFind){
	Node<T> iter = _headDummy;
	
	while(iter._next != _tailDummy){
		iter = iter._next;
		if(iter._data == toFind){
			return iter;
		}
	}
	return null;
}
	

	@Override
	public Iterator<T> iterator() {
		return new ListIterator(_headDummy,_tailDummy);
	}
	
	
	class ListIterator implements Iterator<T>{
		Node<T> _iter;
		Node<T> _start;
		Node<T> _end;
		public ListIterator(Node<T> start , Node<T> end) {
			_start =_iter = start;
			_end = end;
		}

		@Override
		public boolean hasNext() {
			if( (_iter != _end) && (_iter._next != _end)){
				return true;
			}else{
				return false;
			}
		}

		@Override
		public T next() {
			_iter = _iter._next;
			return _iter._data;
		}
		
	}


	public boolean contains(T item) {
		boolean bRetVal = false;
		
		for (Iterator<T> iterator = this.iterator(); iterator.hasNext();) {
			T nextItem = (T) iterator.next();
			
			if(item.equals(nextItem)){
				/*item found in the list*/
				bRetVal = true;
				break;
			}
			
		}
		return bRetVal;
	}

}
