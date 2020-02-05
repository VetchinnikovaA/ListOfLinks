import java.lang.String;
import java.lang.StringBuilder;

public class main {

    static int generateInt(){
        int count = (int)(Math.random()*30);
        return count;
    }

    static String generateString(){
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdyfghijklmnopqrstuvwxyz1234567890 ";
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*30);
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString.toString();
    }

    public static void main(String[] args) throws Exception {
        List<String> l=new List();
        String s;
        for(int i=0;i<10;i++){
            s=String.valueOf(i);
            l.add(s);
        }
        l.print();
        for(int i=100;i<110;i++){
            s=String.valueOf(i);
            l.addNumber(s,1);
        }
        //l.sort(false);
        for(int i=0;i<10;i++)
            l.deleteNumber(1);
        l.addNumber("77",4);
        l.deleteNumber(6);
        l.deleteNumber(0);
        l.deleteNumber(4);
        l.deleteNumber(1);
        l.deleteNumber(6);
        l.print();
        System.out.println(l.getNumber(6));
        System.out.println("Foreach: ");
        l.toDo((vv)->{ System.out.print(vv+ " "); });
        /*String S=generateString();
        System.out.println(S);
        l.add(S);
        S=generateString();
        l.add(S);
        S=generateString();
        l.add(S);
        l.print();

        S=generateString();
      //  l.addNumber(S,3);
        S=generateString();
       // l.addNumber(S,0);
        //l.addNumber(S,-1);
        //l.addNumber(S,10);
        S=generateString();
      //  l.add(S);
       //l.print();
//
       // l.getNumber(0);
        //l.getNumber(10);
      /*  l.getNumber(-1);

        l.deleteNumber(0);
        l.print();
        S=generateString();
        l.add(S);
        S=generateString();
        l.addNumber(S,0);
        l.print();

        l.sort(false);
        l.print();
       */

    }
}
