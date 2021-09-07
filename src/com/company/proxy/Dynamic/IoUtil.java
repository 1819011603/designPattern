package com.company.proxy.Dynamic;

import java.io.Closeable;
import java.io.IOException;

public class IoUtil {

	public static void close(Closeable ...closeables ) {
		if(closeables == null) {
			return;
		}
		for (Closeable closeable : closeables) {
			if(closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
