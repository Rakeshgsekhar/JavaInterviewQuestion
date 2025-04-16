public class OddEvenNumberGenerator {
    private int currentValue = 1;
    private int totalSequyence;

    public OddEvenNumberGenerator(int totalSequyence) {
        this.totalSequyence = totalSequyence;
    }

    public void printOdd(){
        synchronized (this){
            while(currentValue<totalSequyence){
                while(currentValue%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+currentValue++);
                notifyAll();
            }
        }
    }

    public void printEvenNumber(){
        synchronized (this){
            while(currentValue<totalSequyence){
                while(currentValue%2!=0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+currentValue++);
                notifyAll();
            }
        }
    }
}
