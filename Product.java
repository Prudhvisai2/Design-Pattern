public class Product {

    public String name;
    public int type;

    public Product(String name, String type) {
        this.name = name;
        if(type.equals("Meat")) {
            this.type = 0;
        }
        else {
            this.type = 1;
        }
    }

}
