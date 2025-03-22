class twoStacks {
    private int[] arr = new int[200];
    private int i=0;
    private int j=199;
    
    twoStacks() {}

    // Function to push an integer into the stack1.
    void push1(int x) {
        arr[i++]=x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        arr[j--]=x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        return i==0?-1:arr[--i];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        
        return j==199?-1:arr[++j];
    }
}