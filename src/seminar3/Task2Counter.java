package seminar3;

import java.io.IOException;

public class Task2Counter implements AutoCloseable{
    private Integer counter = 0;


    public Integer add() throws IOException{
        checkClose();
        return ++counter;
    }

    public void checkClose() throws IOException{
        if(counter == null){
            throw new IOException();
        }
    }

    @Override
    public void close() {
        System.out.println("Метод close");
        counter = null;
    }
}
