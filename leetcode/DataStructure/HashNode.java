package DataStructure;

/**
 * Created by Doodle on 9/23/17.
 */
public class HashNode<K, V> {

    K key;
    V value;

    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
