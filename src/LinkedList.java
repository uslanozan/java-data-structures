public class LinkedList<T extends Comparable> {  //extends inheritance için kullanılır, implements interface için
    private Node<T> head;
    //Constructor oluşturmadık çünkü zaten headd null olarak oluşucak. Tekrar constructorda yazmaya gerek yok
    public Node<T> createNode(T val){  //Node sınıfından bir değer alıyor.
        return new Node<T>(val);
    }
    public void insertToFront(T val){  //Başa yani sola eklemek
        Node<T> newNode=createNode(val);
        newNode.next=head;  //Önce yeni node u head e bağla sonra onu yeni head yap
        head=newNode;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;  //Burada değer döndürmesine gerek yok sadece güncellemesi yeterli
                    // o yüzden return ün yanında bir şey yok
        }
        Node<T> iterator=head;
        while(iterator.next!=null)
            iterator=iterator.next;
        iterator.next=newNode;

    }

    public boolean search(T val){
        Node<T> iterator=head;
        while (iterator!=null){
            if (iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }
    public T findMin(){
        if (head==null)
            return null;
        T min=head.value;
        Node<T> iterator=head.next;
        while (iterator!=null){
            if(min.compareTo(iterator.value)==1)
                min=iterator.value;
            iterator=iterator.next;
        }
        return min;
    }
    public void sortedInsert(T val){   //?
        Node<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else if (val.compareTo(head.value)<=0){  //headin değeri valdan küçük ya da eşitse
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.value.compareTo(val)==-1){ //val iterator.next in değerinden küçükse
                iterator=iterator.next;
            }
            newNode.next=iterator.next;
            iterator.next=newNode;
        }
    }

    public void deleteTheFirst(){
        if(head!=null)
            head=head.next;
    }

    public void deleteFromEnd(){
        if (head != null) {
            if(head.next==null){ // tek eleman olma durumu
                head=null;
                return;
            }
            Node<T> iterator, previous;
            iterator = previous = head;

            while (iterator.next != null) {
                previous = iterator;
                iterator = iterator.next;
            }
            previous.next = null;
        }
        else {
            System.out.println("List is empty");
        }
    }
    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0) // girdiğimiz sayı headin değerine eşit değilse headi arttırır
            head=head.next;              // Generic class olduğu için direkt karşılaştıramayız
        else{                            // O yüzden compareTo
            Node<T> previous=head, iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0)   {
                previous=iterator;
                iterator=iterator.next;
            }
            if(iterator!=null)
                previous.next=iterator.next;

        }
    }

    public void recursiveAddToEnd(T val){

        head=recursiveAddToEnd(head, val);
    }
    public Node<T> recursiveAddToEnd(Node<T> tempHead, T val)
    {
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }

    public void swapFirstAndLastNodes(){
        if (head==null || head.next==null)
            return;
        Node<T> iterator=head, previous=head;
        while(iterator.next!=null){
            previous=iterator;
            iterator=iterator.next;
        }
        if(head.next==iterator){
            iterator.next=head;
            head.next=null;
            head=iterator;
        }else{
            iterator.next=head.next;
            previous.next=head;
            head.next=null;
            head=iterator;
        }
    }

    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.print(iterator+ " ");  //Node classında toString olduğu için iterator.value gerek yok
            iterator=iterator.next;
        }
        System.out.println();

    }

    public int findSize(){
        Node<T> iterator=head;
        int count=1;
        while (iterator.next!=null){
            count++;
            iterator=iterator.next;
        }
        return count;
    }

    public Node<T> findMinNode(Node<T> startingNode){
        Node<T> iterator=startingNode;
        Node<T> min= startingNode;
        while(iterator!=null){
            if(iterator.value.compareTo(min.value)==-1)
                min=iterator;
            iterator=iterator.next;
        }
        return min;
    }
    public void selectionSort() {
        if (head == null)
            return;
        Node<T> iterator = head;
        while (iterator.next != null) {
            Node<T> min = findMinNode(iterator);
            T temp = iterator.value;
            iterator.value = min.value;
            min.value = temp;
            iterator = iterator.next;
        }
    }


        public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            Node<T> left = head;
            Node<T> right = null;

            while (left.next != right) {
                if (left.value.compareTo(left.next.value) > 0) {
                    T temp = left.value;
                    left.value = left.next.value;
                    left.next.value = temp;
                    swapped = true;
                }
                left = left.next;
            }
        }
    }
}