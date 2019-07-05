//MyMap class is user-define HashMap() class with same functionalities as of the Java HashMap() method.

import java.util.*;
public class MyMap {

            int n = 15; // Size of the HashTable
            ArrayList<Entry> arrtmp = new ArrayList<Entry>(15); // HashTable is made using ArrayList. It is made of Entry objects.

            // MyMap Constructor.. The buckets are made null to have a comparison later in get() function.
            public MyMap() {
            	for (int i = 0; i < 15; i++) {
            		arrtmp.add(i,null);
            	}
            }
            
            // printArr() function is just used to check how the ArrayList will looks like. It just contains the Address of Entry objects.
            public void printArr() {
            	System.out.println(arrtmp);
            }
            
            
            // printList() is just to show the linked list attached to a particular index or hash.
            public void printList(int index) {
            	Entry tmp  = arrtmp.get(index);
        		while(tmp != null) {
        				tmp.printEntry();
        				System.out.println("\n");
        				tmp = tmp.next;
        		}
            }
            
            //put() function will add the entry object to the ArrayList
            public void put(String key , String value) {
                        
            	Entry entry = new Entry(key,value,null);
            	int hash = entry.HashCode() % n; // hash is the index where we will put our input.
            	
            	//System.out.println(entry.getKey()+" : "+hash); // This is basically done for printing the hash number
            	
            	if(arrtmp.get(hash) != null) {
            		
            		Entry tmp  = arrtmp.get(hash);
            		while(tmp.next != null) {
            				tmp = tmp.next;
            		}
            		tmp.next = entry;
            	
            	}
                else {
                	
                	arrtmp.remove(hash);
                	arrtmp.add(hash, entry);
                
                }
            }
            
            //Get function should retrieve the Entry object by only key.
            public void get(String key) {
            	
            	Entry entry = new Entry(key,null,null);
            	int ha = entry.HashCode() % n;
            	Entry tmp = arrtmp.get(ha);
            	
            	while(tmp != null) {
            		if(tmp.key == key) {
            			tmp.printEntry();
                       	break;
            		}
            	
            		tmp = tmp.next;
            	}
            	
            }
}