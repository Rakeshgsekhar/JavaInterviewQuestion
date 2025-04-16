public class OddEvenSequenceGenerator implements Runnable{
    private int index;
    OddEvenNumberGenerator oddEvenNumberGenerator;

    public OddEvenSequenceGenerator(OddEvenNumberGenerator oddEvenNumberGenerator, int index) {
        this.index = index;
        this.oddEvenNumberGenerator = oddEvenNumberGenerator;
    }

    @Override
    public void run() {
        if(this.index%2==0)oddEvenNumberGenerator.printEvenNumber();
        else oddEvenNumberGenerator.printOdd();

    }
}
