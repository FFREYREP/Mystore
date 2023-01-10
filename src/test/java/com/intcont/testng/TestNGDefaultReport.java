package com.intcont.testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import mx.quality.services.utilerias.reportes.Reporteador;


public class TestNGDefaultReport {

private static final String String = null;
static WebDriver driver;


@BeforeSuite
public void setup(){
System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
System.setProperty("org.uncommons.reportng.escape-output", "false");
driver = new ChromeDriver();
}
 
@BeforeMethod
public void beforeEachMethod(){
Reporter.log("Se abre pagina:");
driver.get("http://google.com");
}
 
@Test
public void Busqueda_De_Cars () throws Exception {
System.out.println("Primer caso de prueba");
Reporteador.escribir("Se busca cars");
driver.findElement(By.name("q")).sendKeys("Cars");
//takeScreenshot();
Reporteador.takeScreenshot(driver);
Thread.sleep(6000); 
Reporteador.escribir("Resultado de la busqueda");
driver.findElement(By.name("btnK")).click();
Thread.sleep(2000);
//takeScreenshot();

Reporteador.takeScreenshot(driver);
String Paso1="Agregar producto a Carrito";
Reporteador.escribir(Paso1);

if(driver.findElement(By.partialLinkText("cars")).isDisplayed()){
Assert.assertTrue(true); 
}
else{
Assert.assertTrue(false);
}
}
 
@AfterSuite
public void endOfSuite(){
//System.out.println("Metodo para tomar captura");
driver.quit();
}
 
//public static void takeScreenshot() throws Exception {
//String timeStamp;
//File screenShotName;
//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//The below method will save the screen shot in d drive with name "screenshot.png"
//timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
//screenShotName = new File("C:\\Users\\Francisco\\eclipse-workspace\\selenium-webdriver-2\\"+timeStamp+".png");
//FileUtils.copyFile(scrFile, screenShotName);
//String filePath = screenShotName.toString();
//String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
//Reporter.log(path);*/
//}

}