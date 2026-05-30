package Listener_Codes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Cases {

    @Test
    public void test1() {
        System.out.println("Test case execution");
    }

    @Test
    public void test2() {
        Assert.fail();
    }
}