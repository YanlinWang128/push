package pushSystem.dao;

/**
 * Data entity. @author MyEclipse Persistence Tools
 */

public class Data implements java.io.Serializable {

	// Fields

	private String name;
	private String type;
	private String performer;
	private String label1;
	private String label2;
	private String label3;
	private Integer dataValuation;
	private Double feedbackValua;
	private Integer accurateTime;

	// Constructors

	/** default constructor */
	public Data() {
	}

	/** minimal constructor */
	public Data(String name, String type, String performer, String label1,
			String label2, String label3) {
		this.name = name;
		this.type = type;
		this.performer = performer;
		this.label1 = label1;
		this.label2 = label2;
		this.label3 = label3;
	}

	/** full constructor */
	public Data(String name, String type, String performer, String label1,
			String label2, String label3, Integer dataValuation,
			Double feedbackValua, Integer accurateTime) {
		this.name = name;
		this.type = type;
		this.performer = performer;
		this.label1 = label1;
		this.label2 = label2;
		this.label3 = label3;
		this.dataValuation = dataValuation;
		this.feedbackValua = feedbackValua;
		this.accurateTime = accurateTime;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPerformer() {
		return this.performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getLabel1() {
		return this.label1;
	}

	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel2() {
		return this.label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public String getLabel3() {
		return this.label3;
	}

	public void setLabel3(String label3) {
		this.label3 = label3;
	}

	public Integer getDataValuation() {
		return this.dataValuation;
	}

	public void setDataValuation(Integer dataValuation) {
		this.dataValuation = dataValuation;
	}

	public Double getFeedbackValua() {
		return this.feedbackValua;
	}

	public void setFeedbackValua(Double feedbackValua) {
		this.feedbackValua = feedbackValua;
	}

	public Integer getAccurateTime() {
		return this.accurateTime;
	}

	public void setAccurateTime(Integer accurateTime) {
		this.accurateTime = accurateTime;
	}

}