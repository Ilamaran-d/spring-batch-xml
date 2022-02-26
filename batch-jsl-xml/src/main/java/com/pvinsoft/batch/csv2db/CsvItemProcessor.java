package com.pvinsoft.batch.csv2db;

import org.springframework.batch.item.ItemProcessor;

import com.pvinsoft.batch.model.Employee;


public class CsvItemProcessor implements ItemProcessor<Employee, Employee>  {

	@Override
    public Employee process(Employee item) throws Exception {
        
        System.out.println("CSV Item Processing..." + item);
        return item;
    }

}
