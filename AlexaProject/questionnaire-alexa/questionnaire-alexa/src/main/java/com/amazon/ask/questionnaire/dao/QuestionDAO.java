package com.amazon.ask.questionnaire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class QuestionDAO {
	
	public Map<String ,Object> getQuestionByQuestionTypeIdAndSkillId(String questionType, int questionTypeId,int skillId) {

		Map<String, Object> questionMap = new HashMap<>();
		
		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();

			ResultSet questionRS = st.executeQuery("select * from `question_table` where question_type_id = "+questionTypeId+" AND skill_id = "+skillId+" ORDER BY RAND() LIMIT 1");

			if(questionType.equals("MCQ")) {
				
				System.out.println("saving the question in map");
				while (questionRS.next()) {
					
					int questionId=questionRS.getInt("question_id");
					questionMap.put("questionId", questionId);

					String question = questionRS.getString("question");
					System.out.println("Question : "+question);
					questionMap.put("question", question);
					
					String questionDescription = questionRS.getString("question_description");
					questionMap.put("questionDescription", questionDescription);
					
					String option1 = questionRS.getString("optionValue1");
					questionMap.put("option1", option1);
					
					String option2 = questionRS.getString("optionValue2");
					questionMap.put("option2", option2);
					
					String option3 = questionRS.getString("optionValue3");
					questionMap.put("option3", option3);
					
					String option4 = questionRS.getString("optionValue4");
					questionMap.put("option4", option4);
					
				}
				
			} else if(questionType.equals("1 word")) {
				
				while (questionRS.next()) {

					String question = questionRS.getString("question");
					questionMap.put("question", question);
					
					String questionDescription = questionRS.getString("question_description");
					questionMap.put("questionDescription", questionDescription);
					
				}
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return questionMap;
	}
}
