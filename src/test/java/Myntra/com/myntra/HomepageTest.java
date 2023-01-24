package Myntra.com.myntra;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class HomepageTest {
	
	PlaywrightFactory pf;
	Homepage homepage;
	Page page;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		page =pf.initBrowser("chrome");
		homepage = new Homepage(page);
	}
	
	@Test(priority = 2)
	public void testhomepagetitle() {
		String actualtitle = homepage.gethomepagetitle();
		Assert.assertEquals(actualtitle, "Online Shopping India - Shop for clothes, shoes, Bags, watches @ Shoppersstop.com");
	}
	
	@Test(priority = 1)
	public void test() {
		String actualurl = homepage.gethomepageurl();
		Assert.assertEquals(actualurl, "https://www.shoppersstop.com/");
	}
	
	@Test(priority = 3)
	public void testdosearchmen() {
		String actualproductname = homepage.dosearchmen("jeans for men");
		
		Assert.assertEquals(actualproductname,"https://www.shoppersstop.com/search/?text=jeans+for+men");
	}
	
	@Test(priority = 4)
	public void testdosearchshirts() {
		String actualproductname = homepage.dosearchmen("shirts for men");
		
		Assert.assertEquals(actualproductname,"https://www.shoppersstop.com/search/?text=shirts+for+men");
	}
	
	@AfterTest
	public void teardown() {
		page.context().browser().close();
		
	}
}
