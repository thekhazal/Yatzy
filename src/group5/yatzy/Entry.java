package group5.yatzy;


/**
 * @author Emma Bogren
* Entry is a class which represents an
* entry with key and a value.
*/
	public class Entry<K,V>
	{
		protected K key;
		protected V value;

		/**
		 * Constructor takes a key and a value.
		 */
		public Entry (K k,V v)
		{
			key = k;
			value = v;
		}
		
		/**
		 * Returns the key of the entry.
		 */
		public K getKey()
		{
			return key;
		}
		
		/**
		 * Returns the value of the entry. 
		 */ 
		public V getValue()
		{
			return value;
		}
		
		/**
		 * Sets the value of the entry to v.
		 */ 
		public void setValue(V v)
		{
			this.value = v;
		}

		/**
		 * Sets the key of the entry to k.
		 */ 
		public void setKey(K k)
		{
			this.key = k;
		}
		
		/**
		 * Returns a String representation of the entry.
		 */
		public String toString()
		{
			return key + " " + value;
		}
	}
