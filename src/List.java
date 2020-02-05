import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;


public class List<T extends Comparable>{
    private Node head;
    private Node tail;

    List(){
        head=tail=null;
    }

    void add(T data)           //добавление в конец
    {
        if (head == null) {
            head=new Node();
            head.set(data);
            head.setIndex(0);
            tail=head;
            return;
        }
        else {
            for (Node i = tail; ; i = i.getNext()) {
                tail.set(data);
                if (i.getNext() != null) {
                    tail = i.getNext();
                    return;
                }
                return;
                }
            }
    }

    void print()        //вывод
    {
        Node i = head;
        while (i != null) {
            i.show();
            i = i.getNext();
        }
    }

    void addNumber(T data, int n) throws Exception        //вставка но номеру
    {
        for(Node i=head;;i=i.getNext()){
            n-=i.getCount();
            if(n < 0){
                if(i.setNumber(data,(n+i.getCount()))){
                    if(tail.getNext()!=null)
                        tail= tail.getNext();
                    return;
                }
            }
            if(i==tail)
                throw new Exception("Выход за пределы списка");
        }
    }

     T getNumber(int n) throws Exception        //получение но номеру
    {
        for(Node i=head;;i=i.getNext()) {
            n -= i.getCount();
            if (n < 0)
                return (T) i.getData(n + i.getCount());
            if(i==tail)
                throw new Exception("Выход за пределы списка");
        }
    }

    void deleteNumber(int n) throws Exception        //удаление но номеру
    {
        for(Node i=head;;i=i.getNext()) {
            n -= i.getCount();
            if (n < 0) {
                if (i.delNumber(n + i.getCount())) {
                    if(tail.getNext()!=null)
                        tail= tail.getNext();
                    return;
                }
                else{
                    tail=retail();
                    return;
                }
            }
            if (i == tail)
                throw new Exception("Выход за пределы списка");
        }
    }

    Node retail(){
        for(Node i=head;;i=i.getNext()){
            if(i.getNext()==tail){
                i.setNext(null);
                return i;
            }
        }
    }

    void sort(boolean desc) {
        Vector<T> asArr = this.toVector();
        if (desc) {
            Collections.sort(asArr, Collections.reverseOrder());
        } else {
            Collections.sort(asArr);
        }
        this.fromVector(asArr);
    }

    Vector<T> toVector() {
        Vector<T> allValues = new Vector<>();
        Node<T> node = head;
        while (node != null) {
            for (int i = 0; i < node.getCount(); ++i) {
                allValues.add(node.getData(i));
            }
            node = node.getNext();
        }
        return allValues;
    }

    Node fromVector(Vector v) {
        Node<T> node = head;
        while (node != null) {
            for (int i = 0; i < node.getCount(); ++i) {
                node.setData(i, (T) v.get(0));
                v.remove(0);
            }
            node = node.getNext();
        }
        return head;
    }

    public void toDo(forEach fun) {
        Node node = head;
        while(node!=null) {
            for (int i = 0; i < node.getCount(); i++)
                fun.toDo(node.getData(i));
            node=node.getNext();
        }
    }

}