package training.roadmap.survey.dto;

public class Choice {

	/**
	 * Primary Key.
	 */
	private String id;

	/**
	 * Order of the choice in the question.
	 */
	private int index;

	/**
	 * Parent Id.
	 */
	private String questionId;

	/**
	 * Display text.
	 */
	private String text;

	/**
     * No argument Constructor needed for JAXB.
     */
	public Choice() {
        // Nothing to do here.
    }

	/**
	 * Constructor.
	 * @param id
	 * @param index
	 * @param questionId
	 * @param text
	 */
    public Choice(String id, int index, String questionId, String text) {
        super();
		this.id = id;
		this.index = index;
		this.questionId = questionId;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public int getIndex() {
		return index;
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getText() {
		return text;
	}
}
