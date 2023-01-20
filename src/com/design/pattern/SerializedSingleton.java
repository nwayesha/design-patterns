package com.design.pattern;

import java.io.Serializable;

 class SerializedSingleton implements Serializable {
	private static final long serialVersionUID = -7604766932017737115L;
	
	private SerializedSingleton() {}
	
	private static class SerializedHelper{
		private static final SerializedSingleton serializedSingleton = new SerializedSingleton();
	}
	
	public static SerializedSingleton getSerializedSingletonInstance() {
		return SerializedHelper.serializedSingleton;
	}
}

