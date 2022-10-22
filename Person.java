import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

	protected ProductMenu theProductMenu;

	public String name;

	public int type;
	public List<Product> products = new ArrayList<Product>();

	public void productType(int type){
		this.type = type;
		if(type==0) {
			this.theProductMenu = new MeatProductMenu();
		} else {
			this.theProductMenu = new ProduceProductMenu();
		}
	}
	public void showMenu() throws IOException {
	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
