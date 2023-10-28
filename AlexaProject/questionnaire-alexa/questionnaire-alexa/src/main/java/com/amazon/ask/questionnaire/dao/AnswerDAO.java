package com.amazon.ask.questionnaire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AnswerDAO {

	public String getAnswer(int questionId) {

		String answer = "";

		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();

			ResultSet answerRS = st.executeQuery("select * from `question_table` where question_id = " + questionId);

			while (answerRS.next()) {

				answer = answerRS.getString("answer");
				
				System.out.println("IN DAO :: answer :: " + answer);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return answer;
	}

	public String getAnswerDescription(int questionId, int questionTypeId, int skillId) {

		String answerDescription = "";

		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();

			ResultSet answerRS = st.executeQuery("select * from `question_table` where question_id = " + questionId
					+ " AND question_type_id = " + questionTypeId + " AND skill_id = " + skillId);

			while (answerRS.next()) {

				answerDescription = answerRS.getString("answer_description");

				System.out.println("answer : " + answerDescription);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return answerDescription;
	}

}
