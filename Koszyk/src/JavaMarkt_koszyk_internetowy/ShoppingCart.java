package JavaMarkt_koszyk_internetowy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private PromotionManager promotionManager;
    private SorterInterface sortManager;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.promotionManager = new PromotionManager();
        this.promotionManager.setDefaultPromotions();
        this.sortManager = new SortManager();
    }

    public void addProduct(String code, String name, double price) {
        products.add(new Product(code, name, price));
    }

    public void removeProduct(String code) {
        products.removeIf(product -> product.getCode().equals(code));
    }

    public Product findProductByCode(String code) {
        return products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getDiscountPrice).sum();
    }

    // SortManager
    public void sortProducts(String keyValue) {
        sortManager.sort(products, keyValue);
    }

    public void sortProducts(String keyValue, String keyValue2) {
        sortManager.sort(products, keyValue, keyValue2);
    }

    public Product getMin() {
        return sortManager.minimal(products);
    }

    public List<Product> getMin(int amount) {
        return sortManager.minimal(products, amount);
    }

    public Product getMax() {
        return sortManager.maximal(products);
    }

    public List<Product> getMax(int amount) {
        return sortManager.maximal(products, amount);
    }

    // PromotionManager
    public void applyPromotions() {
        promotionManager.applyPromotions(this);
    }

    public void addPromotion(PromotionCommand promotion) {
        promotionManager.addPromotion(promotion);
    }

    public void removePromotion(PromotionCommand promotion) {
        promotionManager.removePromotion(promotion);
    }

    public void removePromotionByClass(Class<?> promotionClass) {
        promotionManager.removePromotionByClass(promotionClass);
    }

    public List<PromotionCommand> getPromotions() {
        return promotionManager.getPromotions();
    }
}
