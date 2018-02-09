package Cillections;


import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * 
 * @author pushpankar
 *date:09/01/2018
 */
public class QuestionContainer {
	 private List list = new ArrayList<Question>();
	    private int ccount;
	    private int wcount;
	    /**
	     * 
	     * @return the Question's list
	     */
	    /**
	     * Setting questions
	     * @return
	     */
	    public List<Question> listOfQuestions() {
	        String q = "Java is a ........... language.";
	        String o1 = "weakly typed";
	        String o2 = "strogly typed";
	        String o3 = "moderate typed";
	        String o4 = "None of these";
	        Question q1 = new Question(q, o1, o2, o3, o4, o2);
	        q = "How many primitive data types are there in Java?";
	        o1 = "6";
	        o2 = "7";
	        o3 = "8";
	        o4 = "9";
	        Question q2 = new Question(q, o1, o2, o3, o4, o3);
	        q = "In Java byte, short, int and long all of these are";
	        o1 = "signed";
	        o2 = "unsigned";
	        o3 = "Both";
	        o4 = "None";
	        Question q3 = new Question(q, o1, o2, o3, o4, o1);
	        q = "Size of int in Java is";
	        o1 = "16bit";
	        o2 = "32bit";
	        o3 = "64bit";
	        o4 = "Depands on environment";
	        Question q4 = new Question(q, o1, o2, o3, o4, o2);
	        q = "Size of float and double in Java is";
	        o1 = "32 and 64";
	        o2 = "64 and 64";
	        o3 = "32 and 32";
	        o4 = "None of above";
	        Question q5 = new Question(q, o1, o2, o3, o4, o1);
	        list.add(q1);
	        list.add(q2);
	        list.add(q3);
	        list.add(q4);
	        list.add(q5);
	        return list;
	    }
	    /**
	     * Begin test
	     * count result
	     * @return the result of the test
	     */
	    public int beginTest() {
	        int ch = 0;
	        for (Question question : listOfQuestions()) {
	            boolean flag = true;
	            char ch1=0;
	            while (flag) {
	                System.out.println("Question : " + question.getQuestion());
	                System.out.println("A) " + question.getOption1());
	                System.out.println("B) " + question.getOption2());
	                System.out.println("C) " + question.getOption3());
	                System.out.println("D) " + question.getOption4());
	                System.out.println("Enter Your Option");
	                Scanner sc = new Scanner(System.in);
	               
	            		
	            		
	            			
	            			 boolean b=false;
	            			 /**
	            			  * For Options A/B/C/D only
	            			  */
	            			 while(!b){
	            				 System.out.println("Enter Ur options as A/B/C/D");
	            				 
	            				 ch1= sc.next().charAt(0);
	            				 
	            				 if(ch1==('A')||ch1==('B')||ch1==('C')||ch1==('D')){
	            					 b=true;
	            					 flag=true;
	            					 break;
	            				 }
	            				 else{
	            					 System.err.println("Enter valid option");
	            					 b=false;
	            				 }
	            			 }
	               
	                switch (ch1) {
	                    case 'A':
	                        if(question.getOption1().equals(question.getAnswer()))
	                            ccount++;
	                        else
	                            wcount++;
	                    flag = false;
	                    break;
	                    case 'B':
	                        if (question.getOption2().equals(question.getAnswer()))
	                            ccount++;
	                        else
	                            wcount++;
	                    flag = false;
	                    break;
	                    case 'C':
	                        if(question.getOption3().equals(question.getAnswer()))
	                            ccount++;
	                        else
	                            wcount++;
	                    flag = false;
	                    break;
	                    case 'D':
	                        if(question.getOption4().equals(question.getAnswer()))
	                            ccount++;
	                        else
	                            wcount++;
	                    flag = false;
	                    break;
	                    default:
	                        System.out.println("Enter only A or B or C or D");
	                        flag = true;
	                        break;
	                } 
	            }
	        
	       
	    
	        } return ccount;
	    }


	    /**
	     * Shows result
	     */
	    public void showResult(){
	        System.out.println("Test Result");
	        System.out.println("Total questions : 5");
	        System.out.println("Correct questions: "+ccount);
	        System.out.println("Wrong questions: "+wcount);
	        System.out.println("Result : "+((ccount>(5*.4))?"Pass":"Fail"));
	    }
}