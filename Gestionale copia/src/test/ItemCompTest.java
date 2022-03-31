package test;

import com.company.item_used.ItemComplessivePrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemCompTest {
    @Test//only to execute switching comments with 2 lines upper
    public void testCreateC(){
        ItemComplessivePrice ob1 = new ItemComplessivePrice( "name",2);
        ItemComplessivePrice ob2 = new ItemComplessivePrice();
        Assertions.assertEquals(ob1.getPrice(),ob2.getPrice());
    }
}


