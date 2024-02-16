package seminar3;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try (Task2Counter counter = new Task2Counter()){
            System.out.println(counter.add());
            counter.add();
            counter.add();
            counter.add();
            System.out.println(counter.add());
            System.out.println(counter.add());
            System.out.println(counter.add());
            counter.close();
            System.out.println(counter.add());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
