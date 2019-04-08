package honeydo1068;

import java.time.LocalDateTime;

public class HoneyDoMain {
    public static void main(String[] args) {

        HoneyDoList honeydo = new HoneyDoList();
        honeydo.addTask("post 1068 homework", 3,
                LocalDateTime.of(2019, 3, 22, 13, 0), 20);
        honeydo.addTask("post 1069 homework", 2,
                LocalDateTime.of(2019, 3, 21, 13, 0), 10);
        honeydo.addTask("post 1070 homework", 2,
                LocalDateTime.of(2019, 3, 28, 13, 0), 30);
    }
}
