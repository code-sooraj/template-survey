package training.roadmap.survey.dto;

import java.util.List;

public class Question {

	/**
	 * Primary Key.
	 */
	private String id;

	/**
	 * Order of the question in the survey.
	 */
	private int index;

	/**
	 * Parent Id.
	 */
	private String surveyId;

	/**
	 * Question text.
	 */
	private String description;

	/**
	 * List of choices.
	 */
	private List<Choice> choices;

    /**
     * No argument Constructor needed for JAXB.
     */
	public Question() {
        // Nothing to do here.
    }

	/**
	 * Constructor.
	 * @param id
	 * @param index
	 * @param surveyId
	 * @param description
	 * @param choices
	 */
	public Question(String id, int index, String surveyId, String description, List<Choice> choices) {
		super();
		this.id = id;
		this.index = index;
		this.surveyId = surveyId;
		this.description = description;
		this.choices = choices;
	}

	public String getId() {
		return id;
	}

	public int getIndex() {
		return index;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public String getDescription() {
		return description;
	}

	public List<Choice> getChoices() {
		return choices;
	}
}
