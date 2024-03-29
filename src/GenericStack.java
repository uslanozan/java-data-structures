public class GenericStack<T extends Comparable> { // genel olarak her sınıf için kullanılabilecek bir class oluşturduk
                                                  // T buradaki herhangi bir sınıfı gösteriyor
    private T [] items;
    private int top;

    public GenericStack(Class<T> dataType, int size){
        this.top=-1;
        items=(T[])java.lang.reflect.Array.newInstance(dataType, size);
    }
    public T pop()
    {
        if(isEmpty()){
            System.out.println("stack is empty");
            return items[0];  // throw new EmptyStackException("Stack is empty"); bunu yazmak daha mantıklı
        }else{
            this.top--;
            return this.items[this.top+1];
        }
    }
    public boolean isEmpty()
    {
        return this.top==-1;
    }
    public boolean isFull()
    {
        return this.top==this.items.length-1;
    }
    public int size(){
        return this.items.length;
    }
    public T peek(){  // T tipinde dönceği için return tipi T olmalı
        return this.items[this.top];
    }

    public void clear(){
        this.top=-1;
    }
    public void display(){
        if(!isEmpty()) {
            for(int i=top;i>=0;i--){
                System.out.println(this.items[i]);
            }
        }

    }

    public void push(T val){
        if(isFull()){
            System.out.println("stack is full");
        }else{
            this.items[++this.top]=val;
        }
    }

}