package JavaMarkt_koszyk_internetowy;

import java.util.Comparator;
import java.util.List;

public class SortManager implements SorterInterface {

    @Override
    public void sort(List<Product> products, String keyValue) {
        if (keyValue.equals("price")) {
            products.sort(Comparator.comparingDouble(Product::getPrice));
        } else if (keyValue.equals("name")) {
            products.sort(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
        }
    }

    @Override
    public void sort(List<Product> products, String keyValue, String keyValue2) {
        Comparator<Product> comparator = null;

        if (keyValue.equals("price")) {
            comparator = Comparator.comparingDouble(Product::getPrice);
        } else if (keyValue.equals("name")) {
            comparator = Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);
        }

        if (comparator != null) {
            if (keyValue2.equals("price")) {
                comparator = comparator.thenComparing(Comparator.comparingDouble(Product::getPrice));
            } else if (keyValue2.equals("name")) {
                comparator = comparator.thenComparing(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
            }

            products.sort(comparator);
        }
    }

    @Override
    public Product minimal(List<Product> products) {
        return products.stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    @Override
    public List<Product> minimal(List<Product> products, int n) {
        return products.stream()
                .sorted(Comparator.naturalOrder())
                .limit(n)
                .toList();
    }

    @Override
    public Product maximal(List<Product> products) {
        return products.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    @Override
    public List<Product> maximal(List<Product> products, int n) {
        return products.stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .toList();
    }
}
