package com.uengine.education;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @Autowired
    ScheduleRepository scheduleRepository;

    /** version 1. callback version **/
    @StreamListener(Streams.INPUT)
    @JsonDeserialize(as = ClazzDayRegistered.class)
    public void handleClazzDay(@Payload ClazzDayRegistered clazzDayRegistered) {

        Schedule schedule = new Schedule();
        schedule.setInstructorName(clazzDayRegistered.getInstructorName());
        //schedule.setDate(clazzDayRegistered.getStartDate());
        schedule.setDescription("test!!!!");


        scheduleRepository.save(schedule);

    }

}
