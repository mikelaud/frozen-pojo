package com.blogspot.mikelaud.fp;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ComponentModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Component.Data.class).to(ComponentImpl.DataImpl.class);
		bind(Component.Factory.class).to(ComponentImpl.FactoryImpl.class);
		
		install(new FactoryModuleBuilder()
			.implement(Component.class, ComponentImpl.class)
			.build(ComponentImpl.Creator.class));
	}

}
