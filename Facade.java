import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.nio.*;
public class Facade {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	private String productName;

	private Trading trade;

	public boolean login() {
		trade = new Trading();
		Scanner sc = new Scanner(System.in);
		System.out.println("Username");
		String username = sc.next();
		System.out.println("Password");
		String password = sc.next();
		try {
			List<String> buyer = Files.readAllLines(Paths.get("BuyerInfo.txt"));
			for (String b : buyer) {
				if(b.length() != 0 && b.split(":")[0].equals(username) && b.split(":")[1].equals(password)) {
					this.thePerson = new Buyer(username);
					this.userType=0;
					return true;
				}
			}
			List<String> seller = Files.readAllLines(Paths.get("SellerInfo.txt"));
			for(String s : seller) {
				if(s.length() != 0 && s.split(":")[0].equals(username) && s.split(":")[1].equals(password)) {
					this.thePerson = new Seller(username);
					this.userType=1;
					return true;
				}
			}
		}
		catch(java.io.IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addTrading() throws IOException {
		trade.addTrading(this.productName,this.thePerson.name);
	}



	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {
		try {
			List<String> gt = Files.readAllLines(Paths.get("ProductInfo.txt"));
			theProductList = new ClassProductList(gt);
		}
		catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public void AttachProductToUser(Person p,ClassProductList g) {
		p.products=g.products;
	}

	public void SelectProduct() {

	}

	public void productOperation() {

	}

	private void runApplication() throws IOException {
		this.createProductList();
		System.out.println("Enter your username and password");
		while(!this.login())
		{
			System.out.println("Login failed");
		}
		System.out.println("Login successful");
		this.AttachProductToUser(this.thePerson,this.theProductList);
		this.selectProduct();
		thePerson.showMenu();
		System.out.println("Select a product from the above list ");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		String productName = reader.readLine();
		this.productName = productName;
		System.out.println("You entered "+ productName);
		System.out.println("Select an action (Enter number only) :\n1."+((userType==0)?" View sellers selling this product.":" View buyers willing to buy this product.") +
				"\n2."+((userType==0)?" Bid for this product.":" Open an auction for this product."));
		String option = reader.readLine();
		if(option.trim().equalsIgnoreCase("1")) {
			viewTrading();
		} else {
			addTrading();
		}
	}

	private void viewTrading() throws IOException {
		trade.viewTrading(this.productName,this.userType);

	}


	private void selectProduct() throws IOException {
		System.out.println("Select menu Please enter \"Meat\" or \"Produce\"");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		// Reading data using readLine
		String name = reader.readLine();
		int typ = 0;
		if(name.equalsIgnoreCase("meat")) typ = 0;
		if(name.equalsIgnoreCase("produce")) typ = 1;
		this.nProductCategory = typ;
		this.thePerson.productType(typ);
	}

	public static void main(String[] args) throws IOException {
		Facade f = new Facade();
		while(true) {
			f.runApplication();
			System.out.println("Exiting..... \n\n\n");
		}
	}

}
