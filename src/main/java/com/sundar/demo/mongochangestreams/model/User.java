package com.sundar.demo.mongochangestreams.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sundar Gsv
 * @Date 18/11/18
 * @ClassDescription
 */
@Data
@Builder
@ToString
@Document(collection = "user")
public class User {

    private String id;
    private String name;
    private String address;
}
