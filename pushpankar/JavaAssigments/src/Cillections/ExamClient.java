package Cillections;

import java.util.Scanner;
/**
 * 
 * @author Pushpankar 09/01/2018
 *
 */

public class ExamClient {
	
	public static void main(String [] args){
		QuestionContainer  container=new QuestionContainer();
		container.beginTest();
		container.showResult();
	}

}
