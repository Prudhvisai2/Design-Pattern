import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProduceProductMenu extends ProductMenu {

	public void showMenu() throws IOException {
		System.out.println("Inside produce product menu...");
		List<String> prods = Files.readAllLines(Paths.get("ProductInfo.txt"));
		for(String s: prods) {
			String k = s.split(":")[0];
			if(k.equalsIgnoreCase("Produce"))
				System.out.println(s.split(":")[1]);
		}
	}

	public void showAddButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showViewButton() {

	}

	public void showComboxes() {

	}

}
