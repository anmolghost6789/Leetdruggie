import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stack to find next greater elements
        Stack<Integer> helperStack = new Stack<>();

        // Store next greater element for nums2
        int[] nextGreaterElements = new int[nums2.length];

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            int element = nums2[i];

            // Remove all smaller or equal elements
            while (!helperStack.isEmpty() && helperStack.peek() <= element) {
                helperStack.pop();
            }

            // If stack is empty, no greater element
            if (helperStack.isEmpty()) {
                nextGreaterElements[i] = -1;
            } 
            else {
                // Top of stack is the next greater element
                nextGreaterElements[i] = helperStack.peek();
            }

            // Push current element
            helperStack.push(element);
        }

        // Answer for nums1
        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    answer[i] = nextGreaterElements[j];
                    break;
                }
            }
        }

        return answer;
    }
}