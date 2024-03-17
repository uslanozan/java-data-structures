public class DoublyLinkedList<T extends Comparable> {
    DNode<T> head;
    public DNode<T> createNode(T val){
        return new DNode<T>(val);
    }

    public void insertToFront(T val){
        DNode<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }

    }

    public DNode<T> findMinNode(DNode<T> headStart){
        if(headStart!=null){
            DNode<T> iterator=headStart;
            DNode<T> minNode=headStart;
            while (iterator!=null){
                if(iterator.value.compareTo(minNode)==-1){
                    minNode=iterator;
                }
                iterator=iterator.next;
            }
            return minNode;
        }
        return null;
    }

    public void selectionSort(){
        DNode<T> headstart=head;
        while (headstart!=null){
            DNode<T> minNode=findMinNode(headstart);
            T temp=minNode.value;
            minNode.value=headstart.value;
            headstart.value=temp;
            headstart=headstart.next;
        }
    }
    public void insertToEnd(T val){
        DNode<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else{
            DNode<T> iterator=head;
            while(iterator.next!=null)
                iterator=iterator.next;
            newNode.prev=iterator;
            newNode.prev.next=newNode;

        }

    }

    public void deleteFromFront(){
        if (head!=null){
            if (head.next==null){
                head=null;
            }else{
                head=head.next;
                head.prev=null;
            }
        }
    }
    public void addAfterHead(T val){
        DNode<T> temp=createNode(val);
        if(head==null){
            head=temp;
        }else{
            temp.next=head.next;
            if(head.next!=null){
                temp.next.prev=temp;
            }
            temp.prev=head;
            head.next=temp;
        }
    }


    //we assume that every value is unique in the list.
    //you can modify it to handle the other case
    public void delete(T val){
        if(head==null)
            return;
        else if(head.value.compareTo(val)==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
        }else{
            DNode<T> iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0){
                iterator=iterator.next;
            }
            if(iterator==null)
                return;
            else{
                iterator.prev.next=iterator.next;
                if(iterator.next!=null)
                    iterator.next.prev=iterator.prev;
            }
        }
    }

}