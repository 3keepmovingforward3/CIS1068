package Test_Papers_Assignment;

import java.io.File;
import java.io.BufferedWriter;
import java.io.IOError;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;


public class Test {
    private int totalQuestions;
    private int questionsNet=0;
    private int totalPoints;
    Question[] question;
    private String blank = "_______________ ";
    String fileName = "";


    public Test() {}

    public Test(int questions, int totalPoints, String fileName) {
        this.totalQuestions = questions;
        this.totalPoints = totalPoints;
        this.question = new Question[totalQuestions];
        this.setFileName(fileName);
        this.setQuestionsNet(0);
    }

    void addQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer){
        this.question[getQuestionsNet()]=new Question(points,difficulty,answerSpace,questionText,correctAnswer);
        setQuestionsNet(questionsNet+1);
    }

    void addQuestion(int points, int difficulty, int answerSpace, String questionText, String questionSpace, String correctAnswer){
        this.question[getQuestionsNet()]=new Question(points,difficulty,answerSpace,questionText,questionSpace,correctAnswer);
        setQuestionsNet(questionsNet+1);
    }

    void addQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer, String[] possibleAnswers){
        this.question[getQuestionsNet()]=new Question(points,difficulty,answerSpace,questionText,correctAnswer,possibleAnswers);
        setQuestionsNet(questionsNet+1);
    }

    public int getQuestionsNet() { return questionsNet; }

    public void setQuestionsNet(int questionsNet) { this.questionsNet = questionsNet;}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    void printTest(){
        for(int i = 0; i<getQuestionsNet();i++){
            if(this.question[i].getQuestionType()== Question.questionTypes.OBJECTIVE){
                System.out.print("Question "+(i+1)+"\n"+this.question[i].getQuestionText()+" ____________________\n");
                System.out.print("*"+this.question[i].getCorrectAnswer()+"\n\n");
            }
            else if(this.question[i].getQuestionType()== Question.questionTypes.FILLINTHEBLANK){
                System.out.print("Question "+(i+1)+"\n"+blank+this.question[i].getQuestionText()+"\n");
                System.out.print("*"+this.question[i].getCorrectAnswer()+"\n\n");
            }
            else if(this.question[i].getQuestionType()== Question.questionTypes.MULTIPLECHOICE){
                System.out.print("Question "+(i+1)+"\n"+this.question[i].getQuestionText()+"\n");
                for(int j = 0;j<this.question[i].getPossibleAnswers().length;j++){
                    System.out.print((j+1)+". "+this.question[i].getPossibleAnswers()[j]+"\n");
                }
                System.out.print("*"+this.question[i].getCorrectAnswer()+"\n\n");
            }
        }
    }

    void toFile() {
        Path path = Paths.get("./"+fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int i = 0; i < getQuestionsNet(); i++) {
                if (this.question[i].getQuestionType() == Question.questionTypes.OBJECTIVE) {
                    writer.write("Question "+(i+1)+".\n"+this.question[i].getQuestionText()+" ____________________\n");
                    writer.write("*"+this.question[i].getCorrectAnswer()+"\n\n");
                } else if (this.question[i].getQuestionType() == Question.questionTypes.FILLINTHEBLANK) {
                    writer.write("Question "+(i+1)+".\n"+blank+this.question[i].getQuestionText()+"\n");
                    writer.write("*"+this.question[i].getCorrectAnswer()+"\n\n");
                } else if (this.question[i].getQuestionType() == Question.questionTypes.MULTIPLECHOICE) {
                    writer.write("Question "+(i+1)+".\n"+this.question[i].getQuestionText()+"\n");
                    for(int j = 0;j<this.question[i].getPossibleAnswers().length;j++){
                        writer.write((j+1)+". "+this.question[i].getPossibleAnswers()[j]+"\n");
                    }
                    writer.write("*"+this.question[i].getCorrectAnswer()+"\n\n");
                }
                }
            } catch(IOException e){ e.printStackTrace();}
        }
    }

