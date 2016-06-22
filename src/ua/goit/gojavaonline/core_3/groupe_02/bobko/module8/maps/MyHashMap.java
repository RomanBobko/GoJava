package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyHashMap<K, V> implements MyMap<K, V>, Iterable<MyHashMap.Node>, Iterator<MyHashMap.Node> {

    private Node<K, V>[] table;
    private int size;
    private final int MAX_CAPACITY = Integer.MAX_VALUE / 2;
    private Node<K, V> currentNode = null;
    private int currentIndex = 0;

    class Node<K, V> implements MyMap.Entry{

        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }

        @Override
        public Object setValue(Object value) {
            Object oldValue = this.value;
            this.value = (V) value;
            return oldValue;
        }

    }

    MyHashMap(){
        table = new Node[25];
    }

    MyHashMap(int capacity){
        if (capacity > MAX_CAPACITY){
            throw new ExceptionInInitializerError("Max capacity = " + MAX_CAPACITY);
        }else if (capacity <= 0){
            throw new ExceptionInInitializerError("Min capacity = 1");
        }
        table = new Node[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Node node : this){
            if (key == null){
                if (node.key == null){
                    return true;
                }
            }else{
                if (key.equals(node.key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node node : this){
            if (value.equals(node.value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Node<K, V> node : this){
            if (key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {

        if (key == null){
            Node node = indexContainsNode(0, key);
            if (node != null){
                node.setValue(value);
            }else{
                addNode(0, key, value, 0);
            }
        }else{
            int hash = key.hashCode();
            int index = indexFor(hash);
            Node node = indexContainsNode(index, key);
            if (node != null){
                node.setValue(value);
            }else{
                addNode(hash, key, value, index);
            }
        }

        return value;
    }

    private void addNode(int hash, K key, V value, int index) {
        Node<K, V> oldNode = table[index];
        Node<K, V> newNode = new Node<>(hash, key, value, oldNode);
        table[index] = newNode;
        size++;
    }

    private Node<K, V> indexContainsNode(int index, K key){
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        V removeValue = null;
        for (int i = 0; i < table.length; i++){
            if(table[i] == null){
                continue;
            }
            if ((key == null && table[i].getKey() == key) || table[i].getKey().equals(key)){
                removeValue = (V)table[i].getValue();
                if (table[i].next == null){
                    table[i] = null;
                }else{
                    table[i] = table[i].next;
                }
                size--;
                return removeValue;
            }else{
                Node previusNode = table[i];
                Node removeNode = table[i].next;
                while (removeNode != null){
                    if ((key == null && removeNode.getKey() == key) || removeNode.getKey().equals(key)){
                        removeValue = (V)removeNode.getValue();
                        previusNode.next = removeNode.next;
                        size--;
                        return removeValue;
                    }
                    previusNode = removeNode;
                    removeNode = removeNode.next;
                }
            }

        }
        return removeValue;
    }

    @Override
    public void clear() {
        table = new Node[table.length];
        size = 0;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for (Node<K, V> node : this){
            list.add((V)node.getValue());
        }
        return list;
    }

    @Override
    public Iterator<Node> iterator() {
        currentNode = null;
        currentIndex = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        if (findNextNode() != null){
            return true;
        }
        return false;
    }

    @Override
    public Node next() {
        return currentNode;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        int i = 0;
        for (Node<K, V> node : this){
            buffer.append(node.getKey());
            buffer.append(" = ");
            buffer.append(node.getValue());
            if (i++ < size-1){
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    private int indexFor(int hash){
        return  hash & (table.length-1);
    }

    private Node<K, V> findNextNode(){
        if (currentNode != null && currentNode.next != null){
            currentNode = currentNode.next;
            return currentNode;
        }
        for (int i = currentIndex; i < table.length; i++){
            if (table[i] != null){
                currentNode = table[i];
                currentIndex = ++i;
                return currentNode;
            }
        }
        return null;
    }



}
