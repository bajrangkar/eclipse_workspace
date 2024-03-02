package interview.drills;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortByAge {
    public static void main(String[] args) {
        List<Employee> employee1 = new ArrayList<>();
        List<Employee> employee2 = new ArrayList<>();

        Employee employee01 = new Employee("Sagar",26);
        Employee employee02 = new Employee("Umesh",26);
        Employee employee03 = new Employee("Mahendar",28);
        Employee employee04 = new Employee("Giri",40);
        Employee employee05 = new Employee("Bala",44);
        Employee employee06 = new Employee("Jeetu",48);
        Employee employee07 = new Employee("Sampath",24);
        employee1.add(employee01);
        employee1.add(employee02);
        employee1.add(employee03);
        employee1.add(employee04);
        employee1.add(employee05);
        employee1.add(employee06);
        employee1.add(employee07);

        Employee employee08 = new Employee("Sirisha",34);
        Employee employee09 = new Employee("Tripula",30);
        Employee employee10 = new Employee("Suhasini",24);
        Employee employee11 = new Employee("LaxmiNarayan",40);
        Employee employee12 = new Employee("Chaitanya",44);
        Employee employee13 = new Employee("Anjali",48);
        employee2.add(employee08);
        employee2.add(employee09);
        employee2.add(employee10);
        employee2.add(employee11);
        employee2.add(employee12);
        employee2.add(employee13);

        // System.out.println(employee1);
        // System.out.println(employee2);

        List<Employee> employee3 = Stream.concat(employee1.stream(),employee2.stream()).collect(Collectors.toList());
        // System.out.println(employee3);

        /**
         *  Problem 1
         *  i> Sort on the age
         */

        /**
         *  Approach 1
         *  many different syntax
         */
//        Collections.sort(employee3, (e1, e2) -> e1.age < e2.age ? -1 : e1.age > e2.age ? 1 : 0);
//        Collections.sort(employee3, (e1, e2) -> Integer.compare(e1.age, e2.age));
//        Collections.sort(employee3, Comparator.comparingInt(e -> e.age));
//        Collections.sort(employee3, Comparator.comparing(e -> e.age));
//        System.out.println(employee3);

        /**
         *  Approach 2
         *  Stream.sorted() method
         */
        //employee3.stream().sorted(Comparator.comparing(e -> e.age)).forEach(e -> System.out.print(e+", "));
        /*
        List<Employee> employee4 = Stream.concat(employee1.stream(),employee2.stream())
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
        System.out.println("In 1 Line :: " + employee4);
         */





        /**
         *  Problem 2
         *  i> Sort on the age
         *  ii> Sort on the name (age should be in order)
         */
        /**
         *  Approach 1
         *  First, sort on the name
         *  Then, sort on the age
         *  Bad approach as two iterations are there
         */
        /*
        List<Employee> employee4 = employee3.stream().collect(Collectors.toList()); // Java 8
//        List<Employee> employee4 = List.copyOf(employee3); // Java 10 - immutable list, so sort operation wont support
        Collections.sort(employee4, (e1, e2) -> e1.name.compareTo(e2.name) < 0 ? -1 : e1.name.compareTo(e2.name) > 0 ? 1 : 0);
        System.out.println("Approach 1 : sorted on name : " + employee4);
        Collections.sort(employee4, (e1, e2) -> e1.age < e2.age ? -1 : e1.age > e2.age ? 1 : 0);
        System.out.println("Approach 1 : sorted on age after sorting on name : " + employee4);
        */

        /**
         *  Approach 2
         *  Create 2 comparators
         *  And, join them using Comparator.thenComparing method
         *  The thenComparing method evaluates on the caller Comparator, in case of equal(0) condition
         *  - it uses the passing parameter Comparator to resolve the order of equal elements
         *  - means sorting elements of same rank of Comparator 1st with Comparator 2nd
         */
        /*
        Comparator<Employee> compareByName = Comparator.comparing(Employee::getName);
        Comparator<Employee> compareByAge = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> compareByAgeThenName = compareByAge.thenComparing(compareByName);
        Collections.sort(employee3, compareByAgeThenName);
        System.out.println("Approach 2 : " + employee3);
        */

        /**
         *  Trying everything in one line
         */
        /*
        Stream.concat(employee1.stream(),employee2.stream())
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
                .forEach(e-> System.out.print(e+", "));
        */
        List<Employee> employee4 = Stream.concat(employee1.stream(),employee2.stream())
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("In 1 Line :: " + employee4);
    }
}
