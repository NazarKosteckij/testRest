package com.test.rest.utils.tokens;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TokenCacheImpl implements TokenCache{

	private final long ttl;
	
	private TokenCacheImpl(long ttl){
		this.ttl = ttl;
	}
	
	private TokenCacheImpl(){
		this.ttl = DEFAULT_TIME_TO_LIVE;
	}

	private long lastCleaningTime = System.currentTimeMillis();
	static HashMap<Long, String> keys = new HashMap<Long, String>();

	public void addToken(String key) {
		Long timeWhenAdded = System.currentTimeMillis();
		keys.put(timeWhenAdded, key);
	}
	
	public boolean isValid(String key) {
		System.out.println("time (ms) = tokens in memory :" + keys);
		checkExpire();
		if (keys.containsValue(key))
				return true;
			else
				return false;
	}
	
	private void checkExpire() {
		if (System.currentTimeMillis() - lastCleaningTime >= ttl) {
			System.out.println("cheking expire of tokens");
			Set<Long> allTime = keys.keySet();
			Set<Long> toRemove = new HashSet<Long>();
			
			for(Long time: allTime){
				if(System.currentTimeMillis()-time>=ttl){
					toRemove.add(time);
				}
			}
			deleteKeyData(toRemove);
			lastCleaningTime = System.currentTimeMillis();
		}
		
	}
	
	private void deleteKeyData(Set<Long> time) {
		Iterator<Long> it = time.iterator();
		while (it.hasNext()) {
			 Long item = it.next();
			 keys.remove(item);
		}
	}
	

}
