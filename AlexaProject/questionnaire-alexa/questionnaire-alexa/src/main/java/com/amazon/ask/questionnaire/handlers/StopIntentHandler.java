package com.amazon.ask.questionnaire.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

public class StopIntentHandler implements RequestHandler {
	
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("StopIntentHandler"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		String speechText = "okay, have a nice day.";
		
		return input.getResponseBuilder()
				.withSimpleCard("StateSession", speechText)
				.withSpeech(speechText)
				.withShouldEndSession(true)
				.build();
	}
}
