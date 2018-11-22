package com.cg.banking.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;

@Controller
public class AccountController {
	@Autowired
	private BankingServices bankingServices;
	@RequestMapping("/registerAccount")
	public ModelAndView registerAccountAction(@RequestParam("accountType") String accountType,@RequestParam("accountBalance") float accountBalance,@RequestParam("pinNumber") int pinNumber,HttpSession session) throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account=new Account(accountType, accountBalance,pinNumber);
				account=bankingServices.openAccount(account);
		session.setAttribute("account", account);
		return new ModelAndView ("registrationSuccess","account",account);
		
	}
	
	@RequestMapping("/loginAccount")
	public ModelAndView loginAccountAction(@RequestParam("accountNo") long accountNo,@RequestParam("pinNumber") int pinNumber,HttpSession session){
		Account account2=new Account(accountNo, pinNumber);
		//Account account2=(Account)session.getAttribute("account");
		try {
			account2=bankingServices.getAccountDetails(accountNo);
			if((account2.getAccountNo()==accountNo)&&(pinNumber==account2.getPinNumber())) {
				session.setAttribute("account", account2);
				return new ModelAndView ("loginSuccessPage","account",account2);
			}
			else {
				String msg="Invalid pinNumber";
				return new ModelAndView("loginPage","msg",msg);
			}

		} catch (AccountNotFoundException | BankingServicesDownException e) {
			 String msg="Account does not exist";
			return new ModelAndView("loginPage","msg",msg);
		}
	}
	@RequestMapping("/depositAccount")
	public ModelAndView depositAccountAction(@RequestParam("amount") float amount,HttpSession session){
		 Account account1=(Account)session.getAttribute("account");
		 try {
			amount=bankingServices.depositAmount(account1.getAccountNo(),amount);
			return new ModelAndView("depositAmountPage","amount",amount);
		} catch (AccountNotFoundException | BankingServicesDownException | AccountBlockedException | InvalidAmountException e) {
			return new ModelAndView("depositAmountPage","amount",e.getMessage());
		}
}
	@RequestMapping("/withdrawAmount")
	public ModelAndView withdrawAmoutAction(@RequestParam("amount") float amount, @RequestParam("pinNumber") int pinNumber,HttpSession session) {
		Account account1=(Account)session.getAttribute("account");
		try {
			amount = bankingServices.withdrawAmount(account1.getAccountNo(), amount, pinNumber);
			return new ModelAndView("withdrawAmountPage","amount",amount);
		} catch (InsufficientAmountException | AccountNotFoundException | InvalidPinNumberException
				| BankingServicesDownException | AccountBlockedException | InvalidAmountException e) {
			return new ModelAndView("withdrawAmountPage","amount",e.getMessage());
			
		}
		
	}
	
	@RequestMapping("/fundTransfer")
	public ModelAndView fundTransferAction(@Valid @ModelAttribute Account account,BindingResult result,HttpSession session) throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InsufficientAmountException, InvalidPinNumberException,InvalidAmountException {
	/*	if(result.hasErrors())
			return new ModelAndView("loginPage");*/
		Account account1=(Account)session.getAttribute("account");
		
		try {
			bankingServices.fundTransfer(account.getAccountNo(),account1.getAccountNo(),account.getAccountBalance(),account.getPinNumber());
			String message="amount transferred sucessfully";
			return new ModelAndView("fundTransferPage","message",message);
		} catch (InvalidPinNumberException | AccountNotFoundException | InvalidAmountException e) {
			return new ModelAndView("fundTransferPage","message",e.getMessage());
		}
		
	}
	@RequestMapping("/getAllTransactionDetails")
	public ModelAndView getAllTransactionDetailsAction(@Valid @ModelAttribute Account account,BindingResult result,HttpSession session) throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InsufficientAmountException, InvalidPinNumberException {
		if(result.hasErrors())
			return new ModelAndView("loginPage");
		Account account1=(Account)session.getAttribute("account");
		List<Transaction>transactions=bankingServices.getAccountAllTransaction(account1.getAccountNo());
		return new ModelAndView("fundTransferPage","transactions",transactions);
		
	}
}
