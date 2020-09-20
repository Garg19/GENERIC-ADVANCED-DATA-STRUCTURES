package RedBlack;

import java.util.ArrayList;

public class RBTree<T extends Comparable, E> implements RBTreeInterface<T, E>  {

    public RedBlackNode<T,E> root = new RedBlackNode<T,E>(null,null);
    public void insert(T key, E value) 
    {
        if(root.key==null && root.value==null)
        {
        	root.key = key;
        	root.list.add(value);
        	root.setcolorblack();
        }
        else
        {
        	RedBlackNode<T,E> bst = new RedBlackNode<T,E>(key,value);
        	RedBlackNode<T,E> current = root;
		    while(current.left!=null && (current.key.compareTo(bst.key)>0) || current.right!=null && (current.key.compareTo(bst.key)<0))
		    {
		    	if(current.key.compareTo(bst.key)<0)
		    		current = current.right;
		    	else
		    	    current = current.left;
		    		
		    }
		    if(current.key.compareTo(bst.key)<0)
	    		{
		    	current.right = bst;
		    	bst.parent = current;
	    		}
	    	else if(current.key.compareTo(bst.key)>0)
		    {
	    		current.left = bst;
	    		bst.parent = current;
		    }
	    	else
	    	{

	    		current.list.add(value);
	    		return;
	    	}
		    while(bst.color=="red" && bst.parent.color=="red")
		    {
		    	if(bst.parent.parent.left!=null && bst.parent.parent.left.key.compareTo(bst.parent.key)==0)
		    	{
		    		if(bst.parent.parent.right!=null && bst.parent.parent.right.color=="red")
		    		{
		    			bst.parent.color = "black";
		    			bst.parent.parent.right.color = "black";
		    			if(bst.parent.parent.key.compareTo(root.key)!=0)
		    			bst.parent.parent.color = "red";
		    			bst = bst.parent.parent;
		    		}
		    		else
		    			if(bst.parent.left!=null && bst.parent.left.key.compareTo(bst.key)==0)
		    			{
		    				rr(bst.parent.parent);
		    				
		    				bst.parent.color = "black";
		    				bst.parent.right.color = "red";
		    				bst = bst.parent;
		    			}
		    			else if(bst.parent.right!=null && bst.parent.right.key.compareTo(bst.key)==0)
		    			{
		    				lr(bst.parent);
		    				bst = bst.parent.left;
		    			}
		    	}
		    	else
		    	{
		    		if(bst.parent.parent.left!=null && bst.parent.parent.left.color=="red")
		    		{
		    			bst.parent.color = "black";
		    			bst.parent.parent.left.color = "black";
		    			if(bst.parent.parent.key.compareTo(root.key)!=0)
		    			bst.parent.parent.color = "red";
		    			bst = bst.parent.parent;
		    		}
		    		else
		    			if(bst.parent.right!=null && bst.parent.right.key.compareTo(bst.key)==0)
		    			{
		    				lr(bst.parent.parent);
		    				bst.parent.color = "black";
		    				bst.parent.left.color = "red";
		    				bst = bst.parent;
		    			}
		    			else if(bst.parent.left!=null && bst.parent.left.key.compareTo(bst.key)==0)
		    			{
		    				rr(bst.parent);
		    				bst = bst.parent.right;
		    			}
		    		
		    	}
		    }
        }
	
    }
    public ArrayList printPreorder(RedBlackNode<T,E> node , ArrayList l ) 
    { 
        if (node == null) 
        {
        	
        }
        else
        {
        	 l.add(node);
        	 printPreorder(node.left,l); 
             printPreorder(node.right,l);
        }
        return l;
        
    }
 

    public void rr(RedBlackNode<T,E> testnode )
    {
    	
    	RedBlackNode<T,E> chk = testnode.left.right;
    	RedBlackNode<T,E> newnode = new RedBlackNode<T,E>(testnode.key,testnode.value);
    	newnode.color = testnode.color;
    	newnode.right = testnode.right;
    	newnode.list = testnode.list;
    	if(testnode.right!=null)
    		testnode.right.parent = newnode;
    	newnode.left = chk;
    	if(chk!=null)
    		chk.parent= newnode;
    	
    		testnode.key = testnode.left.key;
    		testnode.color = testnode.left.color;
    		testnode.value = testnode.left.value;
    		
    		testnode.list = testnode.left.list;
    		if(testnode.left.left!=null)
    			testnode.left.left.parent = testnode;
    		testnode.right = newnode;
    		newnode.parent = testnode;
    		testnode.left = testnode.left.left;
    		
    }
    public void lr(RedBlackNode<T,E> testnode )
    {
    
    	RedBlackNode<T,E> chk = testnode.right.left;
    	RedBlackNode<T,E> newnode = new RedBlackNode<T,E>(testnode.key,testnode.value);
    	newnode.color = testnode.color;
    	newnode.left = testnode.left;
    	newnode.list = testnode.list;
    	if(testnode.left!=null)
    		testnode.left.parent = newnode;
    	newnode.right = chk;
    	if(chk!=null)
    		chk.parent= newnode;
    	
    		testnode.key = testnode.right.key;
    		testnode.color = testnode.right.color;
    		testnode.value = testnode.right.value;
    		testnode.list = testnode.right.list;
    		if(testnode.right.right!=null)
    			testnode.right.right.parent = testnode;
    		testnode.left = newnode;
    		newnode.parent = testnode;
    		testnode.right = testnode.right.right;
    }
    
    public RedBlackNode<T, E> search(T key) 
    {
    	if(root.key!=null)
    	{
    	RedBlackNode<T,E> current = root;
	    while(current.left!=null && (current.key.compareTo(key)>0) || current.right!=null && (current.key.compareTo(key)<0))
	    {
	    	if(current.key.compareTo(key)<0)
	    		current = current.right;
	    	else
	    	    current = current.left;
	    		
	    }
	    if(current.key.compareTo(key)==0)
	    	return current;
	    else
	    	return new RedBlackNode<T,E>(null,null);
    	}
        return new RedBlackNode<T,E>(null,null);
    }
   
}