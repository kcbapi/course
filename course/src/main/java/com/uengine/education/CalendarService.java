package com.uengine.education;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="calendar", url="http://calendar:8088")
public interface CalendarService {

    @RequestMapping(method= RequestMethod.POST, path="/schedules")
    public void addCalendar(@RequestBody  Schedule schedule);

}
