package interviewtasks;

import java.util.*;

/**
 * leetcode 380. Insert Delete GetRandom O(1)
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * <p>
 * * Your RandomizedSet object will be instantiated and called as such:
 * * RandomizedSet obj = new RandomizedSet();
 * * boolean param_1 = obj.insert(val);
 * * boolean param_2 = obj.remove(val);
 * * int param_3 = obj.getRandom();
 */

public class randomizedset {
    static abstract class RandomizedSet {

        public RandomizedSet() {


        }

        public boolean insert(int val) {


            return false;
        }

        public boolean remove(int val) {

            return false;
        }

        public int getRandom() {

            return 0;
        }

    }

    static class RandomizedSetHs extends RandomizedSet {
        HashSet<Integer> hs;

        public RandomizedSetHs() {
            hs = new HashSet<Integer>();

        }

        public boolean insert(int val) {
            return this.hs.add(val);


        }

        public boolean remove(int val) {
            return this.hs.remove(val);
        }

        public int getRandom() {

            int randInt = new java.util.SplittableRandom().nextInt(this.hs.size());
            List<Integer> list = new ArrayList<Integer>(hs);

            return list.get(randInt);
        }
    }

    static class RandomizedSetAl extends RandomizedSet {
        ArrayList<Object> al;

        public RandomizedSetAl() {
            al = new ArrayList<>();

        }

        public boolean insert(int val) {
            Object ob = val;
            if (al.contains(ob)) {
                return false;
            }
            al.add(ob);
            return true;


        }

        public boolean remove(int val) {
            Object ob = val;
            return al.remove(ob);

        }

        public int getRandom() {
            int randInt = new SplittableRandom().nextInt(this.al.size());
            return (int) this.al.get(randInt);
        }
    }

    static class RandomizedSetHsLessMem {
        HashSet<Integer> hs;

        public RandomizedSetHsLessMem() {
            hs = new HashSet<>();

        }

        public boolean insert(int val) {
            return this.hs.add(val);
        }

        public boolean remove(int val) {
            return this.hs.remove(val);
        }

        public int getRandom() {
            Iterator<Integer> it = this.hs.iterator();
            int retVal = 0;
            int randInt = new Random().nextInt(this.hs.size()) + 1;
            for (int i = 0; i != randInt; i++) {
                if (it.hasNext()) {
                    retVal = it.next();
                }
            }
            return retVal;
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSetHs();
        System.out.println("true: " + randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println("false: " + randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println("true: " + randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].

        System.out.println("1 || 2: "+randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println("true: " + randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println("false: " + randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println("2: " + randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.

        randomizedSet = new RandomizedSetAl();
        System.out.println("true: " + randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println("false: " + randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println("true: " + randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].

        System.out.println("1 || 2: "+randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println("true: " + randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println("false: " + randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println("2: " + randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.

    }

}
