package JavaMarkt_koszyk_internetowy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    public void testAddProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("001", "Laptop", 2000);

        assertEquals(1, shoppingCart.getProducts().size());
        assertEquals("Laptop", shoppingCart.getProducts().get(0).getName());
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("001", "Laptop", 2000);
        shoppingCart.addProduct("002", "Telefon", 1200);
        shoppingCart.removeProduct("001");

        assertEquals(1, shoppingCart.getProducts().size());
        assertEquals("Telefon", shoppingCart.getProducts().get(0).getName());
    }

    @Test
    public void testTotalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("001", "Laptop", 2000);
        shoppingCart.addProduct("002", "Telefon", 1200);
        shoppingCart.addProduct("003", "Sluchawki", 300);

        assertEquals(3, shoppingCart.getProducts().size());
        assertEquals(3500, shoppingCart.calculateTotalPrice());
    }
}