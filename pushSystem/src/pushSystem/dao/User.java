package pushSystem.dao;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private Integer userValuation;
	private double feedbackValuation;
	private double feedback;
	private Integer pushTime;
	private Integer power;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String password, Integer userValuation) {
		this.userName = userName;
		this.password = password;
		this.userValuation = userValuation;
	}

	/** full constructor */
	public User(String userName, String password, Integer userValuation,
			Double feedbackValuation, Double feedback, Integer pushTime,
			Integer power) {
		this.userName = userName;
		this.password = password;
		this.userValuation = userValuation;
		this.feedbackValuation = feedbackValuation;
		this.feedback = feedback;
		this.pushTime = pushTime;
		this.power = power;
	}



	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserValuation() {
		return this.userValuation;
	}

	public void setUserValuation(Integer fbv) {
		this.userValuation = fbv;
	}

	public Double getFeedbackValuation() {
		return this.feedbackValuation;
	}

	public void setFeedbackValuation(Double feedbackValuation) {
		this.feedbackValuation = feedbackValuation;
	}

	public Double getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Double feedback) {
		this.feedback = feedback;
	}

	public Integer getPushTime() {
		return this.pushTime;
	}

	public void setPushTime(Integer pushTime) {
		this.pushTime = pushTime;
	}

	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

}