// Calc.java
// Define a class for doing RPN.

class Calc {
	
    private double[] stackArray;
    private int top;
// Constructor
public Calc() {
	
    stackArray = new double[100];
    top=-1;
}

// Push a number
public void push(double x) {
    if (top > 99)
	throw new IllegalArgumentException("too many numbers in the stack");
    else
    	stackArray[++top]=x;
}

// Pop top number (removes)
public double pop() {
    if (depth()==0)
	throw new IllegalArgumentException("stack is empty");
    else
   	 return stackArray[top--];
}

// Peek at top number (does not remove)
public double peek() {
    if (depth()==0)
	throw new IllegalArgumentException("stack is empty");
    else
    	return stackArray[top];
}

// Add top two numbers
public void add() {
    if (depth()<2)
	throw new IllegalArgumentException("less than 2 numbers");
    else{	
    	double sum = pop()+pop();
    	push(sum);
  	}
}
// Subtract top two numbers (top on right side)
public void subtract() {
    if (depth()<2)
        throw new IllegalArgumentException("less than 2 numbers");
    else{
	double temp = pop();
	double minus = pop()-temp;
	push(minus);
	}
}

// Multiply top two numbers
public void multiply() {
    if (depth()<2)
        throw new IllegalArgumentException("less than 2 numbers");
    else{
	double product = pop()*pop();
	push(product);
	}
}

// Divide top two numbers (top on bottom)
public void divide() {
    if (depth()<2)
        throw new IllegalArgumentException("less than 2 numbers");
    else{
	double temp=pop();
	if (temp ==0)
		throw new IllegalArgumentException("Argument 'divisor' is 0");
	double division = pop()/temp;
	push(division);
	}
}

// Return how many numbers are in the stack
	public int depth() {
		return top+1;
	}

// find the base 2 logarithm of the top number
public void log2() {
    if (depth()==0)
        throw new IllegalArgumentException("stack is empty");
    else{
	double up = Math.log(pop());
	double down = Math.log(2);
	double Log2 = up/down;
	push(Log2);	
	}
    }
}
