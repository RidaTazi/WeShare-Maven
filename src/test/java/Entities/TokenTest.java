package Entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {
    @Test
    public void testTokenGeneration() throws Exception{
        Token token = new Token();
        String result = token.generateToken("abdelwadoud","abcdefgh");

        //I'll add it later
        assertEquals("",result);
    }
}
