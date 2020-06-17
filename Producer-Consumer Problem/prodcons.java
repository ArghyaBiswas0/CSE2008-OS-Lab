import java.util.concurrent.Semaphore;
 
public class prodcons{
    public static void main(String args[]){
        Semaphore P=new Semaphore(1);
        Semaphore C=new Semaphore(0);
        Producer pr=new Producer(P,C);
        Consumer cr=new Consumer(C,P);
        Thread pT=new Thread(pr,"Pr Thread");
        Thread cT=new Thread(cr,"Cr Thread");
        pT.start();
        cT.start();
    }
}
class Producer implements Runnable{
    Semaphore P;
    Semaphore C;
    public Producer(Semaphore P,Semaphore C){
        this.P=P;
        this.C=C;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try {
                P.acquire();
                System.out.println("Produced : "+i);
                C.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    Semaphore C,P;
    public Consumer(Semaphore C, Semaphore P) {
        this.C = C;
        this.P = P;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try {
                C.acquire();
                System.out.println("Consumed : "+i);
                P.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
