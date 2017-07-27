package LetterCombinationsofaPhoneNumber;

import junit.framework.TestCase;
import org.junit.Test;

public class LetterCombinationsofaPhoneNumberTest extends TestCase {
    @Test
    public void testletterCombinations() throws Exception {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations("234"));
    }

}