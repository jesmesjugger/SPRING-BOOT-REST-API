package com.practice.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class TopicService {
    private List<Topics> topics = new ArrayList<>(Arrays.asList(
               new Topics(1,"Martin Mkolwe","Software Engineer"),
               new Topics(2,"Martin Jumbe","Solutions Architect"),
               new Topics(3,"Raquel Mkolwe","System Analyst"),
               new Topics(4,"Nicholas Muturi","System Analyst"),
               new Topics(5,"Funmilayo Oyeipo","System Analyst"),
               new Topics(6,"Festus Bett Kipngetich","System Analyst")
    ));
    public List<Topics> getAllTopics(){
        return topics;
    }

    public Topics getTopics(int id) {
        return topics.stream().filter(t -> Objects.equals(t.getId(), id)).findFirst().get();
    }

    public void addTopics(Topics topic) {
        topics.add(topic);
    }

    public void updateTopics(int id, Topics topic) {
        for (int i=0; i<=topics.size();i++){
            Topics t=topics.get(i);
            if(Objects.equals(t.getId(), id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopics(int id) {
        topics.removeIf(t -> Objects.equals(t.getId(), id));

    }
}

