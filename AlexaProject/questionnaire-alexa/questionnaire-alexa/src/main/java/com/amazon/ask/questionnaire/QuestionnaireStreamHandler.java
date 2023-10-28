/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.questionnaire;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.questionnaire.handlers.FallbackIntentHandler;
import com.amazon.ask.questionnaire.handlers.HelpIntentHandler;
import com.amazon.ask.questionnaire.handlers.LaunchRequestHandler;
import com.amazon.ask.questionnaire.handlers.QuestionIntent;
import com.amazon.ask.questionnaire.handlers.QuestionTypeIntentHandler;
import com.amazon.ask.questionnaire.handlers.SessionEndedRequestHandler;
import com.amazon.ask.questionnaire.handlers.SkillIntentHandler;
import com.amazon.ask.questionnaire.handlers.StopIntentHandler;
import com.amazon.ask.questionnaire.dao.QuestionTypeDAO;
import com.amazon.ask.questionnaire.handlers.AnswerDescriptionIntent;
import com.amazon.ask.questionnaire.handlers.AnswerIntentHandler;
import com.amazon.ask.questionnaire.handlers.CancelandStopIntentHandler;

public class QuestionnaireStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler(),
                        new SkillIntentHandler(),
                        new QuestionTypeIntentHandler(),
                        new AnswerIntentHandler(),
                        new AnswerDescriptionIntent(),
                        new QuestionIntent(),
                        new StopIntentHandler())
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public QuestionnaireStreamHandler() {
        super(getSkill());
    }

}
