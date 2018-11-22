package com.cg.banking.daoservices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans.Account;

public interface AccountDAO extends JpaRepository<Account,Long>   {
	/*com.cg.project.beans.Account saveDetails(Account account)throws SQLException;
	Account findOne(long accountNo);
	Account creditAmount(Account account);
	ArrayList<Account> findAll();
	public List<Transaction> getTransactionAll(long accountNo);*/

}
