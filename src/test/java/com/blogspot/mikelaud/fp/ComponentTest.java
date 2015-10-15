package com.blogspot.mikelaud.fp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ComponentTest {

	@Test
	public void testFrozenPojo() {
		Injector injector = Guice.createInjector(new ComponentModule());
		Component.Factory factory = injector.getInstance(Component.Factory.class);
		
		Component.Data data = factory.getData();
		data.setId(123);
		data.setField("abc");
		
		Component component = factory.create();
		Component.Info info = component.getInfo();
		
		assertEquals(info.getId(), data.getId());
		assertEquals(info.getField(), data.getField());
	}
	
}
