package pushSystem.dao;

/**
 * Label entity. @author MyEclipse Persistence Tools
 */

public class Label implements java.io.Serializable {

	// Fields

	private String labelName;
	private Integer value;

	// Constructors

	/** default constructor */
	public Label() {
	}

	/** full constructor */
	public Label(String labelName, Integer value) {
		this.labelName = labelName;
		this.value = value;
	}

	// Property accessors

	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}