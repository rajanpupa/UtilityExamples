package caching;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Rajan Upadhyay
 *
 */
public class EncryptionUtil {
	
	private static Cache<String, String> cache = new Cache<String, String>(10);
	
	public static void main(String[] args) {
		
		String sridhar = "Sridhar";
		String eSridhar = EncryptionUtil.encrypt(sridhar);
		
		String sridhar2 = "Sridhar";
		EncryptionUtil.encrypt(sridhar2);
		
		String Amin = "Amin";
		String eAmin = EncryptionUtil.encrypt(Amin);
		
		String dAmin = EncryptionUtil.decrypt(eAmin);
		
		String ilAn = "ilAn";
		String dilAn = EncryptionUtil.decrypt(ilAn);
	}
	
	public static String encrypt(String name){
		System.out.println("encrypting " + name);
		String value = cache.searchInCache(name);
		if(value !=null){
			System.out.println(String.format("%s found in cache", name));
		}else{
			System.out.println("adding to cache");
			value = encAltorithm(name);
			cache.addToCache(name, value);
			cache.addToCache(value, name);
		}
		System.out.println("result = " + value);
		System.out.println();
		return value;
	}
	
	private static String encAltorithm(String name) {
		String arg = name.length()%2==0 ? name:name + '#';
		int len = arg.length();
		String encStr;
		
		encStr = arg.substring(len/2) + arg.substring(0, len/2);
		return encStr;
	}

	public static String decrypt(String eName){
		System.out.println("decrypting " + eName);
		String res = cache.searchInCache(eName);
		if(res != null){
			System.out.println(eName + " found in cache");
		}else{
			System.out.println("adding to cache");
			res = decAlgorithm(eName);
			cache.addToCache(eName, res);
			cache.addToCache(res, eName);
		}
		
		System.out.println("result = " + res);
		System.out.println();
		return res;
		
	}

	private static String decAlgorithm(String eName) {
		String res;
		StringBuilder decStr = new StringBuilder();
		int len = eName.length();
		decStr.append(eName.substring(len/2)).append( eName.substring(0, len/2));
		
		if(decStr.charAt(len-1)=='#'){
			decStr.deleteCharAt(len-1);
		}
		res = decStr.toString();
		return res;
	}
	
	static class Cache<K,T> {
		private Map<K,T> map ;//= new LinkedHashMap<K,T>();
		
		private Integer MAX_SIZE = 5;
		
		public Cache(){
			initializeMap();
		}
		public Cache(Integer maxSize){
			this.MAX_SIZE = maxSize;
			initializeMap();
		}
		
		private void initializeMap(){
			// true means elements will be stored in the order of access
			map = new LinkedHashMap<K,T>(MAX_SIZE + 1, 1, true ){
				@Override
				protected boolean removeEldestEntry(final Map.Entry eldest){
					return size() > MAX_SIZE;
				}
			};
		}
		
		public void addToCache(K key, T value){
				map.put(key, value);
		}
		public T searchInCache(K key){
			return map.get(key);
		}
	}// cache class
	
	

}
