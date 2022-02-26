package com.pvinsoft.batch.csv2db;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.pvinsoft.batch.model.Employee;

public class CsvFieldMapper implements FieldSetMapper<Employee> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
    @Override
    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
        
    	Employee employee = new Employee();
    	employee.setId(fieldSet.readInt(0));
    	employee.setSalary(fieldSet.readBigDecimal(1));
    	employee.setAge(fieldSet.readInt(2));
    	employee.setStaffName(fieldSet.readString(3));
        
        //default format yyyy-MM-dd
        //fieldSet.readDate(4);
        String date = fieldSet.readString(4);
        try {
        	employee.setDateOfBirth(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return employee;
        
    }
}
