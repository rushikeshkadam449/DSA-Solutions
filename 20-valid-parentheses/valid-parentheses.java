class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
                continue;
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (isCorrect(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isOpening(char s1) {
        if (s1 == '(' || s1 == '{' || s1 == '[') {
            return true;
        }
        return false;
    }

    public boolean isCorrect(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        return false;
    }
}