import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MeatProductMenu extends ProductMenu {

	public void showMenu() throws IOException {
		System.out.println("Inside meat product menu...");
		List<String> prods = Files.readAllLines(Paths.get("ProductInfo.txt"));
		for(String s: prods) {
			String k = s.split(":")[0];
			if(k.equalsIgnoreCase("Meat"))
				System.out.println(s.split(":")[1]);
		}
	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

}
