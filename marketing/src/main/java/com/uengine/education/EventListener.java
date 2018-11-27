package com.uengine.education;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    /** version 1. callback version **/
    @StreamListener(Streams.INPUT)
    @JsonDeserialize(as = ClazzDayRegistered.class)
    public void handleClazzDay(@Payload ClazzDayRegistered clazzDayRegistered) {

        System.out.println("<이메일 발송>");
        System.out.println("제목: " + clazzDayRegistered.getInstructorName() +" 강사의 OOO강의 [마감임박]");
        System.out.println("** 기념품 증정:  10만원상당의 음성인식 스피커 **");


    }

}
