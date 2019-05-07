package Test_Papers_Assignment;

public class Driver {
    public static void main(String[] args) {
        String[] possibleAnswers = {"A","B","C","2"};
        Test test = new Test(3,300,"test.txt");
        test.addQuestion(100,1,1,"What is two plus three?","Five");
        test.addQuestion(100,1,1,"was the 16th US President.","_____________","Abraham Lincoln");
        test.addQuestion(100,1,1,"What is not an alphabet?","2",possibleAnswers);
        test.printTest();
        test.toFile();
    }
}


