/*Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

0 <= s.length <= 3000
s consists of digits only. */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        dfs(s, result, "", 0, 12, 4);
        return result;
    }
    private void dfs(String s, List<String> result, String curr, int start, int max, int min) {
        if (s.length() - start > max || s.length() - start < min) {
            return;
        }
        if (max == 0 && start == s.length()) {
            result.add(curr.substring(1));
            return;
        }
        if (s.charAt(start) == '0') {
            dfs(s, result, curr + ".0", start + 1, max - 3, min - 1);
            return;
        }
        for (int i = 0; i < 3; i ++) {
            if (start + i + 1 <= s.length()) {
                int tmp = Integer.parseInt(s.substring(start, start + i + 1));
                if (tmp >=0 && tmp <= 255) {
                    dfs(s, result, curr + "." + tmp, start + i + 1, max - 3, min - 1);
                }
            }
        }

    }
}
