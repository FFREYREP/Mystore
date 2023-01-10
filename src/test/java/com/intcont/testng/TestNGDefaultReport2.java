package com.intcont.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import mx.quality.services.utilerias.reportes.Reporteador;

public class TestNGDefaultReport2 {

	static WebDriver driver;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeEachMethod() {
		Reporter.log("Se abre pagina:");
		driver.get("http://google.com");
	}

	@Test
	public void Busqueda_De_Cars() throws Exception {
		System.out.println("Primer caso de prueba");
		Reporteador.escribir("Se busca cars");
		driver.findElement(By.name("q")).sendKeys("Cars");
		Reporteador.takeScreenshot(driver);
		Thread.sleep(6000);
		Reporteador.escribir("Resultado de la busqueda");
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		Reporteador.takeScreenshot(driver);
		String Paso1 = "Agregar producto a Carrito";
		Reporteador.escribir(Paso1);
		if (driver.findElement(By.partialLinkText("cars")).isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@AfterSuite
	public void endOfSuite() {
		driver.quit();
	}


}