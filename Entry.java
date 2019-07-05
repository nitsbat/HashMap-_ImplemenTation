// Entry Class contains the actual key-value pair

public class Entry {
	
       final String key;
       String value;
       Entry next;

       public Entry(String key, String value, Entry next) {

              this.key = key;
              this.value = value;
              this.next = next;
       }

       public String getKey() {
              return this.key;
       }      

       public String getValue() {
              return this.value;
       }
   
       public void printEntry() {
              System.out.println("Key - "+this.key+"\nValue - "+this.value+"\nNext - "+this.next);
       }
       
       public boolean equals(Object obj) {
        
              if(obj == this) return true;        
              
              if(obj instanceof Entry) {
            	  Entry entry = (Entry) obj;
            	  return key.equals(entry.getKey()) && value.equals(entry.getValue());
              }
              return false;
       }

       // Hashcode Function is user-made hashcode which is very simple in this case.
       public int HashCode() {
             
    	   int hash = 19;
    	   int sum = 0;
    	   for (int i = 0; i < key.length(); i++) {
    		   
    		   char c = key.charAt(i);
    		   int tmp = (int)(c) * 13;
    		   sum += tmp ;
    	   }
           hash = 21 * hash + sum;
           return hash;
       }

}