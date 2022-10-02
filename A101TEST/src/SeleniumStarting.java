import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumStarting {

    static WebDriver _driver;
    
	public static void Starting() {  
		System.setProperty("webdriver.chrome.driver",getPath()+"\\src\\chromedriver_win32\\chromedriver.exe");
		_driver = new ChromeDriver();
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		_driver.manage().window().maximize();
		_driver.get("https://www.a101.com.tr/");
	}
	public static void CookiesAllow() {
		   try {
	            // Cookies Allow
	            _driver.findElement(ByXPath.xpath("//button[contains(@id,'AllowAll')]")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public static void MenuHover() {
		go:  
		// Menu HOVER
		try {
		      WebElement element = _driver.findElement(By.xpath("//ul[contains(@class,'desktop')]/li/a[contains(@href,'giyim')]"));
		        //Creating object of an Actions class
		        Actions action = new Actions(_driver);
		        //Performing the mouse hover action on the target element.
		        action.moveToElement(element).perform();
		} catch (Exception e) {
			PopupControl();
			RefreshDriver();
			break go;
		}
  
        
	}
	public static void CategoryClick() {
        // Dizaltı Çorap Click
		go:
		try {
			 _driver.findElement(ByXPath.xpath("//li/a[contains(text(),'Dizaltı Çorap')]")).click();
		} catch (Exception e) {
			RefreshDriver();
			PopupControl();
			CookiesAllow();
			MenuHover();
			break go;
		}
	}
	public static void FindProduct() {
		go:
		try {
			 List<WebElement> ProductLinkList = _driver.findElements(ByXPath.xpath("//ul[contains(@class,'product-list-general')]/li/article/a"));
		     Integer productCount = ProductLinkList.size();
		     
		     for (int i = 0; i < productCount; i++) {
		    	 _driver.findElements(ByXPath.xpath("//ul[contains(@class,'product-list-general')]/li/article/a")).get(i).click();
					Boolean found = false;
					List<WebElement> colorList = _driver.findElements(By.xpath("//div[contains(@class,'variants-color')]//a"));
					for (WebElement color : colorList) {
					System.out.println(color.getAttribute("title"));
						String xyz =color.getAttribute("title");
						if (xyz.equals("SİYAH")) {
							System.out.println(xyz+"BAŞARILI");
							found = true;
							break;
						}else {
							System.out.println(xyz+" BAŞARISIZ");
						}
					}
					
					if (found == true) {
						 System.out.println("BULUNDU");
						break;
					}
					_driver.navigate().back();
				}
		} catch (Exception e) {
			PopupControl();
			RefreshDriver();
			break go;
		}
		
	
	}	
	public static void AddToBasket() {
		go:
			try {
				_driver.findElement(ByXPath.xpath("//button[contains(@class,'add-to-basket')]")).click();
			} catch (Exception e) {
				PopupControl();
				RefreshDriver();

				break go;
			}
	
    
}	
    public static void GoToBasket() {
    	go:
		try {
			_driver.findElement(ByXPath.xpath("//a[contains(@class,'go-to-shop')]")).click();
		} catch (Exception e) {
			PopupControl();
			break go;
		}
	}	
    public static void Checkout() {
		go:
    	try {
	        // Ödeme
	        _driver.findElement(By.xpath("//a[contains(@class,'checkout-button')]")).click();
		} catch (Exception e) {
			PopupControl();
			RefreshDriver();
			break go;
		}
	}
	public static void EmailCountunie() {
		  // Üyelik olmadan devam et
		_driver.findElement(By.xpath("//a[contains(@class,'proceed-to-checkout')]")).click();
      
        // Email girişi
		_driver.findElement(By.xpath("//input[contains(@name,'user_email')]")).sendKeys("testdeneme@gmail.com");
        
        // Devam Et
		_driver.findElement(By.xpath("//form[contains(@class,'checkout')]//button[@type='submit']")).click();

	}
	public static void AddressProccess() throws InterruptedException {
		Thread.sleep(3000);
		_driver.findElement(By.xpath("(//a[contains(@class,'new-address')])[1]")).click();
	        // Adress İnput 
	        Thread.sleep(1000);
	       
	        
	        
	        _driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys("Burak Mert");
	        Thread.sleep(1000);
	        _driver.findElement(By.xpath("//input[contains(@name,'last_name')]")).sendKeys("KÖSE");
	        Thread.sleep(1000);
	        _driver.findElement(By.xpath("//input[contains(@name,'phone_number')]")).sendKeys("5524030000");
	        Thread.sleep(1000);
	        Select s1 = new Select(_driver.findElement(By.xpath("//select[contains(@name,'city')]")));
	        s1.selectByIndex(1);
	        Thread.sleep(1000);
	        Select s2 = new Select(_driver.findElement(By.xpath("//select[contains(@name,'township')]")));
	        s2.selectByIndex(1);
	        Thread.sleep(1000);
	        Select s3 = new Select( _driver.findElement(By.xpath("//select[contains(@name,'district')]")));
	        s3.selectByIndex(1);
	        Thread.sleep(1000);
	        _driver.findElement(By.xpath("//textarea[contains(@name,'line')]")).sendKeys("Adres deneme satırı. 01010101101010101  :)");
	        Thread.sleep(1000);
	        Random rnd = new Random();
	        int x =rnd.nextInt(999);
	        _driver.findElement(By.xpath("//input[contains(@placeholder,'Ev adresim')]")).sendKeys("Ev adresi denemexx"+x);
	      
	}
	public static void SaveAddress() {
		 try {
			 _driver.findElement(By.xpath("//button[@type='button'][contains(.,'KAYDET')]")).click();

		} catch (Exception e) {
			_driver.findElement(By.xpath("//input[contains(@placeholder,'Ev adresim')]")).submit();
		}  
	}
    public static void ShippingSelect() {
    	go:
    	try {
    		JavaScriptClick(_driver,_driver.findElement(By.xpath("(//input[@name='shipping'])[1]")));	
		} catch (Exception e) {
			PopupControl();
			break go;
		}
    		
	}	
    public static void FinishButton() {
    	go:
    	try {
    		_driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Devam Et')]")).click();
		} catch (Exception e) {
			PopupControl();
			break go;
		}
    	
	}	
	
	
	public static void PopupControl() {
		try {
			_driver.findElement(By.xpath("//div/div[@onclick='persona_PopupClose();']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void RefreshDriver() {
		_driver.navigate().refresh();
	}
	
	
	public static void JavaScriptClick(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public static String getPath() {
		String userDirectory = System.getProperty("user.dir");
		return userDirectory;
	}
}
