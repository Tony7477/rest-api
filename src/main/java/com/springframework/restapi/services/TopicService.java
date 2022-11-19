package com.springframework.restapi.services;

import com.springframework.restapi.BaseEntity.Topic;


import com.springframework.restapi.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topics=new ArrayList<>( Arrays.asList(new Topic("java","core-java","this is about core java"),
            new Topic("spring","spring-framework","this is about spring-framework"),
            new Topic("intellij","intellij-idea","this is about intellij idea")));

    public List<Topic> getTopics(){
        List<Topic>topics=new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }
    public java.util.Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);


    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for(int i=0;i<topics.size();i++){
            Topic t=topics.get(i);
            if(t.getId().equals(id)){
                  topics.set(i,topic);
                  return;
            }

        }
    }

    //functions by deleting repatitive and single element matches with id
    public void deleteTopic( String id) {
        List<Topic> t=new ArrayList<>();
        for(int i=0;i<topics.size();i++){
            if (topics.get(i).getId().equals(id)){
                continue;
            }else{
                t.add(topics.get(i));
            }

        }
        topics=t;

        return;
    }
}
