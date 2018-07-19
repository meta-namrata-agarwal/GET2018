package linklist;

public class IMPLEMENT {
	 final static int MAX = -999999;
	    node top = null;
	 
	    public boolean empty() {
	        return top == null;
	    }
	 
	    public void push(int n) {
	        node p = new node(n);
	        p.next = top;
	        top = p;
	    } 
	 
	    public int pop() {
	        if (this.empty())
	            return MAX; 
	        int hold = top.data;
	        top = top.next;
	        return hold;
	    }
	    
	    public void display()
	    {
	        node tempDisplay = top;
	        while (tempDisplay != null){ 
	            System.out.println(tempDisplay.data);
	            tempDisplay = tempDisplay.next;
	        }
	    }
	    
	    public int topv() {
	        if (empty())
	        {
	            System.out.printf("Stack is empty!");
	            return MAX;
	        }
	        else
	        {
	            return top.data;
	        }
	    }    
}
