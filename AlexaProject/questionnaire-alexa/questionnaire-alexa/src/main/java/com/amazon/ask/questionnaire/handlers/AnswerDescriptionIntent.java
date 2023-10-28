package com.amazon.ask.questionnaire.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.questionnaire.dao.AnswerDAO;

public class AnswerDescriptionIntent implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AnswerDescriptionIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		AnswerDAO answerDAO = new AnswerDAO();
		
		String speechText = "";
		String repromptText = "";
		
		int skillId= (int)input.getAttributesManager().getSessionAttributes().get("skillId");
		
		int questionTypeId= (int)input.getAttributesManager().getSessionAttributes().get("questionTypeId");
		
		int questionId= (int)input.getAttributesManager().getSessionAttributes().get("questionId");

		String answerDescription = answerDAO.getAnswerDescription(questionId,questionTypeId,skillId);
		
		speechText = "the description for this answer is , " + answerDescription;
		
		return input.getResponseBuilder().withSimpleCard("StateSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).withShouldEndSession(false).build();
	}

}
