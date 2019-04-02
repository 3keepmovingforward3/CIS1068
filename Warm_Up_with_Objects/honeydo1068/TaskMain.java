package honeydo1068;
import java.time.*;

public class TaskMain {
    public static void main(String[] args){
        Task postHW = new Task("post 1068 homework", 3, LocalDateTime.of(2019, 3, 28, 13, 0), 180);
        postHW.decreasePriority(2);
        System.out.printf("%s\n",postHW.toString());
        postHW.decreasePriority(2);
        System.out.printf("%s\n",postHW.toString());
        postHW.increasePriority(-1);
        System.out.printf("%s\n",postHW.toString());
        postHW.increasePriority(1);
        System.out.printf("%s\n",postHW.toString());
        }

}
