package JavaMarkt_koszyk_internetowy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SortManagerTest {

    @Test
    public void testSortByName() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("003", "Banana", 1.99));
        products.add(new Product("001", "Apple", 1.50));
        products.add(new Product("002", "Cherry", 2.99));

        SortManager sorter = new SortManager();
        sorter.sort(products, "name");

        assertEquals("Apple", products.get(0).getName());
        assertEquals("Banana", products.get(1).getName());
    }

    @Test
    public void testSortByPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("003", "Banana", 1.99));
        products.add(new Product("001", "Apple", 1.50));
        products.add(new Product("002", "Cherry", 2.99));

        SortManager sorter = new SortManager();
        sorter.sort(products, "price");

        assertEquals(1.50, products.get(0).getPrice());
        assertEquals(1.99, products.get(1).getPrice());
    }

    @Test
    public void testMinimalProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("003", "Banana", 1.99));
        products.add(new Product("001", "Apple", 1.50));

        SortManager sorter = new SortManager();
        Product min = sorter.minimal(products);

        assertEquals("Apple", min.getName());
        assertEquals(1.50, min.getPrice());
    }

    @Test
    public void testSortingWithTwoKeys() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("001", "Laptop", 2000));
        products.add(new Product("002", "aTelefon", 1000));
        products.add(new Product("003", "Sluchawki", 1000));

        SortManager sorter = new SortManager();
        sorter.sort(products, "price", "name");

        assertEquals(3, products.size());
        assertEquals("aTelefon", products.getFirst().getName());
    }

    @Test
    public void testMinMaxValues() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("001", "Laptop", 2000));
        products.add(new Product("002", "Telefon", 1000));
        products.add(new Product("003", "Sluchawki", 400));
        products.add(new Product("004", "Wiadro", 10));
        products.add(new Product("005", "Kanapa", 3000));
        products.add(new Product("006", "Wanna", 3300));

        SortManager sorter = new SortManager();
        Product min = sorter.minimal(products);
        List<Product> minList = sorter.minimal(products, 2);
        Product max = sorter.maximal(products);
        List<Product> maxList = sorter.maximal(products, 3);

        assertEquals(6, products.size());
        assertEquals("Wiadro", min.getName());
        assertEquals("Wiadro", minList.get(0).getName());
        assertEquals("Sluchawki", minList.get(1).getName());
        assertEquals("Wanna", max.getName());
        assertEquals("Wanna", maxList.get(0).getName());
        assertEquals("Kanapa", maxList.get(1).getName());
        assertEquals("Laptop", maxList.get(2).getName());
    }
}