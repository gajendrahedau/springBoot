package com.cg.banking.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.services.BankingServices;

@Controller
public class URIController {
	Account account;
	
	@Autowired
	BankingServices bankingServices;
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@RequestMapping("/login")
	public String getLoginPage() {
		return "loginPage";
	}
	@RequestMapping("/loginSuccessPage")
	public String getLoginSuccessPage() {
		return "loginSuccessPage";
	}
	@RequestMapping("/getAccountDetailsPage")
	public ModelAndView getAccountDetailsPage(HttpSession session) {
		Account account=(Account)session.getAttribute("account");
		//float balance=account.getAccountBalance();
		//String type=account.getAccountType();
		return new ModelAndView("getAccountDetailsPage","account",account);
	}
	@RequestMapping("/depositAmountPage")
	public String getdepositAmountPage() {
		return "depositAmountPage";
	}
	@RequestMapping("/withdrawAmountPage")
	public String getwithdrawAmountPage() {
		return "withdrawAmountPage";
	}
	@RequestMapping("/fundTransferPage")
	public String getfundTransferPage() {
		return "fundTransferPage";
	}
	@RequestMapping("/getAccountAllTransactionPage")
	public ModelAndView getAccountAllTransactionPage(HttpSession session) throws BankingServicesDownException, AccountNotFoundException {
		Account account=(Account)session.getAttribute("account");
		List<Transaction>transactions=bankingServices.getAccountAllTransaction(account.getAccountNo());
		return new ModelAndView("getAccountAllTransactionPage","transactions",transactions);
	}
	@ModelAttribute
	public Account getAccount() {
		account=new Account();
		return account;
		
	}
}
