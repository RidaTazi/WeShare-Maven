package Entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {
    @Test
    public void testTokenGeneration() throws Exception{
        Token token = new Token();
        String result = token.generateToken("abdelwadoud","abcdefgh");

        //I'll add it later
        assertEquals("1de0c2565ff335de90c9a0ee4df74efe409d9d1cc6f9977084cef5633126814c",result);
    }
}
