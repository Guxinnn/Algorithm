package DataStructure;

import java.util.ArrayList;
/**
 * Created by Doodle on 9/23/17.
 */
public class Map<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;

    //current capacity
    private int numBuckets;

    //current size
    private int size;

    public Map() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // hash function to find index for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    // Method to remove a given a key
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        while(head != null) {
            if(head.key.equals(key)) break;
            prev = head;
            head = head.next;
        }

        if (head == null) return null;
        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }

        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while(head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // check if key is alread present
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // check the load factor
        if (1.0 * size / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> tmp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;

            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }

            for (HashNode<K, V> headNode : tmp) {
                while(headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
