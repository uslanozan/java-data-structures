public class Queue {
    private int [] values;
    private int rear,front;

    public Queue(int size){
        values=new int[size];
        rear=0;   //en başta ikisi de 0 . Boş olduğunu göstermek için
        front=0;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return rear==values.length;
    }
    public void enQueue(int val){
        if(isFull()) {
            System.out.println("queue is full");
            return;
        }
        values[rear]=val;
        rear++;
    }
    public int deQueue(){
        if(isEmpty())
            return -1;
        front++;  //front artıyor ama eski elemanlar queue dan silnmiyor
        return values[front-1];
    }
    public int count(){
        return rear-front;
    }

    public int peek(){
        if(!isEmpty()){
            return values[front];
        }
        else {
            return 0; //throw new IllegalStateException("Stack is empty"); daha mantıklı gibi
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <rear ; i++) {
            System.out.println(values[i]);
        }
    }
}