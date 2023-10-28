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
import com.amazon.ask.questionnaire.dao.AnswerDAO;


public class AnswerIntentHandler implements RequestHandler {
	
	public static final String ANSWER_SLOT = "Answer";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AnswerIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		
		AnswerDAO answerDAO = new AnswerDAO();

		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot answerSlot = slots.get(ANSWER_SLOT);
		
		String speechText = "";
		String repromptText = "";
		
		int skillId= (int)input.getAttributesManager().getSessionAttributes().get("skillId");
		System.out.println("******************************************* :: SkillId :"+skillId);
		
		int questionTypeId= (int)input.getAttributesManager().getSessionAttributes().get("questionTypeId");
		System.out.println("******************************************* :: questionTypeId :"+questionTypeId);
		
		
		int questionId= (int)input.getAttributesManager().getSessionAttributes().get("questionId");
		System.out.println("*******************************************"+questionId);

		
		
		if (answerSlot != null) {
			
			String answerSlotValue = answerSlot.getValue();
			System.out.println("answerSlotValue :: " + answerSlotValue);
			
			String answer = answerDAO.getAnswer(questionId);
			
			String answerValue = answer.toLowerCase();
			 
			if(answerSlotValue.equals(answerValue)) {
				
				speechText = "Excellent, the answer is right";
				
			}else {
				speechText = "opss, its wrong answer";
			}
		
		}else {
			
			System.out.println("answerSlot is null");
			
		}
		
		return input.getResponseBuilder().withSimpleCard("StateSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).withShouldEndSession(false).build();
	}

}

