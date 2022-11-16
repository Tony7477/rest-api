package com.springframework.restapi.services;

import com.springframework.restapi.BaseEntity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics=new ArrayList<>( Arrays.asList(new Topic("java","core-java","this is about core java"),
            new Topic("spring","spring-framework","this is about spring-framework"),
            new Topic("intellij","intellij-idea","this is about intellij idea")));

    public List<Topic> getTopics(){

        return topics;
    }
    public Topic getTopic(String id){
return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
