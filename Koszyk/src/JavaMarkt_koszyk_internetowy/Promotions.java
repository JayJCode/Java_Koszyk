package JavaMarkt_koszyk_internetowy;

import java.util.List;

class DiscountOnTotalPromotion implements PromotionCommand {
    private final double threshold;
    private final double discountRate;

    public DiscountOnTotalPromotion(double threshold, double discountRate) {
        this.threshold = threshold;
        this.discountRate = discountRate;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        double total = shoppingCart.calculateTotalPrice();
        if (total > threshold) {
            shoppingCart.getProducts().forEach(p -> p.setDiscountPrice(p.getDiscountPrice() * (1 - discountRate)));
        }
    }
}

class FreeProductPromotion implements PromotionCommand {
    private final int n;

    public FreeProductPromotion(int n) {
        this.n = n;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        if (shoppingCart.getProducts().size() >= n) {
            shoppingCart.sortProducts("price");
            shoppingCart.getProducts().getFirst().setDiscountPrice(0);
        }
    }
}

class FreeGiftPromotion implements PromotionCommand {
    private final double threshold;
    private final String code;
    private final String name;

    public FreeGiftPromotion(double threshold, String code, String name) {
        this.threshold = threshold;
        this.code = code;
        this.name = name;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        double total = shoppingCart.calculateTotalPrice();
        if (total > threshold) {
            shoppingCart.addProduct(code, name, 0);
        }
    }
}

class VoucherOnProduct implements PromotionCommand {
    private final String code;
    private final double discountRate;

    public VoucherOnProduct(String code, double discount) {
        this.code = code;
        this.discountRate = discount;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        Product product = shoppingCart.findProductByCode(code);
        if (product != null) {
            product.setDiscountPrice(product.getDiscountPrice() * (1 - discountRate));
        }
    }
}