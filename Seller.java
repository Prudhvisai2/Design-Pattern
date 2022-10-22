import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Person {

	public List<Product> products = new ArrayList<Product>();
	public Seller(String name) {
		this.name = name;
		this.type = 1;
	}

	@Override
	public void showMenu() throws IOException {
		System.out.println("Inside buyer show menu: ");
		this.theProductMenu.showMenu();
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
