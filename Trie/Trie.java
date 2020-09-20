package Trie;
import java.util.Queue;
import java.util.ArrayList;
public class Trie<T> implements TrieInterface {

	TrieNode<T> head = new TrieNode<T>('A');
	String printst ="";
    
    public boolean delete(String word) 
    {
       TrieNode<T> temp = this.search(word);
       if(temp==null)
       {
    	   return false;
    	   
       }
       else
    	   if(temp.list.size()!=0)
    	   {
    		   temp.end=false;
    	   }
    	   else
    	   {
    		   TrieNode<T> temp1 = head;
    		   TrieNode<T> last = head;
    		   int cnt=0;
    		   for(int i =0;i<word.length();i++)
    	    	{
    	    		for(int j =0 ;j<temp1.list.size();j++)
    	    		{
    	    			if(temp1.list.get(j).getval() == word.charAt(i))
    	    			{
    	    				if(temp1.list.size()>1)
    	    				{
    	    					last = temp1;
    	    					cnt = j;
    	    					
    	    				}
    	    	            temp1 = temp1.list.get(j);
    	    				break;
    	    			}
    	    		}
    	    	}
    		   last.list.remove(cnt);
    		   
    		   
    	   }
       return true;
    		   
        	
    }

    @Override
    public TrieNode search(String word)
    {
    	TrieNode<T> temp = head;
    	
    	for(int i =0;i<word.length();i++)
    	{
    		boolean flag = false;
    		for(int j =0 ;j<temp.list.size();j++)
    		{
    			if(temp.list.get(j).getval() == word.charAt(i))
    			{
    				temp = temp.list.get(j);
    				flag = true;
    				break;
    			}
    		}
    		if(!flag)
    		return null;	
    	}
    	if(temp.getend())
    	return temp;
        return null;
    }

    @Override
    public TrieNode startsWith(String prefix) 
    {
         TrieNode<T> temp = head;
    	
    	for(int i =0;i<prefix.length();i++)
    	{
    		boolean flag = false;
    		for(int j =0 ;j<temp.list.size();j++)
    		{
    			if(temp.list.get(j).getval() == prefix.charAt(i))
    			{
    				temp = temp.list.get(j);
    				flag = true;
    				break;
    			}
    		}
    		if(!flag)
    		return null;	
    	}
    
    	return temp;
     
    }

    @Override
    public void printTrie(TrieNode trieNode)
    {
    	for(int j =0 ;j<trieNode.list.size();j++)
    	{
    		TrieNode<T> temp = (TrieNode<T>) trieNode.list.get(j);
    		if(temp.getend())
    			System.out.println(temp.getValue());
    		printTrie(temp);
    		
    	}
    }

    @Override
    public boolean insert(String word, Object value)
    {
    	TrieNode<T> temp = head;
    	for(int i =0;i<word.length();i++)
    	{
    		TrieNode<T> newnode = new TrieNode<T>( word.charAt(i));
    		boolean flag = false;
    		for(int j =0 ;j<temp.list.size();j++)
    		{
    			if(temp.list.get(j).getval() == newnode.getval())
    			{
    				temp = temp.list.get(j);
    				flag = true;
    				break;
    			}
    			else if(temp.list.get(j).getval() > newnode.getval())
    			{
    				temp.list.add(j, newnode);
    				temp = temp.list.get(j);
    				flag = true;
    				break;
    			}
    			
    		}
    		if(!flag)
    		{
    			temp.list.add(newnode);
    			temp = temp.list.get(temp.list.size()-1);
    		}
    	}
    	if(temp.getend())
    		return false;
    	temp.setend();
    	temp.setobj((T )value);
        return true;
    }

    public void printLevel(int level)
    {
    
    	if(level>=1)
    	{
    		pgl(head,level+1);
    	String[] words = printst.split(",");
    	int n = words.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (words[j].compareTo(words[j+1])>0)
                {
                  
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
    	String prst = "";
    	if(words.length>0)
    	{
        for(int i=0;i<words.length-1;i++)
    	{
    		if(!words[i].equals(" "))
    		{
    			prst+=words[i]+",";
    		}
    	}
        if(!words[words.length-1].equals(" "))
		{
			prst+=words[words.length-1];
		}
    	}
    	prst = prst.trim();
        System.out.println("Level "+level+": " + prst);
    	printst = "";
    	prst="";
    	}
       
    }
    public void pgl (TrieNode<T> root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
        	 printst += (root.getval() + ","); 
        else if(level>1 && level<=th(head)+1)
        {
        	for(int j=0;j<root.list.size();j++)
        	{
        		pgl(root.list.get(j),level-1);
        	}
        }
       
    } 

    public void print() 
    {
System.out.println("-------------");
System.out.println("Printing Trie");
        for(int j=1;j<=th(head)+1;j++)
        {
        	printLevel(j);
        }
        System.out.println("-------------");
        
    }
    public int th(TrieNode<T> root) 
    { 
        if (root == null) 
           return 0; 
        else
        {
            ArrayList<Integer> store = new ArrayList<Integer>();
            for(int j=0;j<root.list.size();j++)
            {
            	store.add(th(root.list.get(j)));
            }
            int max = -1;
            for(int j=0;j<store.size();j++)
            {
            	if(store.get(j)>max)
            		max = store.get(j);
            	
            }
            return max+1;
        } 
    } 
}