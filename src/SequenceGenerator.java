public class SequenceGenerator implements Runnable{
    private NumberGenerator numberGenerator;
    private int index;

    public SequenceGenerator(NumberGenerator numberGenerator, int index) {
        this.numberGenerator = numberGenerator;
        this.index = index;
    }

    @Override
    public void run() {
        numberGenerator.printNumber(index);
    }
}
