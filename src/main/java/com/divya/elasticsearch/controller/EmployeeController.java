package com.divya.elasticsearch.controller;

import com.divya.elasticsearch.dao.EmployeeDao;
import com.divya.elasticsearch.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
    private EmployeeDao employeeDao;



    @PostMapping("/add")
    public Employee insertEmployee(@RequestBody Employee employee) throws Exception{
        return employeeDao.insertBook(employee);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "Employee",key = "#id")
    public Map<String, Object> getEmployeeById(@PathVariable String id){
        return employeeDao.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    @CachePut(value = "Employee",key = "#id")
    public Map<String, Object> updateEmployeeById(@RequestBody Employee employee, @PathVariable String id){
        return employeeDao.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "Employee", allEntries = true)
    public void deleteEmployeeById(@PathVariable String id){
         employeeDao.deleteBookById(id);
    }
}
