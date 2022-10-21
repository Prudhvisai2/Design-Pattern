public class ProductIterator {

	private ClassProductList classProductList;

	private int productIncrement;

	public ProductIterator(ClassProductList classProductList) {
		this.classProductList = classProductList;
		productIncrement = 0;
	}
	public boolean hasNext() {
		if(productIncrement < classProductList.products.size()) {
			return true;
		}
		return false;
	}

	public Product Next() {
		productIncrement += 1;
		return classProductList.products.get(productIncrement - 1);
	}

	public void MoveToHead() {
		productIncrement = 0;

	}

	public void Remove() {
		this.classProductList.products.get(productIncrement);
	}

}
