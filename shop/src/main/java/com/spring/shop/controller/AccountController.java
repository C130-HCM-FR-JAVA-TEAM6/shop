package com.spring.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.filter.JwtService;
import com.spring.shop.model.Account;
import com.spring.shop.service.AccountService;
import com.spring.shop.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Account account) {
		Account accountSelected = accountService.checkLogin(account.getUserName(),org.springframework.util.DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
		if (accountSelected != null) {
			String token = jwtService.generateTokenLogin(account.getUserName());
			Map<String, Object> map = new HashMap<>();
			map.put("account", accountSelected);
			map.put("token", token);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	// @Pre
	// @PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		Account acc = new Account();
		acc.setRole(roleService.findByRoleName(account.getRole().getRoleName()));
		acc.setAddress(account.getAddress());
		acc.setBirthday(account.getBirthday());
		acc.setEmail(account.getEmail());
		acc.setGender(account.isGender());
		acc.setName(account.getName());
		acc.setUserName(account.getUserName());
		acc.setPassword(org.springframework.util.DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
		acc.setPhone(account.getPhone());
		Account accountInserted = accountService.save(acc);
		if(accountInserted != null) {
			return new ResponseEntity<Account>(accountInserted,HttpStatus.OK);
		}else {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}

	}

	// @PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/getAccount", method = RequestMethod.GET)
	public List<Account> getAccount() {
		List<Account> list = accountService.findAll();
		for(int i=0;i<list.size();i++) {
			list.get(i).setPassword("");
		}
		return list;
	}
	@GetMapping("/deleteAccount/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable("accountId") long accountId){
		boolean delete = accountService.deleteAccount(accountId);
		if(delete) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}


	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public ResponseEntity<?> updateAccount(@RequestBody Account account) {
		Account acc = new Account();
		if(account.getPassword().equals("")) {
			Account update = accountService.findById(account.getAccountId());
			acc.setRole(roleService.findByRoleName(account.getRole().getRoleName()));
			acc.setAddress(account.getAddress());
			acc.setBirthday(account.getBirthday());
			acc.setEmail(account.getEmail());
			acc.setGender(account.isGender());
			acc.setName(account.getName());
			acc.setPassword(update.getPassword());
			acc.setUserName(account.getUserName());
			acc.setPhone(account.getPhone());
			Account accountInserted = accountService.updateAccount(acc);
			if(accountInserted != null) {
				return new ResponseEntity<Account>(accountInserted, HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
			}
		}
		else {
			acc.setRole(roleService.findByRoleName(account.getRole().getRoleName()));
			acc.setAddress(account.getAddress());
			acc.setBirthday(account.getBirthday());
			acc.setEmail(account.getEmail());
			acc.setGender(account.isGender());
			acc.setName(account.getName());
			acc.setUserName(account.getUserName());
			acc.setPassword(org.springframework.util.DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
			acc.setPhone(account.getPhone());
			Account accountInserted = accountService.updateAccount(acc);
			if(accountInserted != null) {
				return new ResponseEntity<Account>(accountInserted, HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
			}
		}
		
		
		
	}
	/*
	 * 
	 * register
	 */
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Account account){
		Account acc = new Account();
		acc.setRole(roleService.findByRoleName("ROLE_MEMBER"));
		acc.setAddress(account.getAddress());
		acc.setBirthday(account.getBirthday());
		acc.setEmail(account.getEmail());
		acc.setGender(account.isGender());
		acc.setName(account.getName());
		acc.setUserName(account.getUserName());
		acc.setPassword(org.springframework.util.DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
		acc.setPhone(account.getPhone());
		Account accountInserted = accountService.save(acc);
		if(accountInserted != null) {
			return new ResponseEntity<Account>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/checkUserName/{userName}")
	public boolean chechUserName(@PathVariable("userName") String userName) {
		return accountService.checkAccountUserName(userName);
	}
	@PostMapping("/checkEmail/{email}")
	public boolean chechEmail(@PathVariable("email") String email) {
		return accountService.checkAccountEmail(email);
	}
	@PostMapping("/checkPhone/{phone}")
	public boolean chechPhone(@PathVariable("phone") String phone) {
		return accountService.checkAccountPhone(phone);
	}
}
