package test;

import com.company.item_used.Item;
import com.company.item_used.ItemFactory;
import com.company.item_used.ItemUnitPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItFactoryTest {
    @Test
    public void testGetItem(){//effettuare sostituzione già citata in ItemCompTest
        ItemFactory it = new ItemFactory();
        ItemUnitPrice i = new ItemUnitPrice("nome",1,1);
        Item i2 = it.getItem("UI");
        Assertions.assertEquals(i.getClass(),i2.getClass());
    }
}
