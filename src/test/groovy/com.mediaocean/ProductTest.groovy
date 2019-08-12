import com.mediaocean.cart.model.Cart
import com.mediaocean.product.model.CategoryA
import com.mediaocean.product.model.CategoryB
import com.mediaocean.product.model.CategoryC
import com.mediaocean.product.model.Product
import spock.lang.Specification

class ProductTest extends Specification {

    def "should return total bill amount"() {
        given:
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId(1)
        product1.setName("Product1")
        product1.setCategory(new CategoryA())
        product1.setPrice(100)

        Product product2 = new Product();
        product2.setProductId(2)
        product2.setName("Product2")
        product2.setCategory(new CategoryB())
        product2.setPrice(100)

        Product product3 = new Product();
        product3.setProductId(3)
        product3.setName("Product3")
        product3.setCategory(new CategoryC())
        product3.setPrice(100)

        products.add(product1)
        products.add(product2)
        products.add(product3)

        Cart cart = new Cart()
        cart.setProducts(products)

        when:
        double amount = cart.getTotalCost()

        then:
        assert amount
    }
}