package Stack.简化路径;

import java.util.Stack;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * <p>
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * 边界情况:
 * <p>
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
class Solution {
    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push("/" + arr[i]);
                    break;
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.."));
    }
}
