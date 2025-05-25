/**
 * Time Complexity: O(2*n)
 * Space Complexity: O(n)
 */
class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> myStack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for(int i=0; i< 2* nums.length; i++){
            while(!myStack.isEmpty() && nums[myStack.peek()] < nums[i % nums.length]){
                int poppedIndex = myStack.pop();
                res[poppedIndex] = nums[i % nums.length];
            }
            if(i < nums.length)
                myStack.add(i);
        }
        return res;
    }
}