
public class StackOperations {

    public static boolean isEqual(Stack s1, Stack s2){
        if(s1.count()!=s2.count())
            return false;
        Stack tempStack1=new Stack(s1.count());
        Stack tempStack2=new Stack(s1.count());
        boolean result=true;
        while(!s1.isEmpty()){
            int val1=s1.pop();
            int val2=s2.pop();
            tempStack1.push(val1);
            tempStack2.push(val2);
            if(val1!=val2) {
                result = false;
                break;
            }
        }
        while(!tempStack1.isEmpty()){
            s1.push(tempStack1.pop());
            s2.push(tempStack2.pop());
        }
        return result;
    }

    public static boolean search(Stack stk, int val) {
        Stack tempStack = new Stack(stk.size());  //geçici stack oluştu
        int foundIndex = -1;          // Bulunacak elemanın indeksi
        while (!stk.isEmpty()) {     // Verilen yığındaki elemanları geçici stack iteriz. Çünkü pop yaparsak silinir
            int topValue = stk.pop();
            tempStack.push(topValue);
            if (topValue == val) {   // Aranan değeri bulduğumuzda indeksi kaydet
                foundIndex = tempStack.count() - 1;  //1 (0. eleman)
            }                                        //2 (1. eleman)
                                                     //3 (2. eleman)
        }
        while (!tempStack.isEmpty()) {   // TempStack'ı tekrar eski haline getiririz.
            stk.push(tempStack.pop());
        }

        return foundIndex != -1;  // Eğer eleman bulunduysa indeksi döndür, aksi halde -1 döndür.
    }
    //write a remove method that will remove a specific element from a given stack
    // if there are more than one of the element it should remove all
    public static void remove(Stack stk,int val){
        Stack tempStack=new Stack(stk.size());
        while (!stk.isEmpty()){
            int topValue=stk.pop();
            if(topValue!=val){ //val ile aynı değilse push yapıcak
                tempStack.push(topValue);
            }
        }
        while (!tempStack.isEmpty()){
            stk.push(tempStack.pop());
        }
        stk.display();
    }
    //Write a method that will find the max number in the stack
    public static int findMax(Stack stk){
        int maxvalue;
        int topValue;
        Stack tempStack=new Stack(stk.size());
        topValue=stk.pop();
        maxvalue=topValue;

        while (!stk.isEmpty()){
            topValue=stk.pop();
            if (topValue>maxvalue){
                maxvalue=topValue;
            }
        }
        while (!tempStack.isEmpty()) {
            stk.push(tempStack.pop());
        }
        return maxvalue;
    }
}