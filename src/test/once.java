package test;

public class once {
    public static void main(String[] args) {
        Runner1 r=new Runner1();
        Runner2 rr=new Runner2();
        Thread t=new Thread(r);
        Thread tt=new Thread(rr);
        t.start();
        tt.start();
        for(int i=0;i<500;i++)
            System.out.println(i);
    }



}
class  Runner1 implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<500;i++)
            System.out.println(i+"sdas");
    }
}
class  Runner2 implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<500;i++)
            System.out.println(i+"sssssssdas");
    }
}