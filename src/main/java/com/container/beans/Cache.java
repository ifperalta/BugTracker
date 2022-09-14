package com.container.beans;

import java.util.Date;

public class Cache <T> {
	
	private T obj;
	private java.util.Date d;
	private long timeToLeave;
	
	
	public Cache(T l, java.util.Date time, long t) {
		this.obj = l;
		this.d = time;
		this.timeToLeave = t;
	}
	
	public  T getCache() {
		long currentTime = new Date().getTime();
		long insertedTime = d.getTime();
		if(currentTime - insertedTime > timeToLeave*60000) {
			return obj;
		}
		else {
			return null;
		}
	}

}
