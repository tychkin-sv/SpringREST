package ua.tsv.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.tsv.restful.entity.Remind;
import ua.tsv.restful.repository.RemindRepository;

import java.util.Date;
import java.util.List;

@RestController
public class ReminderController {


    @Autowired
    RemindRepository remindRepository;

    @RequestMapping(value = "/reminders/", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders(){

        return remindRepository.findAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminderById(@PathVariable("id") long id){

        return remindRepository.findOne(id);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Remind setReminderById(@RequestBody Remind remind){
        return remindRepository.saveAndFlush(remind);

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
