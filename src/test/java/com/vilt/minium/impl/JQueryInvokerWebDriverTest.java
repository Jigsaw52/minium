package com.vilt.minium.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Lists;
import com.vilt.minium.MiniumBaseTest;

public class JQueryInvokerWebDriverTest  extends MiniumBaseTest {
	
	private JQueryInvoker positionInvoker;
	
	@Before
	public void openPage() {
		get("minium/tests/jquery-test.html");
		positionInvoker = new JQueryInvoker(Lists.newArrayList("minium/js/jquery.js", "minium/js/position.js"), null);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testInvoke() {
		Object result = positionInvoker.invoke(wd, "return $('input')");
		
		List<WebElement> webElements = (List<WebElement>) result;
		assertThat(webElements, everyItem(isA(WebElement.class)));		
	}
	
	@Test
	public void testInvokeWithArg() {
		Object result = positionInvoker.invoke(wd, "return args[0];", "Hello World");
		
		assertThat((String) result, equalTo("Hello World"));		
	}
	
	@Test
	public void testInvokeWithArgFullAndLight() {
		Object result = positionInvoker.invoke(wd, "return args[0];", "Hello World");
		
		assertThat((String) result, equalTo("Hello World"));
		
		result = positionInvoker.invoke(wd, "return args[0];", "Hello World (now light)");
		assertThat((String) result, equalTo("Hello World (now light)"));
	}
	
}
