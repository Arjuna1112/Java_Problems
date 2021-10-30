package com.nestedclass.impl;

import java.util.HashMap;
import java.util.Map;

/*The benefits of Java nested classes are that you can group classes together that belong together. You could do so already 
 * by putting them in the same package, but putting one class inside another makes an even stronger grouping.

A nested class is typically only used by or with its enclosing class. Sometimes a nested class is only visible to the enclosing 
class, is only used internally, and is thus never visible outside the enclosing class. Other times the nested class is visible 
outside its enclosing class, but can only be used in conjunction with the enclosing class.

An example would be a Cache class. Inside the Cache class you might declare a CacheEntry class which can contain information 
about a specific cache entry (cached value, time inserted, number of times accessed etc.). Users of the Cache class may never 
see the CacheEntry class, if they have no need to obtain information about the CacheEntry itself, but only the cached value. 
However, the Cache class may choose to make the CacheEntry class visible to the outside world, so they can access more than 
just the cached value (for instance information about when the value was last refreshed etc.)
 * 
 * */

public class NestedClassBenefits {

	    private Map<String, CacheEntry> cacheMap = new HashMap<String, CacheEntry>();

	    public class CacheEntry {
	        public long   timeInserted = 0;
	        public Object value        = null;
	    }

	    public void store(String key, Object value){
	        CacheEntry entry = new CacheEntry();
	        entry.value = value;
	        entry.timeInserted = System.currentTimeMillis();
	        this.cacheMap.put(key, entry);
	    }

	    public Object get(String key) {
	        CacheEntry entry = this.cacheMap.get(key);
	        if(entry == null) return null;
	        return entry.value;
	    }

	    public CacheEntry getCacheEntry(String key) {
	        return this.cacheMap.get(key);
	        }

	}
