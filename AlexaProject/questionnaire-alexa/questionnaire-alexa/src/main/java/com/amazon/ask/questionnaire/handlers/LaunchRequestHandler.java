/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.questionnaire.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.questionnaire.dao.SkillDAO;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	
    	SkillDAO skilldao = new SkillDAO();
    	
    	List<String> skillList = skilldao.getSkills();
    	
    	System.out.println("====>skill List :: "+skillList);
    	String skills="";
    	String speechText;
    	String repromptText;
    	
    	if(skillList.isEmpty()){
            speechText = "Welcome to the questionnaire. there is no skill available right no, you can try letter !!";
            repromptText = "please try letter.";
    	}else {
    	
        	for(String skill: skillList) {
        		
        		skills += ", "+skill;
        	
        	}
        	
            speechText = "Welcome to the Alexa's questionnaire. please choose your skill, the options are "+skills+".";
            repromptText = "please choose the skill from "+skills;
    	}
    	
    	System.out.println("====>skill String :: "+skills);


        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
