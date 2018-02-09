package Cillections;
/**
 * 
 * @author spaneos
 *
 */
public class Question {
	 private String question;
	    private String option1;
	    private String option2;
	    private String option3;
	    private String option4;
	    private String answer;
	   
	    /**
		 * @param question
		 * @param option1
		 * @param option2
		 * @param option3
		 * @param option4
		 * @param answer
		 */
		public Question(String question, String option1, String option2, String option3, String option4,
				String answer) {
			super();
			this.question = question;
			this.option1 = option1;
			this.option2 = option2;
			this.option3 = option3;
			this.option4 = option4;
			this.answer = answer;
		}
		/**
	     * 
	     * @return The Question
	     */
	    public String getQuestion() {
	        return question;
	    }
	    /**
	     * 
	     * @return The Option 1
	     */
	    public String getOption1() {
	        return option1;
	    }
	    /**
	     * 
	     * @return The Option 2
	     */
	    public String getOption2() {
	        return option2;
	    }
	    /**
	     * 
	     * @return The Option 3
	     */
	    public String getOption3() {
	        return option3;
	    }
	    /**
	     * 
	     * @return The Option 4
	     */
	    public String getOption4() {
	        return option4;
	    }
	    /**
	     * 
	     * @return The answer
	     */
	    public String getAnswer() {
	        return answer;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Question question1 = (Question) o;

	        if (!question.equals(question1.question)) 
	        	{return false;}
	        if (!option1.equals(question1.option1))
	        {return false;}
	        if (!option2.equals(question1.option2))
	        {return false;}
	        if (!option3.equals(question1.option3)) 
	        	{return false;}
	        if (!option4.equals(question1.option4)) 
	        	{return false;}
	        return answer.equals(question1.answer);//returns correct answer

	    }

	    @Override
	    public int hashCode() {
	        int result = question.hashCode();
	        result = 31 * result + option1.hashCode();
	        result = 31 * result + option2.hashCode();
	        result = 31 * result + option3.hashCode();
	        result = 31 * result + option4.hashCode();
	        result = 31 * result + answer.hashCode();
	        return result;
	    }
}

