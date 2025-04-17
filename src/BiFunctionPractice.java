import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class BiFunctionPractice {
    public static void main(String[] args) {
        float value1 = 10f;
        float value2 = 20f;
        final  String ADD= "ADD";
        final String SUBTRACT = "SUBTRACT";
        final String DIVIDE = "DIVIDE";
        final String MULTIPLY = "MULTIPLY";
        BiFunction<Float,Float,Float> add = (a,b)->a+b;
        BiFunction<Float,Float,Float> sub = (a,b)->a-b;
        BiFunction<Float,Float,Float> product = (a,b)->a*b;
        BiFunction<Float,Float,Float> divide = (a,b)->{return b!=0 ? a/b:0;};

        Map<String, Float> results = new HashMap<>();

        results.put(ADD, add.apply(value1,value2));


        System.out.println(results.toString());

    }


}
