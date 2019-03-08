package com.revature.dao;

public interface FormDao {

	void submitForm(
			String fullName,
			String startDate,
			String startTime,
			String endTime,
			String location,
			String description,
			Double cost,
			String gradingFormat,
			String eventType,
			String supervisor,
			String benCo);
	
	void updateForm(
			String fullName,
			String startDate,
			String startTime,
			String endTime,
			String location,
			String description,
			Double cost,
			String gradingFormat,
			String eventType,
			String supervisor,
			String benCo);
}
