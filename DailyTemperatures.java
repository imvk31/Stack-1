/*
 * Brute Force
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int []res = new int[temperatures.length];
        int n = temperatures.length;
        boolean found = false;
        for(int i=0; i<n; i++){
            int j= i+1;
            int count = 0;
            while(j < n){
                count++;
                if(temperatures[j] > temperatures[i]){
                    res[i] = count;
                    found = true;
                    break;
                }
                j++;
            }
            if(!found){
                res[i] = 0;
            }
        }
        return res;
    }
}

/*
 * Using a Stack
 * Time Complexity: O(2n): One n for Adding to stack and Other for resolving Stack.
 * Space Complexity: O(n): Adding n elements into Stack. We cannot add res[] because it is a part of Result.
 */

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> myStack = new Stack<>();
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            while(!myStack.isEmpty() && temperatures[myStack.peek()] < temperatures[i]){
                int popIndex = myStack.pop();
                res[popIndex] = i- popIndex;
            }
            myStack.add(i);
        }
    return res;
    }
}