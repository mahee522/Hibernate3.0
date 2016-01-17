package com.ibm.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor {
	// This method is called when Emp object is deleted.
	public void onDelete(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types) {
		if ( entity instanceof Emp ) System.out.println(">>>>>Delete Operation");}
	
	// This method is called when Emp object gets updated.
	public boolean onFlushDirty(Object entity,Serializable id,Object[] currentState,Object[] previousState,String[] propertyNames,Type[] types) {
		if ( entity instanceof Emp ) { System.out.println(">>>>>Update Operation"); return true; }
		return false;}
	
	public boolean onLoad(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types) {
		return true; 	}
	
	// This method is called when Emp object gets created.
	public boolean onSave(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types) {
		if ( entity instanceof Emp ) { System.out.println(">>>>>Create Operation"); return true; }
		return false; 	}
	
	//called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println(">>>>>preFlush"); }
	
	//called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println(">>>>>postFlush"); 	}
}