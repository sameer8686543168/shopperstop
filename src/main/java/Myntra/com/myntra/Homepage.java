package Myntra.com.myntra;

import com.microsoft.playwright.Page;

public class Homepage {
	Page page;
	private String mentab = "li.yCmsComponent l1Cat a:has-text('MEN')" ; // to click
	private String clothingtab = "ul.lvl2 a:has-text('CLOTHING')"; // to hover
	private String teaShirtspolos = "a:text('T-Shirts & Polos')";   // To click
	private String pageheader = "h1[xpath ='1']";
	private String searchfeild ="input[placeholder ='Search Products & Brands']";
	private String searchicon ="input.btnsearch";
	private String pageshirtsheader ="h2.plpH2TagCategoryName";


 public Homepage (Page page) {  // constructor
	 this .page = page;
 }
 
 public String  gethomepagetitle() {
	 String title = page.title();
	 System.out.println(title);  
	 return title;
 }
 
 public  String gethomepageurl() {
	String url= page.url();
	System.out.println(url);
	return url;
 }
 public String dosearchmen(String productname) {
	 page.fill(searchfeild, productname);
	 page.click(searchicon);
	 String header =page.textContent(pageshirtsheader);
	 System.out.println(header);
	String shirtsurl = page.url();
	System.out.println(shirtsurl);
	 return shirtsurl;
 }
}
