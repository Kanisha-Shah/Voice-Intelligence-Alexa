package com.amazon.ask.questionnaire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionTypeDAO {
	
	public List<String> getQuestionTypesBySkillId(int skillId) {

		List<String> questionTypeList = new ArrayList<String>();

		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();

			ResultSet skillRS = st.executeQuery("select * from `question_type_table` where skill_id = "+skillId);

			while (skillRS.next()) {

				String questionTypes = skillRS.getString("question_type_name");

				questionTypeList.add(questionTypes);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return questionTypeList;
	}
	
	public int getquestionTypeIdByName(String questionTypeName,int skillId) {
		int questionTypeId=0;
		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();
			
			ResultSet questionTypeRS= st.executeQuery("select * from `question_type_table` where question_type_name = '"+questionTypeName+"' AND skill_id = "+skillId);
			
			while (questionTypeRS.next()) {

				questionTypeId = questionTypeRS.getInt("question_type_id");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return questionTypeId;

	}

}
