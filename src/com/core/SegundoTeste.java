package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SegundoTeste {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//rafael.braga//Documents//drivers//chromedriver.exe");
		
		String url = "https://automation-sandbox.herokuapp.com";
		String name= "nomeerrado";
		String pw = "abc123";
		String mensagemEsperada = "Wrong username or password.";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.id("btnLogin")).click();
		
		//Aguarda 10 segundos, para depois começar a executar o restando da instrução
		Thread.sleep(10000);
		
		//Percorre a tela até encontrar o alerta de senha ou login inválido
		String mensagemEncontrada = driver.findElement(By.xpath("//div[@role='alert']")).getText().toString().trim();

		//valida se a mensagem esperada é igual a mensagem encontrada e retorna 0 ou 1;
		boolean myAssert = mensagemEsperada.equals(mensagemEncontrada);
		if(myAssert) {
			System.out.println("Passou!");
		} else {
			System.out.println("Falhou!");
		}
		
	}

}
