package com.amazon.ask.questionnaire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

	public List<String> getSkills() {

		List<String> skillList = new ArrayList<String>();

		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();

			ResultSet skillRS = st.executeQuery("select * from `skill_table`");

			while (skillRS.next()) {

				String skill = skillRS.getString("skill_name");

				skillList.add(skill);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return skillList;
	}

	public int getSkillIdBySkillName(String skillName) {
		int skillId=0;
		try {

			Connection con = DataBaseConnection.getInstance().getConnection();

			Statement st = con.createStatement();
			
			ResultSet skillRS = st.executeQuery("select * from `skill_table` where skill_name = '"+skillName+"'");
			
			
			while (skillRS.next()) {

				skillId = skillRS.getInt("skill_id");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return skillId;

	}

}
