import java.util.*;
import java.lang.*;
public class ClassProductList {

    public List<Product> products;
    public ClassProductList(List<String> product) {
        products = new ArrayList<Product>();
        for (String k : product) {
            this.products.add(new Product(k.split(":")[0], k.split(":")[1]));
        }
    }

    public int getSize() {
        return this.products.size();
    }
}
