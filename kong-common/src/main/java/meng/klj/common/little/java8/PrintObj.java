package meng.klj.common.little.java8;

public class PrintObj {

    private void first(){
        System.out.println("first");
    }

    private void second(){
        System.out.println("second");
    }

    private void third(){
        System.out.println("third");
    }


    public static void main(String[] args) throws InterruptedException {
        PrintObj obj = new PrintObj();

        /*Thread firstThread = new Thread(() -> obj.first());
        Thread secondThread = new Thread(() -> obj.second());
        Thread thirdThread = new Thread(() -> obj.third());*/

//        firstThread.start();
//        firstThread.join();
//        secondThread.start();
//        secondThread.join();
//        thirdThread.start();

        Thread firstThread = new Thread(() ->{
            try {
                synchronized (obj){
                    obj.wait();
                    obj.first();
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }});
        Thread secondThread = new Thread(() ->{
        try {
            synchronized (obj){
                obj.wait();
                obj.second();
                obj.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }});
        Thread thirdThread =new Thread(() ->{
            try {
                synchronized (obj){
                    obj.wait();
                    obj.second();
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }});

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }


}
