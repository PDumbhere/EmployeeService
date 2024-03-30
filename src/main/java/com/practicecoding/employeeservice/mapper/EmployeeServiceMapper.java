package com.practicecoding.employeeservice.mapper;

import com.practicecoding.employeeservice.dto.EmployeeDto;
import com.practicecoding.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeServiceMapper {

    EmployeeServiceMapper MAPPER = Mappers.getMapper(EmployeeServiceMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
