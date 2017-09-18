package training.roadmap.survey.dto;

public class Answer {

	/**
	 * Question Id.
	 */
	private String questionId;

	/**
	 * Choice Identifier.
	 */
	private String choiceValue;

	/**
	 * User Identifier.
	 */
	private String emailId;

	/**
     * No argument Constructor needed for JAXB.
     */
	public Answer() {
        // Nothing to do here.
    }

	/**
	 * Constructor
	 * @param questionId
	 * @param choiceValue
	 * @param emailId
	 */
	public Answer(String questionId, String choiceValue, String emailId) {
		super();
		this.questionId = questionId;
		this.choiceValue = choiceValue;
		this.emailId = emailId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getChoiceValue() {
		return choiceValue;
	}

	public String getEmailId() {
		return emailId;
	}
}
