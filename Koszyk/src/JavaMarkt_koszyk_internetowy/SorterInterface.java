package JavaMarkt_koszyk_internetowy;

import java.util.List;

public interface SorterInterface {
    void sort(List<Product> products, String keyValue);
    void sort(List<Product> products, String keyValue, String keyValue2);
    Product minimal(List<Product> products);
    List<Product> minimal(List<Product> products, int n);
    Product maximal(List<Product> products);
    List<Product> maximal(List<Product> products, int n);
}
