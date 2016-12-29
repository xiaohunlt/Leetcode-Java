package com.inuker.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LetterCombinationOfPhoneNumber {

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // 耗时3ms
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0) {
            return result;
        }
        helper(digits, 0, result, new StringBuilder());
        return result;
    }

    private void helper(String digit, int start, List<String> path, StringBuilder sb) {
        if (start == digit.length()) {
            path.add(sb.toString());
            return;
        }

        int n = digit.charAt(start) - '0';
        for (char c : ARR[n].toCharArray()) {
            sb.append(c);
            helper(digit, start + 1, path, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
