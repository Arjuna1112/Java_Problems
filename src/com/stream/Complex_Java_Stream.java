package com.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Complex_Java_Stream {
    static List<Employee> employeeList = new ArrayList<>();
    public static void main(String args[]){

        employeeList.add(new Employee(1,"Arjun",29,"Male","Software",2012,70000.00, Arrays.asList("8956341478","8956341476")));
        employeeList.add(new Employee(2,"Arun",27,"Female","Hardware",2010,20000.00, Arrays.asList("8956341471","8956341472")));
        employeeList.add(new Employee(3,"Ravi",28,"Male","Politics",2014,36000.00, Arrays.asList("8956341473","8956341474")));
        employeeList.add(new Employee(4,"Sachin",30,"Female","Hospital",2012,28000.00, Arrays.asList("8956341475","8956341476")));
        employeeList.add(new Employee(5,"Rahul",29,"Male","Software",2016,10000.00, Arrays.asList("8956341478","8956341476")));
        employeeList.add(new Employee(6,"Ramesh",25,"Female","Software",2015,12000.00, Arrays.asList("8956341478","8956341476")));
        employeeList.add(new Employee(7,"Shiva",31,"Male","Politics",2014,71000.00, Arrays.asList("8956341478","8956341476")));

        //Query 1 : How many male and female employees are in Organization
        method1();

        //Query 2 : Print all the department name in the organization
        method2();

        //Query 3 : Average age of male and female in organization
        method3();

        //Query 4 : Get the details of highest paid employee in the organization
        method4();

        //Query 5 : Get the names of all employee who have joined after 2015
        method5();

        //Query 6 : Count number of employees in each department
        method6();

        //Query 7 : What is the average salary for each department
        method7();

        //Query 8 : Get the details of youngest male employee in software department
        method8();

        //Query 9 : Most working experience in the organization
        method9();

        //Query 10 : How many male and female employees are there in software and hardware department
        method10();

        //Query 11 : What is the average salary of male and female employees
        method11();

        //Query 12 : List down name of all employees in each department
        method12();

        //Query 13 : Average and Total salary of organization
        method13();

        //Query 14 : Separate employees age less than 25 with older than 25
        method14();

        //Query 15 : Oldest Employee name, Age & Department
        method15();

        //Query 16 : To fetch name of all employees in organization
        method16();

        //Query 17 : To fetch contact numbers all employees in organization
        method17();

        //Query 18 : Merge to list, l1 + l2
        method18();

        //Query 19 : Sort list using stream
        method19();

        //Query 20 : Combine elements of 2 list (sum/diff/product if it's integer) or just concat if its string/character
        method20();

        //Query 21 : Find Maximum Index Product
        solve(Arrays.asList(5,4,3,4,5));
    }

    private static void method1(){
        System.out.println("Query 1 : How many male and female employees are in Organization");
        Map<String,Long> genderMap = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderMap);
    }

    private static void method2(){
        System.out.println("Query 2 : Print all the department name in the organization");
        employeeList.stream().map(Employee::getDepartName).distinct().forEach(System.out::println);
    }

    private static void method3(){
        System.out.println("Query 3 : Average age of male and female in organization");
        Map<String,Double> averageMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageMap);
    }

    private static void method4(){
        System.out.println("Query 4 : Get the details of highest paid employee in the organization");
        System.out.println(employeeList.stream().max(Comparator.comparing(Employee::getSalary)));
    }

    private static void method5(){
        System.out.println("Query 5 : Get the names of all employee who have joined after 2015");
        employeeList.stream().filter(employee -> employee.yearOfJoining>2015).forEach(e->System.out.println(e.name));
    }

    private static void method6(){
        System.out.println("Query 6 : Count number of employees in each department");
        Map<String,Long> countMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartName,Collectors.counting()));
        System.out.println(countMap);
    }

    private static void method7(){
        System.out.println("Query 7 : What is the average salary for each department");
        Map<String,Double> countMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartName,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(countMap);
    }

    private static void method8(){
        System.out.println("Query 8 : Get the details of youngest male employee in software department");
        System.out.println(employeeList.stream().filter(employee ->
                employee.departName.equals("Software") && employee.gender.equals("Male")).min(Comparator.comparing(Employee::getAge)));
    }

    private static void method9(){
        System.out.println("Query 9 : Most working experience in the organization");
        System.out.println(employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining)));
        System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst());
    }

    private static void method10(){
        System.out.println("Query 10 : How many male and female employees are there in software and hardware department");
        Map<String, Long> genderMapOnDept = employeeList.stream().filter(employee -> employee.getDepartName().equals("Software") || employee.getDepartName().equals("Hardware"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(genderMapOnDept);
    }

    private static void method11(){
        System.out.println("Query 11 : What is the average salary of male and female employees");
        Map<String, Double> avgSalaryByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByGender);
    }

    private static void method12(){
        System.out.println("Query 12 : List down name of all employees in each department");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartName)).forEach((s, employees) -> {
            System.out.println(s);
            employees.stream().map(Employee::getName).forEach(System.out::print);
            System.out.println();
        });
    }

    private static void method13(){
        System.out.println("Query 12 : Average and Total salary of organization");
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics.getSum()+" "+doubleSummaryStatistics.getAverage());
    }

    private static void method14(){
        System.out.println("Query 14 : Separate employees age less than 25 with older than 25");
        Map<Boolean,List<Employee>> partitionMap = employeeList.stream().collect(Collectors.partitioningBy(e->e.age>25));
        System.out.println(partitionMap);
    }

    private static void method15(){
        System.out.println("Query 15 : Oldest Employee name, Age & Department");
        employeeList.stream().max(Comparator.comparing(Employee::getAge)).
                stream().forEach(employee -> System.out.println(employee.name+employee.age+employee.departName));
    }

    private static void method16(){
        System.out.println("Query 16 : To fetch name of all employees in organization");
        employeeList.stream().map(Employee::getName).forEach(System.out::print);
    }

    private static void method17(){
        System.out.println("Query 17 : To fetch contact numbers of all employees in organization");
        employeeList.stream().flatMap(employee -> employee.contactNumbers.stream()).forEach(System.out::print);
    }

    private static void method18(){
        System.out.println("Query 18 : Merge to list, l1 + l2");
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        int d = 4;
        Map<Boolean,List<Integer>> splitList = integerList.stream().collect(Collectors.partitioningBy(integer -> integerList.indexOf(integer)<=d-1));
        List<Integer> l1 = splitList.get(true);
        List<Integer> l2 = splitList.get(false);
        System.out.println(Stream.concat(l2.stream(),l1.stream()).collect(Collectors.toList()));
        System.out.println(Stream.of(l1,l2).flatMap(integers -> integers.stream()).collect(Collectors.toList()));
        List<Integer> l = new ArrayList<>();
        Stream.of(l1,l2).forEach(l::addAll);
        System.out.println(l);
        //Simple java 7 and older approach
        l1.addAll(l2);
        System.out.println(l1);
    }

    private static void method19(){
        System.out.println("Query 19 : Sort list using stream");
        List<Integer> integers = Arrays.asList(2,1,5,4,6,3);
        Collections.sort(integers);
        System.out.println(integers);
        Collections.reverse(integers);
        System.out.println(integers);
        integers.stream().sorted().forEach(System.out::print);
        System.out.println("-----------");
        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println("-----------");
        Collections.sort(employeeList,(o1, o2) -> o1.age- o2.age);
        System.out.println(employeeList);
        Collections.sort(employeeList,((o1, o2) -> o2.age- o1.age));
        System.out.println(employeeList);
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::print);
        System.out.println("----------------");
        employeeList.stream().sorted((o1, o2) -> o1.yearOfJoining- o2.yearOfJoining).forEach(System.out::print);
    }

    private static void method20(){
        System.out.println("Query 20: Combine elements of 2 list (sum/diff/product if it's integer) or just concat if its string/character");
        List<Integer> integers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> integers2 = Arrays.asList(5,4,3,2,1);
        List<Integer> outputIntegers = IntStream.range(0,integers1.size()).mapToObj(i->integers1.get(i)*integers2.get(i)).collect(Collectors.toList());
        System.out.println(outputIntegers);
        int max = IntStream.range(0,integers1.size()).mapToObj(i->integers1.get(i)*integers2.get(i)).max(Integer::compareTo).get();

        List<Integer> l1 = new ArrayList<>(integers1.size());
        l1.add(0,0);

    }

    public static int solve(List<Integer> arr) {
        // Write your code here
        Stack<Integer> s1 = new Stack<Integer>();
        int[] leftList = new int[arr.size()];
        int[] rightList = new int[arr.size()];
        s1.push(0);
        leftList[0]=0;
        for(int i=1;i<arr.size();i++){
            while(!s1.isEmpty() && arr.get(s1.peek())<=arr.get(i)) s1.pop();
            leftList[i] = s1.isEmpty()?0:s1.peek()+1;
            s1.push(i);
        }
        s1 = new Stack<Integer>();
        s1.push(arr.size()-1);
        rightList[arr.size()-1]=0;
        for(int i=arr.size()-2;i>0;i--){
            while(!s1.isEmpty() && arr.get(s1.peek())<=arr.get(i)) s1.pop();
            rightList[i] = s1.isEmpty()?0:s1.peek()+1;
            s1.push(i);
        }
        System.out.println(leftList[2]+"&&"+rightList[2]);
        System.out.println(IntStream.range(0,arr.size())
                .mapToObj(i->leftList[i]*rightList[i]).max(Integer::compareTo).get());
        return 0;
    }


    static class Employee{
        int id;
        String name;
        int age;
        String gender;
        String departName;
        int yearOfJoining;
        double salary;
        List<String> contactNumbers;

        public Employee(int id, String name, int age, String gender, String departName, int yearOfJoining, double salary, List<String> contactNumbers) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.departName = departName;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
            this.contactNumbers = contactNumbers;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", departName='" + departName + '\'' +
                    ", yearOfJoining=" + yearOfJoining +
                    ", salary=" + salary +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartName() {
            return departName;
        }

        public int getYearOfJoining() {
            return yearOfJoining;
        }

        public double getSalary() {
            return salary;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setDepartName(String departName) {
            this.departName = departName;
        }

        public void setYearOfJoining(int yearOfJoining) {
            this.yearOfJoining = yearOfJoining;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public List<String> getContactNumbers() {
            return contactNumbers;
        }

        public void setContactNumbers(List<String> contactNumbers) {
            this.contactNumbers = contactNumbers;
        }
    }
}


