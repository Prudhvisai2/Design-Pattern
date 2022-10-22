import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Trading {

	public void accept(NodeVisitor visitor) {

	}

    public void viewTrading(String productName,int userType) throws IOException {
        List<String> userProducts = Files.readAllLines(Paths.get("UserProduct.txt"));
        for(String usp:userProducts) {
            if(usp.split(":")[1].equalsIgnoreCase(productName)) {
                if (isAPerson(usp.split(":")[0], (userType == 0) ? "SellerInfo.txt" : "BuyerInfo.txt")) {
                    System.out.println(usp.split(":")[0]);
                }
            }
        }
    }

    public boolean isAPerson(String name, String path) throws IOException {
        List<String> sellers = this.getPeopleList(path);
        for(String seller : sellers)
            if(seller.split(":")[0].equalsIgnoreCase(name))
                return true;
        return false;
    }

    private List<String> getPeopleList(String path) throws IOException {
        List<String> list = new ArrayList<String>();
        List<String> seller = Files.readAllLines(Paths.get(path));
        for(String s : seller) {
            list.add(s);
        }
        return list;
    }

    public void addTrading(String productName, String name) throws IOException {
        String ans = "\n"+name+":"+productName;
        FileWriter fw = new FileWriter("UserProduct.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ans);
        bw.close();
    }
}
