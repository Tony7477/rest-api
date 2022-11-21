package com.springframework.restapi.repositories;

import com.springframework.restapi.BaseEntity.Course;
import com.springframework.restapi.BaseEntity.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {
    //this is automatic implementation
    public List<Course> findByName(String topicid);
    public List<Course>findByTopicId(String topicid);



}
