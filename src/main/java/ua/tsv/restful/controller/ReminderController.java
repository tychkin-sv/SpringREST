package ua.tsv.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.tsv.restful.entity.Remind;
import ua.tsv.restful.repository.RemindRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reminder")
public class ReminderController {


    @Autowired
    RemindRepository remindRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Remind getRemind(){
        List<Remind> list = remindRepository.findAll();
        return createMockRemind();
    }

    private Remind createMockRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setTitle("Напоминание 1");
        remind.setRemindDate(new Date());

        return remind;

    }


    @RequestMapping(value = "/getOld", method = RequestMethod.GET)
    @ResponseBody
    public String getRemindOld(){

        return "{\"var\":\"myvar\"}";
    }

}
