package group5.yatzy;


/*
* Entry är en klass som representerar
* en avbildning med en nyckel och ett värde.
*/
	public class Entry<K,V>
	{
		protected K key;
		protected V value;

		
		/*
		 * Konstruktorn tar in en nyckel och
		 * ett värde.
		 */
		public Entry (K k,V v)
		{
			key = k;
			value = v;
		}
		
		/*
		 * Returnerar nyckeln för avbildningen.
		 */
		public K getKey()
		{
			return key;
		}
		
		/*
		 * Returnerar värdet för avbildningen.
		 */ 
		public V getValue()
		{
			return value;
		}
		

		/*
		 * Sätter avbildningens värde.
		 */ 
		public void setValue(V v)
		{
			this.value = v;
		}
		
		/*
		 * Returnerar en strängrepresentation av klassen.
		 */
		public String toString()
		{
			return key + " " + value;
		}
	}
