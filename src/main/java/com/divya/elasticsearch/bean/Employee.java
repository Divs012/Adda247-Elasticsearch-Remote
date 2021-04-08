package com.divya.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {

    private String id;
    private String name;
    private String department;
    private float salary;


}
