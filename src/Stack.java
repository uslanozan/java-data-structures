public class Stack {
    private int [] values;
    private int top;
    public Stack(int size){ //eleman sayısı
        this.top=-1;  // push ederken 1 arttırdığımızda 0 olması için, hiç elemnan olmadığını belirtmek için
        this.values=new int[size];
    }

    public int peek(){
        if (isEmpty())
            return -1;  // throw new IllegalStateException("Stack is empty"); daha mantıklı
                        // Hoca pozitif karakterlere göre yazdığı için -1 geçerli değil
        return this.values[this.top];
    }
    public int size(){
        return values.length;
    }

    public int count(){
        return this.top+1;
    } // kaç tane eleman olduğunu verir. Kapasitesini değil
    public boolean isEmpty(){
        return this.top==-1;
    }
    public boolean isFull(){
        return this.top==values.length-1;  //top değerini büyüklüğünden 1 eksik olursa en üstte yani dolu olur
    }
    public void push(int val){
        if(isFull()){
            System.out.println("stack is full");
        }else{
            this.top++;
            this.values[top]=val; // pushladığımız sayıyı eklemek için
        }
    }
    public int pop(){
        if (isEmpty())
            return -1;
        this.top--;
        return values[this.top+1]; // top 1 azaldı ama bize azalmadan önceki hali lazım.
                                    // O yüzden eski halini döndürmesii için 1 arttırıyoruz hem top değişmemiş oluyor
    }

    public void clear(){  //sadece top la iş yaptığımız için değerlerini anlamı kalmaz. Stacki temizlemiş olur.
        this.top=-1;
    }
    public void display(){ // stacki sırayla yazdırma
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        for (int i = this.top; i>-1 ; i--) {
            System.out.println(this.values[i]);
        }

    }

}
