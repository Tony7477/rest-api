package com.springframework.restapi.repositories;

import com.springframework.restapi.BaseEntity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> {

}
