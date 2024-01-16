package dsa;

import java.util.LinkedList;

public class HashTable<Key,Value> {
final int TABLE_LENGTH=10;
public LinkedList<Object>[] table;
	
public HashTable() {
	// Every bucket is getting turned into a linked list
	table = new LinkedList [TABLE_LENGTH];
	for (int i=0;i<TABLE_LENGTH;i++) {
		table[i] = new LinkedList<>();
    }	
}
public int hashCode (Key theKey) {
	//all Keys are getting their key
	return theKey.hashCode()%TABLE_LENGTH;
}

public boolean checkCollision(int index) {
	//if the linked list is greater than one then there is a collision 
	return table[index].size() > 1;
}

public void addLinkedList(int index, Object entry){
	
	table[index].add(entry);

}

public void insert(Key key,Value value) {
	   int index = hashCode(key);
	   
	   // Bucket for index of key
       LinkedList<Object> bucket = table[index];

       for (Object obj : bucket) {
           Object[] input = (Object[]) obj;
           if (input[0].equals(key)) {
               // if there is a matching key the new value replaces the old 
        	   input[1] = value;
               return;
           }
       }

       // If the key is new, check if there are any collisions 
       if (checkCollision(index)) {
           // if a collision is detected, then add to the linked list
    	   addLinkedList(index, new Object[]{key, value});
       } else {
           // If there is no collision, then add a new entry
           bucket.add(new Object[]{key, value});
       }
}



public void delete(Key key) {
    int index = hashCode(key);
    LinkedList<Object> bucket = table[index];
    // The lambda expression removes the input if it exists 
    bucket.removeIf(input -> ((Object[]) input)[0].equals(key));
}

public Value get(Key key) {
    int index = hashCode(key);
    LinkedList<Object> bucket = table[index];
//if the key exists, then it will output the value 
    for (Object input : bucket) {
        Object[] entry = (Object[]) input;
        if (entry[0].equals(key)) {
            return (Value) entry[1];
        }
    }
   //if the key does not exist, then it will return a null value 
    return null; 
}


	
	
public static void main(String[] args) {
	HashTable hash_table = new HashTable();

			hash_table.insert("name", "John");
			hash_table.insert("age", 25);
			hash_table.insert("city", "New York");

			System.out.println(	hash_table.get("name") );
			System.out.println(	hash_table.get("age"))  ;
			System.out.println(	hash_table.get("city")) ;
			hash_table.delete("age");
			System.out.println(	hash_table.get("age")) ;

	}
}
