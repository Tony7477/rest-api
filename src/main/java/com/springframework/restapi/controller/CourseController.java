package com.springframework.restapi.controller;



import com.springframework.restapi.BaseEntity.Course;
import com.springframework.restapi.BaseEntity.Topic;
import com.springframework.restapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@RestController
public class CourseController {

   @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getCourses(@PathVariable String id){
        return courseService.getAllCourses(id);

    }
    @RequestMapping("/topics/{topicid}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="/topics/{topicid}/courses/")
    public void addCourse(@RequestBody Course course,@PathVariable String topicid){
        course.setTopic(new Topic(topicid,"",""));
        courseService.addCourse(course);

    }
    @RequestMapping(method= RequestMethod.PUT,value="/topics/{topicid}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String id){
        courseService.updateCourse(course,id);

    }
    @RequestMapping(method= RequestMethod.DELETE,value="/topics/{topicid}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);

    }

}
