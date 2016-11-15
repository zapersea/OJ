package com.zaper.sea.leet;
import com.zaper.sea.river.other.RandomizedCollection;
/**
 * Created by Zaper Ocean on 2016/10/18.
 */
public class Leet381 {
    public static void main(String[] args){
        // Init an empty collection.
        RandomizedCollection collection = new RandomizedCollection();

        // Inserts 1 to the collection. Returns true as the collection did not contain 1.
        System.out.println(collection.insert(1));

        // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
        System.out.println(collection.insert(1));

        // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
        System.out.println(collection.insert(2));

        // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
        System.out.println( collection.getRandom());

        // Removes 1 from the collection, returns true. Collection now contains [1,2].
        System.out.println(collection.remove(1));

        // getRandom should return 1 and 2 both equally likely.
        System.out.println(collection.getRandom());
    }
}
