package assignment;

public class ArrayImplement 
{
	 int top =-1;
	    int size;
	    int[] stack ;

	    public ArrayImplement(int arraySize){
	        size=arraySize;
	        stack= new int[size];
	    }

	    public void push(int value){
	        if(topFull())
	            System.out.println("Stack is full");
	        else
	            stack[++top]=value;
	    }

	    public void pop(){
	        if(isEmpty())
				System.out.println("stack is empty");
	            
	        else{
	            top=top-1;
	        }
	    }
		public boolean topFull()
		{
			if(top==size-1)
				return true;
			else 
				return false;
		}

	    public boolean isEmpty()
		{
			 if(top==-1)
				 return true;
			 else 
				return false;
	    }

	    public void display(){

	        for(int i=0;i<=top;i++){
	            System.out.print(stack[i]+ " ");
	        }
	        System.out.println();
	    }
	    public static void main(String[] args) {
	    	ArrayImplement newStack = new ArrayImplement(5);
	        newStack.push(10);
	        newStack.push(1);
	        newStack.push(50);
	        newStack.push(20);
	        newStack.push(90);

	        newStack.display();
	        newStack.pop();
	        newStack.pop();
	        newStack.display();
	    }
}
