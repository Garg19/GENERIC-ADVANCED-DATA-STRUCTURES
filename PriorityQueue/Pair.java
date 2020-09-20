package PriorityQueue;

public class Pair<T extends Comparable> implements Comparable<Pair<T>>{
	public int primacy;
	public T object;
	public Pair(int primacy,T object)
	{
		this.primacy = primacy;
		this.object = object;
	}

	public int compareTo(Pair<T> o) 
	{
		int s = this.object.compareTo(o.object);
		if(s!=0)
			return s;
			else
			{
				if(this.primacy<o.primacy)
					return 1;
				else
					return -1;
			}
	}
	public String toString()
	{
		return object.toString();
	}

}
