package Test_Papers_Assignment;


class Question extends Test{
    private int MIN_DIFFICULTY = 0;
    private int MAX_DIFFICULTY = 100;
    private int points;
    private int difficulty;
    private int answerSpace;
    private questionTypes questionType = questionTypes.BLANK;
    private String questionText;
    private String questionSpace;
    private String correctAnswer;
    private String[] possibleAnswers;

    public enum questionTypes
    {
        BLANK,
        OBJECTIVE,
        FILLINTHEBLANK,
        MULTIPLECHOICE;
    }

    // ObjectiveQuestion
    Question(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        setQuestionType(questionTypes.OBJECTIVE);
    }

    // FillInTheBlankQuestion
    Question(int points, int difficulty, int answerSpace, String questionText, String questionSpace, String correctAnswer) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
        this.questionSpace = questionSpace;
        this.correctAnswer = correctAnswer;
        setQuestionType(questionTypes.FILLINTHEBLANK);
    }

    // MultipleChoiceQuestion
    Question(int points, int difficulty, int answerSpace, String questionText, String correctAnswer, String[] possibleAnswers) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
        setQuestionType(questionTypes.MULTIPLECHOICE);
    }

    public questionTypes getQuestionType() {
        return questionType;
    }

    public void setQuestionType(questionTypes questionType) {
        this.questionType = questionType;
    }

    public String getQuestionText() { return questionText; }

    public String getCorrectAnswer() { return correctAnswer; }

    public int getPoints() { return points; }

    public int getDifficulty() { return difficulty; }

    public String[] getPossibleAnswers() { return possibleAnswers; }


}
