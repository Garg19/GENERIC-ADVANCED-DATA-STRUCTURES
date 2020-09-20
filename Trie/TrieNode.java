
package Trie;
import java.util.ArrayList;
import Util.NodeInterface;
public class TrieNode<T> implements NodeInterface<T> {
	ArrayList<TrieNode<T>> list = new ArrayList<TrieNode<T>>();
	boolean end = false;
	T obj;
	Character val;
	public TrieNode(Character val)
	{
		this.val = val;
	}
	public T getValue() {
		    
			return obj;
       
    }
	public boolean getend() {
		return end;
	}
	public void setobj(T obj)
	{
		this.obj = obj;
	}
	
	public void setend()
	{
		this.end = true;
	}
	public  Character getval() {
		return val;
	}



}