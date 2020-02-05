public class Node<T extends Comparable> {
    private int index;
    private Node next;
    private T[] data;
    private int size;
    private int count;//количество занятых элементов

    Node(){
        next=null;
        size=4;
        data=(T[])new Comparable[size];
        count=0;
    }

    public int getIndex(){
        return this.index;
    }

    public int getSize(){
        return this.size;
    }

    public boolean setIndex(int i){
        index=i;
        return true;
    }

    public Node getNext(){
        if(next != null)
            return this.next;
        else
            return null;
    }

    public void setNext(Node n){
        next=n;
    }

    public int getCount(){
        return this.count;
    }

    public T getData(int i){
        return this.data[i];
    }

    public void setData(int i, T d){
        data[i]=d;
    }

    public boolean set(T d){
        if(count<size) {
            data[count] =d;
            count++;
            return true;
        }
        return expend(d);
    }

    public boolean setNumber(T d, int n){
        if(n<count) {
            if (count < size) {
                for (int i = count; i > n; i--)
                    data[i] = data[i - 1];
                data[n] = d;
                count++;
                return true;
            }
            else{
                if (next==null) {
                    next = new Node();
                    next.setIndex(index + 1);
                }
                next.setNumber(data[size-1], 0);
                for (int i = count-1; i > n; i--)
                    data[i] = data[i - 1];
                data[n] = d;
                return true;
            }
        }
        else{
            this.set(d);
            return true;
        }
    }

    public boolean delNumber(int n){
        for(int i = n; i < count-1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        data[count] = null;
        if(count==0) {
            if(next==null)
                return false;
            this.reData(next);
            this.next=next.next;
            for(Node i=this;;i=i.getNext()) {
                if(i.getNext()!=null)
                    i.getNext().setIndex(i.getNext().getIndex()-1);
                else
                    return true;
            }
        }
        return true;
    }

    public void reData(Node node){
        count=node.count;
        for (int i=0;i<size;i++)
            data[i]= (T) node.data[i];
    }

    public void show(){
        System.out.println(index);
        for(int i=0;i<count;i++){
            System.out.println(data[i]);
        }
        System.out.println();
    }

    public boolean expend(T d){
        Node newNode=new Node();
        for(int i=size/2, j=0;i<size;j++,i++){
            newNode.data[j]=data[i];
            data[i]=null;
            count--;
            newNode.count++;
        }
        newNode.data[size/2]=d;
        newNode.count++;
        newNode.next=next;
        if(next!=null) {
            newNode.index = next.index;
            next.index++;
        }
        else
            newNode.index=index+1;
        this.next=newNode;
        return true;
    }

    public void deleteNodeData(){
        for(int i=0;i<size;i++){
            data[i]=null;
        }
        data=null;
    }

}


