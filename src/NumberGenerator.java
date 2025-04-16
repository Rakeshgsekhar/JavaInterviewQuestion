public class NumberGenerator {
    private int currNumber = 1;
    private int numberOfThreads;
    private int totalNumberInSeq;

    public NumberGenerator(int numberOfThreads, int totalNumberInSeq) {
        this.numberOfThreads = numberOfThreads;
        this.totalNumberInSeq = totalNumberInSeq;
    }

    public void printNumber(int index) {
        synchronized (this){
            while(currNumber<totalNumberInSeq-1){
                while(currNumber%numberOfThreads != index){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName()+":"+currNumber++);
                notifyAll();
            }
        }
    }
}
