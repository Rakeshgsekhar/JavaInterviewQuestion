import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final int NUMBER_OF_THREADS = 3;
    private static final int TOTAL_SEQUENCE_NUMBER = 10;
    public static void main(String[] args) {
/*
        NumberGenerator numberGenerator = new NumberGenerator(NUMBER_OF_THREADS,TOTAL_SEQUENCE_NUMBER);

        Thread thread1 = new Thread(new SequenceGenerator(numberGenerator,1),"Thread-1");
        Thread thread2 = new Thread(new SequenceGenerator(numberGenerator,2),"Thread-2");
        Thread thread3 = new Thread(new SequenceGenerator(numberGenerator,0),"Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();



        OddEvenNumberGenerator oddEvenNumberGenerator = new OddEvenNumberGenerator(10);

        Thread tOdd = new Thread(new OddEvenSequenceGenerator(oddEvenNumberGenerator,1),"Thread-Odd");
        Thread tEven = new Thread(new OddEvenSequenceGenerator(oddEvenNumberGenerator,2),"Thread-Even");

        tOdd.start();
        tEven.start();

*/
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1","A",5000,new Department("D1","D1")));
        employees.add(new Employee("2","B",6000,new Department("D1","D1")));
        employees.add(new Employee("3","C",7000,new Department("D1","D1")));
        employees.add(new Employee("4","D",500,new Department("D1","D1")));
        employees.add(new Employee("5","E",5000,new Department("D2","D2")));


        Map<String,List<Employee>> result = employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment().getName()));
        result.forEach((department, employees1) -> result.put(department,result.get(department).stream().sorted(Comparator.comparing(Employee::getSalary)).limit(3).collect(Collectors.toList())));

        result.forEach((resultMap,resultValue)->{
            System.out.println(resultMap+":");
            resultValue.forEach(r->System.out.println(r.toString()));

        });
       // System.out.println(result);

        //op


        /*
        find minimum
        [1 ,0 ,2 ]
        0
        2
        [1 3 2]
        start with a candycount as 1
        [1,1,1]
        [
          */

        /*
        [1,1,1,1,1,1] -> 14
        [3,1,0,2,4,5]
        [1,1,1,2,3,4]
        [3,2,1,2,3,4] -> 15
     //  3 1 0 2 4 5*/

        int [] ip = new int[] {3,1,0,2,4,5};
        int[] temp = new int[ip.length];
        for(int i = 0 ;i<temp.length;i++){
            temp[i] = 1;
        }

        for(int i = 1 ;i<ip.length;i++){
            if(ip[i]>ip[i-1]){
                temp[i] = temp[i]+temp[i-1];
            }
        }
        for(int i = ip.length-2 ;i>=0;i--){
            if(ip[i]>ip[i+1]){
                temp[i] = temp[i]+temp[i+1];
            }
        }

        int sum = 0;
        for(int i=0;i<temp.length;i++){
            sum+=temp[i];
        }
        System.out.println(sum);


        Node val1 = new Node(1);
        Node val2 = new Node(2);
        Node val3 = new Node(3);
        Node val4 = new Node(4);

        Node val5 = new Node(5);
        Node val6 = new Node(6);
        Node val7 = new Node(7);


        //list1
        val1.next = val2;
        val2.next = val3;
        val3.next = val4;

        //list2
        val5.next = val6;
       // val6.next = val2;
       // val7.next = val2;

        boolean resultIntersection = hasIntersection(val1,val5);
        System.out.println(resultIntersection);
    }
    //1->2->3->4
    //5->6->7-null   2->3->4
    public static boolean hasIntersection(Node head1,Node head2){
        int l1 = 0,l2=0;
        Node temp1 = head1;
        Node temp2 = head2;

        if(head1.next == null || head2.next == null) return false;

        while(temp1.next != null){
            l1++;
            temp1 = temp1.next;
        }

        while(temp2.next != null){
            l2++;
            temp2 = temp2.next;
        }


        int limit = l1<l2?l1:l2;

        int it = 0;
        Node list1 = head1;
        Node list2 = head2;
        while(it<=limit){
            while(list1.next != null && list2.next != null){
                if(list1==list2) return true;
                list1 = list1.next;
                list2 = list2.next.next;
                if(list1 == null || list2 == null) return false;
            }
            list1 = head1.next;
            list2 = head2.next;
            head1 = head1.next;
            head2 = head2.next;
            it++;
        }
        return false;
    }
}