/*
	Universidad del Valle de Guatemala
	Ana Bartra 13643
	Sergio Cancinos 13062 
	Calculadora.java
	Se encarga de revisar la cade y realizar las operaciones adem�s de utilizar la interfaz stack.java	
*/
package laboratorio2;

/**
 *
 * @author DatDell
 */
import java.util.ArrayList;

public class StackArrayList<E>
 implements Stack<E>
{
	protected ArrayList<E> data;

	public StackArrayList()
	// post: constructs a new, empty stack
	{
		data = new ArrayList<E>();
	}

	public void push(E item)
	// post: the value is added to the stack
	//          will be popped next if no intervening push
	{
		data.add(item);
	}

	public E pop()
	// pre: stack is not empty
	// post: most recently pushed item is removed and returned
	{
		return data.remove(size()-1);
	}

	public E peek()
	// pre: stack is not empty
	// post: top value (next to be popped) is returned
	{
		return data.get(size() - 1);
	}
	
	public int size()
	// post: returns the number of elements in the stack
	{
		return data.size();
	}
  
	public boolean empty()
	// post: returns true if and only if the stack is empty
	{
		return size() == 0;
	}
} 

