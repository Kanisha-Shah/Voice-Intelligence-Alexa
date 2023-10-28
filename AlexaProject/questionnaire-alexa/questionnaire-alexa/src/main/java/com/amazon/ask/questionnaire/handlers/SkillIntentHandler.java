package com.amazon.ask.questionnaire.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.questionnaire.dao.QuestionTypeDAO;
import com.amazon.ask.questionnaire.dao.SkillDAO;

public class SkillIntentHandler implements RequestHandler {

	public static final String SKILL_SLOT = "Skill";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SkillIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		SkillDAO skillDAO = new SkillDAO();
		QuestionTypeDAO questionTypeDAO = new QuestionTypeDAO();

		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		// Get the color slot from user input.
		Slot skillSlot = slots.get(SKILL_SLOT);
		String speechText="", repromptText="", questionTypes="";

		// Check for favorite color and create output to user.
		if (skillSlot != null) {

			// Store the user's favorite color in the Session and create response.
			String skill = skillSlot.getValue();
			
			System.out.println("skill :: " + skill);

			int skillId = skillDAO.getSkillIdBySkillName(skill);
			
			System.out.println("skill Id:: " + skillId);
			
			input.getAttributesManager().setSessionAttributes(Collections.singletonMap("skillId",skillId));
			
			List<String> questionTypeList = questionTypeDAO.getQuestionTypesBySkillId(skillId);
			
			System.out.println("questionTypeList :: "+questionTypeList);
			
			if (questionTypeList.isEmpty()) {
				
				speechText = "there is no question types available right now, you can try other skill !!";
				
				repromptText = "please try other skill.";
			
			} else {

				for (String questionType : questionTypeList) {

					questionTypes += ", " + questionType;

				}

				speechText = "the available question types are " + questionTypes + ".";
				repromptText = "please choose the question type from " + questionTypes;
			
			}
		}else {
			
			System.out.println("questionTypeSlot is null");
		}
		
		System.out.println("====> questionTypes String :: " + questionTypes);

		return input.getResponseBuilder().withShouldEndSession(false).withSimpleCard("StateSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).build();
	}

}

/*
 * String favoriteColor = (String)
 * input.getAttributesManager().getSessionAttributes().get(-KEY-);
 * input.getAttributesManager().setSessionAttributes(Collections.singletonMap(-
 * KEY-,-VALUE-));
 */