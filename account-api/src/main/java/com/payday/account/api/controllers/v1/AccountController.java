package com.payday.account.api.controllers.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payday.account.api.models.v1.AccountDto;
import com.payday.account.api.models.v1.TransactionDto;
import com.payday.account.application.services.IAccountService;
import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("")
	@ResponseBody
	public List<AccountDto> getAccounts() {
		Long userId = 1L;
		List<Account> accounts = accountService.FindByUserId(userId);
		return convertAccountToDtos(accounts);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public AccountDto getAccount(@PathVariable Long id) {
		Account account = accountService.FindById(id);
		return convertToDto(account);
	}
	
	@GetMapping("/{id}/transactions")
	@ResponseBody
	public List<TransactionDto> getAccountTransactions(@PathVariable Long id) {
		List<Transaction> transactions = accountService.FindTransactions(id);
		return convertTransactionToDtos(transactions);
	}

	private AccountDto convertToDto(Account account) {
		AccountDto accountDto = modelMapper.map(account, AccountDto.class);
		return accountDto;
	}
	
	private List<AccountDto> convertAccountToDtos(List<Account> accounts) {
		return accounts.stream().map(a -> modelMapper.map(a, AccountDto.class))
		.collect(Collectors.toList());
		
	}	
	
	private List<TransactionDto> convertTransactionToDtos(List<Transaction> transactions) {
		return transactions.stream().map(a -> modelMapper.map(a, TransactionDto.class))
		.collect(Collectors.toList());
		
	}

}
