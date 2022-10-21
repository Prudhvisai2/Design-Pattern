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

	public boolean login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username");
		String username = sc.next();
		System.out.println("Password");
		String password = sc.next();
		try {
			List<String> buyer = Files.readAllLines(Paths.get("BuyerInfo.txt"));
			for (String b : buyer) {
				if(b.length() != 0 && b.split(":")[0] == username && b.split(":")[1] == password) {
					this.thePerson = new Buyer(username);
					return true;
				}
			}
			List<String> seller = Files.readAllLines(Paths.get("SellerInfo.txt"));
			for(String s : seller) {
				if(s.length() != 0 && s.split(":")[0] == username && s.split(":")[1] == password) {
					this.thePerson = new Seller(username);
					return true;
				}
			}
		}
		catch(java.io.IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addTrading() {

	}

	public void viewTrading() {

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

	public void AttachProductToUser() {

	}

	public void SelectProduct() {

	}

	public void productOperation() {

	}

	public static void main(String[] args) {
		Facade f = new Facade();
	}

}
