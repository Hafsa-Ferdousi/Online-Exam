


package com.mycompany.onlinemcqexam;

import java.util.Scanner;

 class Question{
        
    
    String QuestionText;
    String[]options;
    int correctAnswer;
    
    public Question(String QuestionText, String[] options, int correctAnswer){
        this.QuestionText=QuestionText;
        this.options=options;
        this.correctAnswer=correctAnswer;
    }
    public boolean askQuestion(){
        System.out.println(QuestionText);
        
        for(int i=0; i<options.length;i++){
            
            System.out.println((i+1)+":"+ options[i]); 
        }
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Your anwer (1-5):\t");
        int answer =sc.nextInt();
        return answer == correctAnswer;
    }
}
class Exam{
    Question[] questions;
    int score;
    public Exam(Question[] questions){
        this.questions= questions;
        this.score=0;
    }
    public void startExam(){
        for(Question q : questions){
            if(q.askQuestion()){
                System.out.println("Correct!");  
                score++;
            }else{
                System.out.println("Worng!");
            }
            System.out.println();
        }
        System.out.println("Exam Finished!");
        System.out.println("Your total score is: " + score + " out of " +questions.length);
    }
}

public class OnlineMCQExam {
   public static void main(String[]args){
       Question q1 = new Question("Class is a-",
               new String[]{"Blue print" , "Template" , "Both" , "None of them"},3);
       
       Question q2 = new Question("Array is a/an-",
               new String[]{"Object", "Method", "Both","I don't know"}, 1);
       
       Question q3 = new Question ("What are instances of a class?",
                new String[]{"Methods", "Objects", "Variables", "Array"},2);
       
        Question q4 = new Question ("What is the use of '\\t' in java?",
                new String[]{"Insert a newline", "Insert a carriage", "Insert a backspace ", "Insert a tab"},4);
        
        Question q5= new Question("In Java long _ byte?" ,
                 new String[]{"1","2","4","16"},3);
                
       Question[] questions={q1, q2, q3, q4, q5};
       Exam exam =new Exam(questions);
       exam.startExam();
   }
    
}
