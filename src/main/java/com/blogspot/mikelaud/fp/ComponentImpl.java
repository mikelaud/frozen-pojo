package com.blogspot.mikelaud.fp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class ComponentImpl implements Component {

	//------------------------------------------------------------------------
	
	public static class DataImpl implements Data { // POJO

		private int mId;
		private String mField;
		
		@Inject private DataImpl() { set(null); }
		
		@Override public void set(Info aInfo) {
			if (null == aInfo) {
				mId = 0;
				mField = "";
			}
			else {
				setId(aInfo.getId());
				setField(aInfo.getField());
			}
		}
		
		@Override public int getId() { return mId; }
		@Override public String getField() { return mField; }

		@Override public void setId(int aId) { mId = aId; }
		@Override public void setField(String aField) { mField = aField; }
	}
	
	//------------------------------------------------------------------------
	
	public static class FactoryImpl implements Factory { // POJO factory
		
		private final Data DATA;
		private final Creator CREATOR;
		
		@Inject
		private FactoryImpl(Data aData, Creator aCreator) {
			DATA = aData;
			CREATOR = aCreator;
		}

		@Override public Data getData() { return DATA; }
		@Override public Component create() { return CREATOR.create(DATA); }
	}
	
	//------------------------------------------------------------------------
	
	public static interface Creator { Component create(Info aInfo); }
	
	//------------------------------------------------------------------------
	
	private final Info INFO;
	
	@Inject
	private ComponentImpl(Data aData, @Assisted Info aInfo) {
		INFO = aData;
		aData.set(aInfo);
	}
	
	@Override public Info getInfo() { return INFO; }
}
