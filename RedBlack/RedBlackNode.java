package RedBlack;

import Util.RBNodeInterface;

import java.util.ArrayList;
import java.util.List;

public class RedBlackNode<T extends Comparable, E> implements RBNodeInterface<E> {

    T key;
    public E value;
    public RedBlackNode<T,E> left;
	public RedBlackNode<T,E> right;
	RedBlackNode<T,E> parent;
    String color;
    List<E> list = new ArrayList<E>();
    public RedBlackNode(T key,E value)
    {
    	this.key = key;
    	if(value!=null)
    	{list.add(value);
    	this.value = value;}
    	color = "red";
    }

    public E getValue() {
    	if(list.isEmpty())
    		return null;
    		else
        return list.get(0);
    }


    public List<E> getValues() {
    	if(list.isEmpty())
    		return null;
        return list;
    }
    public String getcolor()
    {
    	return color;
    }
    public void setcolorblack()
    {
    	this.color = "black";
    }
}
