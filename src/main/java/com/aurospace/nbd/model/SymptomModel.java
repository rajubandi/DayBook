package com.aurospace.nbd.model;

public class SymptomModel {

	private String symptomName;
	private int symptomResId;
	private boolean isSelected;

	public SymptomModel(String symptomName, int symptomResId) {
		this.symptomName = symptomName;
		this.symptomResId = symptomResId;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	public int getSymptomResId() {
		return symptomResId;
	}

	public void setSymptomResId(int symptomResId) {
		this.symptomResId = symptomResId;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
