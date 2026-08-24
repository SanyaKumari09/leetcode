class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // Count student preferences: index 0 for type 0, index 1 for type 1
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        
        // Iterate through the sandwiches stack
        for (int sandwich : sandwiches) {
            // If no student wants the current sandwich type
            if (count[sandwich] == 0) {
                // The number of remaining students who want the other sandwich type
                return count[sandwich ^ 1];
            }
            // A student takes the sandwich, so we reduce the count for this type
            count[sandwich]--;
        }
        
        // All students get a sandwich
        return 0;
    }
}
