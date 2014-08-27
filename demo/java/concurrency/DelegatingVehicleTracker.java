package concurrency;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 委托
 * @author luliuyu
 *
 */
public class DelegatingVehicleTracker {

	private final ConcurrentMap<String,Point> locations ;
	private final Map<String,Point> unmodifiedMap;
	
	public DelegatingVehicleTracker(Map<String, Point> points) {
		
		this.locations = new ConcurrentHashMap<String,Point>(points);
		this.unmodifiedMap =  Collections.unmodifiableMap(locations);
	}
	
	public Map<String, Point> getLocations(){
		
		return unmodifiedMap;
	}
	
	public Point getLocation(String id){
		return locations.get(id);
	}
	
	public void setLocation(String id, int x, int y){
		
		if(locations.replace(id, new Point(x,y)) == null)
				throw new IllegalArgumentException("invalid vehicle name ：" + id);
	}
}
