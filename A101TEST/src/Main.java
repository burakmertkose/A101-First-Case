import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		SeleniumStarting.Starting();
		
		SeleniumStarting.CookiesAllow();
		
		SeleniumStarting.MenuHover();
		
		SeleniumStarting.CategoryClick();
		
		SeleniumStarting.FindProduct();
		
		SeleniumStarting.AddToBasket();
		
		SeleniumStarting.GoToBasket();
		
		SeleniumStarting.Checkout();
		
		SeleniumStarting.EmailCountunie();
		 Thread.sleep(5000);
		SeleniumStarting.AddressProccess();
		 Thread.sleep(3000);
		SeleniumStarting.SaveAddress();
		
		SeleniumStarting.ShippingSelect();
		
		SeleniumStarting.FinishButton();
		
		infoBox("Test Bitti", "A101 TEST");
		Thread.sleep(10000);
		SeleniumStarting._driver.quit();
	}
	
	
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
}
