public class CircularLinkedList<T extends Comparable> {
    Node<T> head;
    public void insertToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
        }
    }
    public void insertToFront(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;  // tek eleman kendini gösterir
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }

    public void display(){
        Node<T> iterator=head;
        while (head!=null && iterator.next!=head ){  // önce head in null olup olmadığı kontrol edilmeli
                                        // çünkü iterator null ve nullun nextine bakmaya çalıştığı için crash verir
            System.out.println(iterator.value);      // ilki 0 sa ikincisine bakmaya gerek yok çöküyo ?
            iterator=iterator.next;                  // bu yüzden while kısmında head!=null önce gelmeli
        }
        if (head!=null )
            System.out.println(iterator.value);
    }



}