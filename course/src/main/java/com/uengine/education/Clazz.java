package com.uengine.education;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */
@Entity
public class Clazz {

    @Id @GeneratedValue
    Long id;
    String instructorName;
    Date startDate;
    Date endDate;
    String title;

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name="courseId")
    Course course;



    ///////////////

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @PreUpdate
    public void setInfo(){

        if(getCourse()!=null){

            setTitle(getCourse().getTitle() + "의 강의 [강사:" + getInstructorName() + "]");
        }

    }


    @PostPersist
    public void publishEvent(){

        // version 1.   direct call
//        CalendarService calendarService = Application.getApplicationContext().getBean(CalendarService.class);
//
//        Schedule schedule = new Schedule();
//        schedule.setInstructorName(getInstructorName());
//        schedule.setDate(getStartDate());
//        schedule.setDescription(getTitle());
//
//        calendarService.addCalendar(schedule);

        // vesion 2.   indirect by pub / sub

        Streams streams = Application.getApplicationContext().getBean(Streams.class);

        MessageChannel messageChannel = streams.outboundChannel();

        ClazzDayRegistered clazzDayRegistered = new ClazzDayRegistered();
        clazzDayRegistered.setInstructorName(getInstructorName());
        //clazzDayRegistered.setStartDate(getStartDate());

        messageChannel.send(MessageBuilder
                .withPayload(clazzDayRegistered)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

        System.out.println("Event published");


    }


}
