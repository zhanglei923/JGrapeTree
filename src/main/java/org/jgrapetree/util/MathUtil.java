package org.jgrapetree.util;

import java.util.Random;

public class MathUtil {
	public String getHexStr(){
		double long_num = 1000000000;
		String num = String.valueOf(Math.floor(Math.random()*long_num/10));
		Random r = new Random();
		int ri = r.nextInt(1000);
		return Double.toHexString(Double.parseDouble(num)).split("\\.")[1] + ri;
	}
}
