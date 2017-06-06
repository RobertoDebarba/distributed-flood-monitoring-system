package br.com.robertodebarba.jersey_example_project.api.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO {

	private static final List<Product> products = new ArrayList<>();
	private static int lastIndex = 5;

	static {
		ProductDAO.products.add(new Product(1, "Sabonete", "Sabonete Dove pele macia", 10, 4.5));
		ProductDAO.products.add(new Product(2, "Pão", "Pào 7 grãos", 20, 8.5));
		ProductDAO.products.add(new Product(3, "Doce", "Doce de banana", 5, 4.5));
		ProductDAO.products.add(new Product(4, "Tomate", "Tomate fresco", 200, 0.5));
		ProductDAO.products.add(new Product(5, "Laranja", "Laranja doce", 80, 0.25));
	}

	public Product[] getProducts() {
		return ProductDAO.products.toArray(new Product[ProductDAO.products.size()]);
	}

	public Product[] getProducts(String filter) {
		return (Product[]) ProductDAO.products.stream().filter(product -> {
			return product.getName().toLowerCase().contains(filter.toLowerCase().trim())
					|| product.getDescription().toLowerCase().contains(filter.toLowerCase().trim());
		}).toArray(Product[]::new);
	}

	public Optional<Product> getProduct(final int id) {
		return ProductDAO.products.stream().filter(product -> product.getId() == id).findFirst();
	}

	public boolean insertProduct(Product product) {
		product.setId(++ProductDAO.lastIndex);

		ProductDAO.products.add(product);

		return true;
	}

	public boolean updateProduct(Product product) {
		Optional<Product> productOpt = this.getProduct(product.getId());

		if (productOpt.isPresent()) {
			ProductDAO.products.set(ProductDAO.products.indexOf(productOpt.get()), product);
			return true;
		}

		return false;
	}

}
