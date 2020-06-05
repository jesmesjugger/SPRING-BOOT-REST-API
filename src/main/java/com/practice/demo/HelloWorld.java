package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorld{
    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
   public List<Topics> getAllTopics(){
       return topicService.getAllTopics() ;
   }
   @RequestMapping("/topics/{id}")
   public Topics getTopic(@PathVariable int id) {
       return topicService.getTopics(id);
   }
   @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopics(@RequestBody Topics topic){
        topicService.addTopics(topic);
   }
    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopics(@RequestBody Topics topic,@PathVariable int id){
        topicService.updateTopics(id, topic);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopics(@PathVariable int id){
        topicService.deleteTopics(id);
    }

}

