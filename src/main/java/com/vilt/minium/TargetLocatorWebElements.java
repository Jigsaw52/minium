package com.vilt.minium;

import org.openqa.selenium.Alert;

/**
 * 
 * @author Rui
 *
 * @param <T>
 */
public interface TargetLocatorWebElements<T extends WebElements> extends WebElements {
	
	/**
	 * 
	 * @param selector
	 * @return
	 */
	public T frame(String selector);

	/**
	 * 
	 * @param selector
	 * @return
	 */
	public T frame(T filter);
	
	/**
	 * 
	 * @return
	 */
	public T frame();
	
	/**
	 * 
	 * @param nameOrHandle
	 * @return
	 */
	public T window(T filter);
	public T window(T filter, boolean freeze);

	/**
	 * 
	 * @param expr
	 * @return
	 */
	public T window(String expr);
	public T window(String expr, boolean freeze);
	
	/**
	 * 
	 * @return
	 */
	public T window();
	
	/**
	 * 
	 * @return
	 */
	public Alert alert();

	
}
