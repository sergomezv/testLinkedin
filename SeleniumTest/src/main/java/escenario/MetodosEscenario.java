package main.java.escenario;

import java.util.List;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.description.ByteCodeElement;

public class MetodosEscenario {
	
	private static WebDriver driver;

	
	public static void login(String email, String pass) {
	    try {
	    	//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    	//driver = new ChromeDriver();
	    	System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();
			
	    	driver.get("https://cl.linkedin.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("login-email")).sendKeys(email);
			
			TimeUnit.SECONDS.sleep(0);
			
			driver.findElement(By.id("login-password")).sendKeys(pass);
			TimeUnit.SECONDS.sleep(0);
			
			driver.findElement(By.id("login-submit")).click();
			TimeUnit.SECONDS.sleep(0);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String vizualizarPerfil(String nombre) {
		try {
			driver.findElement(By.id("mynetwork-tab-icon")).click();
			TimeUnit.SECONDS.sleep(2);
			
			driver.findElement(By.className("mn-connections-summary__see-all")).click();
			TimeUnit.SECONDS.sleep(2);
				
			driver.findElement(By.className("mn-connections__search-input")).sendKeys(nombre);
						
			TimeUnit.SECONDS.sleep(2);
			
			driver.findElement(By.className("mn-connection-card__picture")).click();
			TimeUnit.SECONDS.sleep(5);
			
			return driver.getTitle();

		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static String usuarioNoEncontrado() {
		try {
			TimeUnit.SECONDS.sleep(2);
			String texto = driver.findElement(By.id("session_key-login-error")).getText();
			return texto;
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void ingresarAMiPerfil() {
		try {
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.className("nav-item__profile-member-photo")).click();
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.className("nav-settings__linkcard-link")).click();
			TimeUnit.SECONDS.sleep(2);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void agregoUnaExperienciaLaboral(String experiencia) {
		try {

			driver.findElements(By.className("pe-hub-section__expand-button"));
			List<WebElement> elementos = driver.findElements(By.className("pe-hub-section__expand-button"));
			elementos.get(0).click();
			
			driver.findElement(By.className("pe-hub-card-content")).click();
			
			driver.findElement(By.id("position-title-typeahead")).sendKeys("asd");
			driver.findElement(By.id("position-company-typeahead")).sendKeys("Empresa");
			driver.findElement(By.id("position-location-typeahead")).sendKeys("Santiago, Chile");
			driver.findElement(By.id("position-start-month")).sendKeys("1");
			driver.findElement(By.id("position-start-year")).sendKeys("1");
			
			Select year = new Select (driver.findElement(By.name("startYear")));
			year.selectByVisibleText("2017");
							
			driver.findElement(By.id("position-description")).sendKeys("Descripcion_ejemplo");
				
			
			
			TimeUnit.SECONDS.sleep(2);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void compartirRed() {
		driver.findElement(By.cssSelector(".toggle-switch")).click();
		driver.findElement(By.cssSelector(".pe-form-footer__action--submit")).click();
	}
	
	public static void cerrarVentana() {
		try {
			TimeUnit.SECONDS.sleep(2);
			driver.close();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

}
