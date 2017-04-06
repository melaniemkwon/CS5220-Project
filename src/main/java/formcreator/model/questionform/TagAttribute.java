package formcreator.model.questionform;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TagAttribute {
	protected boolean required;

	protected String type;

	@Column(name = "input_type")
	protected String inputType;

	protected String size;

	protected String placeholder;

	protected String rows;

	protected String min;

	protected String max;

	protected String step;

	public TagAttribute() {

		required = false;
		type = "text";
		inputType = "text";
		size = "col-lg-6";
		placeholder = "";
		rows = "3";
		min = "0";
		max = "100";
		step = "1";
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

}
