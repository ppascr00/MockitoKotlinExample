package com.xeridia.mockexample;

import com.xeridia.mockexample.EmployeeRepository;
import java.util.function.Function;

@FunctionalInterface
public interface TransactionCode<T> extends Function<EmployeeRepository, T> {

}
