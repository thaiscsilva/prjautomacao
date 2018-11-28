package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeiroTeste {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//rafael.braga//Documents//drivers//chromedriver.exe");

		String url = "https://automation-sandbox.herokuapp.com";
		String user = "demouser";
		String pw = "abc123";
		
		
		// Cria uma instância de um WebDriver 
		WebDriver driver = new ChromeDriver();
		
		//maximiza o navegador
		driver.manage().window().maximize();
		
		//acessa a url
		driver.get(url);
		//encontra o elemento e escreve o conteúdo da variável
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pw);
		//encontra o elemento e clica nele
		driver.findElement(By.id("btnLogin")).click();
		
		
	}

}
