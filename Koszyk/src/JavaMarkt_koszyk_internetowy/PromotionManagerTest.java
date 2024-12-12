package JavaMarkt_koszyk_internetowy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromotionManagerTest {

    @Test
    public void testAddRemovePromotion() {
        PromotionManager manager = new PromotionManager();
        PromotionCommand promotion = new DiscountOnTotalPromotion(300, 0.05);

        manager.addPromotion(promotion);
        assertEquals(1, manager.getPromotions().size());

        manager.removePromotion(promotion);
        assertEquals(0, manager.getPromotions().size());
    }

    @Test
    public void test5PercentDiscount() {
        // Case1)   5% discount for all products if order price > 300
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.addProduct("001", "Klawiatura", 280);
        shoppingCart1.addProduct("002", "Myszka", 180);
        shoppingCart1.applyPromotions();
        assertEquals(437, shoppingCart1.calculateTotalPrice(), 0.01);
    }

    @Test
    public void test3rdFree() {
        // Case2)   if 3 products in cart => 1 cheapest is free
        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.addProduct("001", "Laptop", 2000);
        shoppingCart2.addProduct("002", "Telefon", 1000);
        shoppingCart2.addProduct("003", "Sluchawki", 400);
        shoppingCart2.applyPromotions();
        assertEquals(0, shoppingCart2.getMin().getDiscountPrice());
    }

    @Test
    public void testFreeCup() {
        // Case3)   free cup if order price > 200
        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart3.addProduct("001", "Klawiatura", 180);
        shoppingCart3.addProduct("002", "Myszka", 80);
        shoppingCart3.applyPromotions();
        assertEquals("Firmowy kubek", shoppingCart3.getMin().getName());
    }

    @Test
    public void testVoucher() {
        // Case4)   voucher for special product with special deal (30% off)
        ShoppingCart shoppingCart4 = new ShoppingCart();
        shoppingCart4.addProduct("333", "Figurka z logiem firmy", 100);
        shoppingCart4.applyPromotions();
        Product promotedProduct = shoppingCart4.findProductByCode("333");
        assertNotNull(promotedProduct);
        assertEquals("Figurka z logiem firmy", promotedProduct.getName());
        assertEquals(70, promotedProduct.getDiscountPrice(), 0.01);
    }

}
