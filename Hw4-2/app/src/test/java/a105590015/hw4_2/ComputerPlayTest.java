package a105590015.hw4_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by hjki3 on 4/2/2018.
 */

public class ComputerPlayTest {
    private ComputerPlay cp;
    @Before public void setUp(){
        cp=new ComputerPlay();
    }
    @After public void tearDown(){
        cp=null;
    }
    @Test
    public void testGetPlay(){
        assertEquals("贏", cp.getPlay(1,3));
        assertEquals("輸", cp.getPlay(1,2));
        assertEquals("平", cp.getPlay(1,1));
        assertEquals("贏", cp.getPlay(2,1));
        assertEquals("輸", cp.getPlay(2,3));
        assertEquals("平", cp.getPlay(2,2));
        assertEquals("贏", cp.getPlay(3,2));
        assertEquals("輸", cp.getPlay(3,1));
        assertEquals("平", cp.getPlay(3,3));
    }
}
