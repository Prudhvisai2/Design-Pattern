import java.util.*;
import java.lang.*;
public class ClassProductList {

    public List<Product> products = new ArrayList<Product>();
    public ClassProductList(List<String> product) {

        for (String k : product) {
            this.products.add(new Product(k.split(":")[0], k.split(":")[1]));
        }
    }

    public int getSize() {
        return this.products.size();
    }
}
