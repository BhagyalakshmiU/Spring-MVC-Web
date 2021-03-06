package com.demo.controllers;

import java.io.FileOutputStream;

//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

//import com.demo.model.Account;


@Controller
public class myDemoController 
{

/*	@RequestMapping(value="/createAccount")
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Form has Errors");
			return "createAccount";
		}
		System.out.println(account.getFirstName() +" "+ account.getLastName()+ " "+account.getAddress()+" "+account.getEmail()+ " "+account.getAge());
		return "createAccount";
	}

	@RequestMapping(value="/accountCreated",method=RequestMethod.POST)
	public String performance(Account account)
	{
		
		System.out.println(account.getFirstName() +" "+ account.getLastName()+ " "+account.getAddress()+" "+account.getEmail()+ " "+account.getAge());
		return "accountCreated";
	}*/
	@RequestMapping(value="/myForm")
	public String myForm()
	{
		return "myForm";
	}
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file)
	{
		try
		{
			if(!file.isEmpty())
			{
				byte[] bytes=file.getBytes();
				FileOutputStream fos=new FileOutputStream("C:\\Users\\bmattakkarau\\OneDrive - DXC Production\\Pictures\\Saved Pictures\\myFile.jpg");
				fos.write(bytes);
				fos.close();
				System.out.println("File saved successfully!!!");
			}
			else
			{
				System.out.println("No file available to save!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error saving file.");
		}
		return "operationComplete";
	}
}
