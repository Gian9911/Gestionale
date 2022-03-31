package test;

import com.company.item_used.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTest {
    @Test
    public void testDataMinus0(){
        Data data = new Data(30,3,2020);//anni diversi T
        Data data1 = new Data(30,1,2022);
        Assertions.assertTrue(data.minus(data1));
    }
    @Test
    public void testDataMinus1(){
        Data data = new Data(30,2,2025);//anni diversi F
        Data data1 = new Data(30,2,2020);
        Assertions.assertFalse(data.minus(data1));
    }
    @Test
    public void testDataMinus2(){
        Data data = new Data(3,1,2022);//giorni diversi t
        Data data1 = new Data(4,1,2022);
        Assertions.assertTrue(data.minus(data1));
    }
    @Test
    public void testDataMinus3(){
        Data data = new Data(5,2,2020);//giorni diversi f
        Data data1 = new Data(3,2,2020);
        Assertions.assertFalse(data.minus(data1));
    }
    @Test
    public void testDataMinus4(){
        Data data = new Data(30,1,2020);//mesi diversi t
        Data data1 = new Data(30,3,2020);
        Assertions.assertTrue(data.minus(data1));
    }
    @Test
    public void testDataMinus5(){
        Data data = new Data(16,11,2009);//mesi diversi f
        Data data1 = new Data(30,5,2010);
        Assertions.assertTrue(data.minus(data1));
    }
    @Test
    public void testDataMinus6(){
        Data data = new Data(1,2,2020);//misto t
        Data data1 = new Data(17,3,2022);
        Assertions.assertTrue(data.minus(data1));
    }
    @Test
    public void testCheck1(){
        Data data = new Data(1,1,2511);
        Assertions.assertFalse(data.check());
    }
    @Test
    public void testCheck2(){
        Data data = new Data(1,13,2011);
        Assertions.assertFalse(data.check());
    }
    @Test
    public void testCheck3(){
        Data data = new Data(30,2,2020);
        Assertions.assertFalse(data.check());
    }
    @Test
    public void testCheck4(){
        Data data = new Data(29,2,2021);
        Assertions.assertFalse(data.check());
    }
    @Test
    public void testCheck5(){
        Data data = new Data(31,6,2021);
        Assertions.assertFalse(data.check());
    }
    @Test
    public void testCheck6(){
        Data data = new Data(5,6,2021);
        Assertions.assertFalse(data.check());
    }
}
