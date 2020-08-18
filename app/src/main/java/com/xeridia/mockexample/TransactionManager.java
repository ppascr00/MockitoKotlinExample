package com.xeridia.mockexample;

public interface TransactionManager {

	<T> T doInTransaction(TransactionCode<T> code);

}
