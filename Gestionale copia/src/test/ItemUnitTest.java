package test;

import com.company.item_used.ItemUnitPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemUnitTest {
    @Test//only to execute switching comments with 2 lines upper
    public void testCreateDimension(){
        ItemUnitPrice ob1 = new ItemUnitPrice( "name",12,4);
        ItemUnitPrice ob2 = new ItemUnitPrice();
        Assertions.assertEquals(ob1.getDimension(),ob2.getDimension());
    }
}
