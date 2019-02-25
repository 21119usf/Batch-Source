package com.revature.input;

import com.reavature.validate.CanValidate;
import com.reavature.validate.ValidatorException;

public interface CanTakeInput extends CanValidate {
	int getInput();
	void validate() throws ValidatorException;
	void onInvalidInput(Exception e);
}
