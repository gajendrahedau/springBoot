package com.cg.banking.services;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component(value="bankingServices")
public class BankingServicesImpl implements BankingServices {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	public Account openAccount(Account account)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
			//if(initBalance<1000) throw new InvalidAmountException("Minimum Amount for opening an account is 1000.");
			//Account account=new Account();
			account.setStatus("Active");
			account=accountDAO.save(account);
		return account;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account=accountDAO.findById(accountNo).orElseThrow(()->new AccountNotFoundException("Account does not exist"));
		
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException,InvalidAmountException {
			Account account=getAccountDetails(accountNo);
			if(accountStatus(accountNo).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");	
			if(amount<0){
				throw new InvalidAmountException("Please enter positive amount");
			} 
			account.setAccountBalance(account.getAccountBalance()+amount);
			account=accountDAO.save(account);
			Transaction transaction=new Transaction(amount, "Deposit", account);
			transactionDAO.save(transaction);
		return account.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException, InvalidAmountException {
			Account account=getAccountDetails(accountNo);
			if(accountStatus(accountNo).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");
			if(account.getPinNumber()!=pinNumber)
				throw new InvalidPinNumberException("Pin is Incorrect");
				if(amount<0)
					throw new InvalidAmountException("Please enter positive amount");
			if((account.getAccountBalance()-1000)<amount) throw new InsufficientAmountException("Balance is low.");
			account.setAccountBalance(account.getAccountBalance()-amount);
			account=accountDAO.save(account);
			Transaction transaction=new Transaction(amount, "Withdraw", account);
			transactionDAO.save(transaction);
		return account.getAccountBalance();
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException, InvalidAmountException {
		Account accountTo=getAccountDetails(accountNoTo);
		Account accountFrom=getAccountDetails(accountNoFrom);
		if(accountStatus(accountNoTo).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");
		if(accountFrom.getPinNumber()!=pinNumber)
			throw new InvalidPinNumberException("Pin is Incorrect");
		if(transferAmount<0)
			throw new InvalidAmountException("Please enter positive amount");
		withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		depositAmount(accountNoTo, transferAmount);
		Transaction transaction1=new Transaction(transferAmount, "Deposit", accountTo);
		transactionDAO.save(transaction1);
		Transaction transaction2=new Transaction(transferAmount, "Withdraw", accountFrom);
		transactionDAO.save(transaction2);
		
		return true;
	}


	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accountDAO.findAll();
	}
	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return transactionDAO.findAll();
	}
	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account=getAccountDetails(accountNo);
		return account.getStatus();
	}
}