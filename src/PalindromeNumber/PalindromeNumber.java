package PalindromeNumber;

/**
 Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */
public class PalindromeNumber {
    //不用在意溢出问题，因为如果是回文一定不会溢出，会溢出的一定不是回文
    public boolean isPalindrome(int x) {
        if(x < 0){//所有负数都不算回文
            return false;
        }
        int r = 0;
        int temp = x;
        while(temp != 0){
            r = r * 10+(temp % 10);
            temp = temp / 10;
        }
        return r == x;
    }

    //得票最高的解法，只比较了数字的一半
    public boolean isPalindromeHighestVoted(int x) {
        //小于0或者末尾是0的一定不是回文
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int temp = 0;
        while(x > temp){
            temp = temp * 10 + x % 10;
            x = x/10;
        }
        return (x == temp || x == temp /10);
        //如果位数为偶数两者相等，如果位数是奇数，x==rev/10

    }
}
