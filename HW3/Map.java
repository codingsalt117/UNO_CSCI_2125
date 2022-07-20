/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *             Class makes a Map of MapEntrys
 * 			   Inner Class MapEntry constructs a MapEntry that contains a Key and Value
 * 
 */
import java.util.*;

public class Map<KeyType, ValueType>{

	private SeparateChainingHashTable<MapEntry<KeyType,ValueType>> elements;
	private int size = 0;// # of key value pairs
	//private int numbuckets; // cap

    /**
     * Constructor builds a map object using Class SeparateChainingHashingTable
     * 
     */
	public Map( ) {

		this.elements = new SeparateChainingHashTable<MapEntry<KeyType,ValueType>>();
		
	}
	/**
     * Method put takes a key and value, makes a MapEntry, then adds it to the Map object
     * @param key  KeyType -where it is stored
     * @param val  ValueType -what to store
     */
	public void put(KeyType key, ValueType val) {
		elements.insert(new MapEntry(key,val));
        size++;
	} 
	/**
     * Method get uses a key to find the data assopciated with said key
     * @param key used to locate associated value
     */
	public ValueType get(KeyType key){
		MapEntry<KeyType,ValueType> probe = new MapEntry<KeyType,ValueType>(key, null);
	    MapEntry<KeyType,ValueType> returnVal = elements.get(probe);
	    return returnVal.getValue();
	} 
	 /**
     * Method checks if a Map is empty
     * 
     */
	public boolean isEmpty( ){
		if( size == 0){
			return true;
		}
		else{
			return false;
		}
	} 
	/**
     * Method romoves all elements from the map
     * 
     */
	public void makeEmpty( ){
		if( !isEmpty()){
			this.makeEmpty();
		}
		else{
			return;
		}
	} 
    /**
     * Private Inner Class MapEntry
     * Creates MapEntry Objects <KeyType,ValueType>
     * 
     */	
	private static class MapEntry<KeyType, ValueType>{

		private KeyType key;
		private ValueType val;
	    /**
	     * Constructor builds a MapEntry object
	     * @param key KeyType
	     * @param value ValueType
	     */		
		public MapEntry(KeyType key, ValueType val){

			this.key = key;
			this.val = val;
		}
		/**
	     * Method returns KeyType key object
	     * 
	     */
		public KeyType getKey(){
			return this.key;
		}
		/**
	     * Method returns ValueType val object
	     * 
	     */
		public ValueType getValue(){
			return this.val;
		}
		/**
	     * Overridden equals method. Boolean return for the comparison of MapEntry Objects
	     * @param element Object
	     * 
	     */
		@Override
		public boolean equals(Object element){

			if (element instanceof MapEntry){
                
                if (this.getKey().equals(((MapEntry)element).getKey())){
                    return true;
                }
		    }
		    return false;
		}		
		/**
	     * Overridden hashcode method for hashing keys
	     * 
	     */
		@Override
		public int hashCode(){
			return this.key.hashCode();
		}
	
	} // end class MapEntry

} // end class Map
