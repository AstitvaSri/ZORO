package com.astitva.rest.entity;

public class SuccessJSON {
	private boolean Success;

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public SuccessJSON(boolean success) {
		super();
		Success = success;
	}
	public SuccessJSON() {
		//default constructor
	}

	@Override
	public String toString() {
		return "SuccessJSON [Success=" + Success + "]";
	}
	
	

}
