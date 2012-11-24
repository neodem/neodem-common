package com.neodem.common.utility;

import java.util.HashMap;
import java.util.Map;

public class Collections {

	public static <K, V> Map<K, V> copyMap(Map<K,V> from){
		Map<K, V> copy = new HashMap<K, V>(from.size());
		for(K key : from.keySet()) {
			copy.put(key, from.get(key));
		}
		return copy;
	}
}
