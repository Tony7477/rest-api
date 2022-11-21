package com.springframework.restapi.services;

import com.springframework.restapi.BaseEntity.Course;
import com.springframework.restapi.BaseEntity.Topic;
import com.springframework.restapi.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses(String topicid) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicid).forEach(courses::add);
        return courses;
    }

    public java.util.Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);


    }

    public void addCourse(Course course) {

        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
        courseRepository.save(course);
    }

    //functions by deleting repatitive and single element matches with id
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}