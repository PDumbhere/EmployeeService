package com.practicecoding.employeeservice.service.impl;

import com.practicecoding.employeeservice.dto.EmployeeDto;
import com.practicecoding.employeeservice.entity.Employee;
import com.practicecoding.employeeservice.mapper.EmployeeServiceMapper;
import com.practicecoding.employeeservice.repository.EmployeeRepository;
import com.practicecoding.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(employeeDto.getId(),employeeDto.getFirstName(),
//                employeeDto.getLastName(),employeeDto.getEmail());
//ModelMapper->
//        Employee employee = modelMapper.map(employeeDto,Employee.class);
//MapStruct->
        Employee employee = EmployeeServiceMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
//        return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
//                savedEmployee.getLastName(), savedEmployee.getEmail() );
//ModelMapper->
//        return modelMapper.map(savedEmployee,EmployeeDto.class);
//MapStruct->
        return EmployeeServiceMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.get();
//        return new EmployeeDto(employee.getId(), employee.getFirstName(),
//                employee.getLastName(), employee.getEmail());
//ModelMapper->
//        return modelMapper.map(employee,EmployeeDto.class);
//MapStruct->
        return EmployeeServiceMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
