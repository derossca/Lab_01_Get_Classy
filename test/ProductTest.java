import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("000001", "Pipeweed","Long Bottom Leaf",600.0);
    }

    @Test
    void setID() {
        assertEquals("000001", product.getID());
    }

    @Test
    void setName() {
        assertEquals("Pipeweed", product.getName());
    }

    @Test
    void setDescript() {
        assertEquals("Long Bottom Leaf", product.getDescript());
    }

    @Test
    void setCost() {
        assertEquals(600.0, product.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001,Pipeweed,Long Bottom Leaf,600.0", product.toCSVDataRecord());

    }

    @Test
    void testToString() {
        assertEquals("Product{ID='000001', name='Pipeweed', descript='Long Bottom Leaf', cost=600.0}", product.toString());

    }
}