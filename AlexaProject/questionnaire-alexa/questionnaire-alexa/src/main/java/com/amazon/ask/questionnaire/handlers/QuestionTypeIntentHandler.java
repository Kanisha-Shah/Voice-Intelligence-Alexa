package com.amazon.ask.questionnaire.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.questionnaire.dao.QuestionDAO;
import com.amazon.ask.questionnaire.dao.QuestionTypeDAO;

public class QuestionTypeIntentHandler implements RequestHandler {

	public static final String QUESTION_TYPE_SLOT = "QuestionType";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("QuestionTypeIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		QuestionTypeDAO questionTypeDAO = new QuestionTypeDAO();
		QuestionDAO questionDAO = new QuestionDAO();

		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot questionTypeSlot = slots.get(QUESTION_TYPE_SLOT);
		String speechText = "";
		String repromptText = "";

		int skillId = (int) input.getAttributesManager().getSessionAttributes().get("skillId");
		System.out.println("int skill id : " + skillId);
		
		//Re-setting the session value for the skill so that the value will be available in next cycle.
		input.getAttributesManager().setSessionAttributes(Collections.singletonMap("skillId", skillId));

		if (questionTypeSlot != null) {

			String questionType = questionTypeSlot.getValue();
			System.out.println("questionType :: " + questionType);

			int questionTypeId = questionTypeDAO.getquestionTypeIdByName(questionType, skillId);
			System.out.println("questionTypeId :: " + questionTypeId);

			input.getAttributesManager().setSessionAttributes(Collections.singletonMap("questionType", questionType));
			input.getAttributesManager()
					.setSessionAttributes(Collections.singletonMap("questionTypeId", questionTypeId));

			if (questionType.equals("MCQ")) {

				Map<String, Object> questionMap = questionDAO.getQuestionByQuestionTypeIdAndSkillId(questionType,
						questionTypeId, skillId);

				int questionId = (int) questionMap.get("questionId");
				System.out.println("questionId :: " + questionId);
				input.getAttributesManager().setSessionAttributes(Collections.singletonMap("questionId", questionId));

				if (questionMap.isEmpty()) {
					speechText = "there is no question types available right now, you can try other skill !!";
					repromptText = "please try other skill.";
				} else {

					speechText = "okay, the question is " + questionMap.get("question")
							+ " and the relevant options are " + questionMap.get("option1") + ", "
							+ questionMap.get("option2") + ", " + questionMap.get("option3") + ", "
							+ questionMap.get("option4") + ".";
					repromptText = "the question is" + questionMap.get("question") + " and the relevant options are "
							+ questionMap.get("option1") + ", " + questionMap.get("option2") + ", "
							+ questionMap.get("option3") + ", " + questionMap.get("option4") + ".";

				}

			} else if (questionType.equals("1 word")) {

				Map<String, Object> questionMap = questionDAO.getQuestionByQuestionTypeIdAndSkillId(questionType,
						questionTypeId, skillId);

				int questionId = (int) questionMap.get("questionId");
				System.out.println("questionId :: " + questionId);

				input.getAttributesManager().setSessionAttributes(Collections.singletonMap("questionId", questionId));

				if (questionMap.isEmpty()) {
					speechText = "there is no question types available right now, you can try other skill !!";
					repromptText = "please try other skill.";
				} else {

					speechText = "okay, the question is " + questionMap.get("question");
					repromptText = "the question is" + questionMap.get("question");

				}

			}

		} else {

			System.out.println("questionTypeSlot is null");

		}

		return input.getResponseBuilder().withShouldEndSession(false).withSimpleCard("StateSession", speechText)
				.withSpeech(speechText).withReprompt(repromptText).build();
	}

}
