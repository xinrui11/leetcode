package PalindromeNumber;

import junit.framework.TestCase;
import org.junit.Test;

public class PalindromeNumberTest extends TestCase {
    @Test
    public void testisPalindrome() throws Exception {
        PalindromeNumber p = new PalindromeNumber();
        System.out.print(p.isPalindrome(12321));
    }

    @Test
    public void testisPalindromeHighestVoted() throws Exception {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindromeHighestVoted(12321));
        System.out.println(p.isPalindromeHighestVoted(1232111));
    }

}