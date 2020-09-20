package PriorityQueue;
import java.util.ArrayList;
public class MaxHeap<T extends Comparable> implements PriorityQueueInterface<T> {

    public ArrayList<Pair<T>> heap = new ArrayList<Pair<T>>();
    int prime =0,prime2 =0;
    public int parent(int pos)
    {
    	if(pos==0)
    		return 0;
    	if(pos%2==0)
    		return pos/2 -1;
    	else
    		return pos/2;
    }
    
    public int leftch(int pos)
    {
    	return 2*pos +1;
    }
    public int rightch(int pos)
    {
    	return 2*pos +2;
    }
    public int size()
    {
    	return heap.size();
    }
    
    public void insert(T element) 
    {
    	prime++;
    	heap.add(new Pair<T> (prime,element));
    	int current = heap.size()-1;
    	
    	while(heap.get(current).compareTo(heap.get(parent(current)))>0)
    	{
    		Pair<T> temp = heap.get(current);
    		heap.set(current, heap.get(parent(current)));
    		heap.set(parent(current), temp);
    		current = parent(current);
    	}
    }
     public T extractMax()
    {
    	if(heap.size()>0)
    	{
    		Pair<T> temp = heap.get(0);
    		heap.set(0, heap.get(heap.size()-1));
    		heap.remove(heap.size()-1);
    		int current = 0;
    		while(current>=0 && ((current<(heap.size())/2 && heap.get(current).compareTo(heap.get(leftch(current)))<=0) || (current<(heap.size()-1)/2 && heap.get(current).compareTo(heap.get(rightch(current)))<=0)))
    		{
    			Pair<T> temp2 ;
    			if(rightch(current)<heap.size() && leftch(current)<heap.size())
    			{
    			if(heap.get(rightch(current)).compareTo(heap.get(leftch(current)))<0)
    			{
    				temp2 = heap.get(leftch(current));
    				heap.set(leftch(current), heap.get(current));
    				heap.set(current, temp2);
    				current = leftch(current);
    			}
    			else 
    			{
    				temp2 = heap.get(rightch(current));
    				heap.set(rightch(current), heap.get(current));
    				heap.set(current, temp2);
    				current = rightch(current);
    				
    			}
    			}
    			else if(rightch(current)<heap.size())
    			{   
    			
    				temp2 = heap.get(rightch(current));
    				heap.set(rightch(current), heap.get(current));
    				heap.set(current, temp2);
    				current = rightch(current);
    			}
    			else
    			{
    				temp2 = heap.get(leftch(current));
    				heap.set(leftch(current), heap.get(current));
    				heap.set(current, temp2);
    				current = leftch(current);
    				
    			}
    		}
    		return temp.object;
    	}
        return null;
    }
     
    public void MaxHeapify(int current)
    {
    	while(current>=0 && ((current<(heap.size())/2 && heap.get(current).compareTo(heap.get(leftch(current)))<=0) || (current<(heap.size()-1)/2 && heap.get(current).compareTo(heap.get(rightch(current)))<=0)))
		{
			Pair<T> temp2 ;
			if(rightch(current)<heap.size() && leftch(current)<heap.size())
			{
			if(heap.get(rightch(current)).compareTo(heap.get(leftch(current)))<0)
			{
				temp2 = heap.get(leftch(current));
				heap.set(leftch(current), heap.get(current));
				heap.set(current, temp2);
				current = leftch(current);
			}
			else 
			{
				temp2 = heap.get(rightch(current));
				heap.set(rightch(current), heap.get(current));
				heap.set(current, temp2);
				current = rightch(current);
				
			}
			}
			else if(rightch(current)<heap.size())
			{
				temp2 = heap.get(rightch(current));
				heap.set(rightch(current), heap.get(current));
				heap.set(current, temp2);
				current = rightch(current);
			}
			else
			{
				temp2 = heap.get(leftch(current));
				heap.set(leftch(current), heap.get(current));
				heap.set(current, temp2);
				current = leftch(current);
				
			}
		}
    }
    public void constructheap()
    {
    
    	for(int i= heap.size()/2-1;i>=0;i--)
    		MaxHeapify(i);
    }
    public void addition(T element)
    {
    	prime2++;
    	heap.add(new Pair<T>(prime2,element));
    }
    

}