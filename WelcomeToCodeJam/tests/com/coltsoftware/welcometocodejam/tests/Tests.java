package com.coltsoftware.welcometocodejam.tests;

import org.junit.Assert;
import org.junit.Test;

import com.coltsoftware.welcometocodejam.Counter;

public class Tests {

	@Test
	public void test1(){
		Assert.assertEquals(1, Counter.countString("welcome to code jam", "elcomew elcome to code jam"));
	}
	
	@Test
	public void test256(){
		Assert.assertEquals(256, Counter.countString("welcome to code jam", "wweellccoommee to code qps jam"));
	}
	
	@Test
	public void test0(){
		Assert.assertEquals(0, Counter.countString("welcome to code jam", "welcome to codejam"));
	}
	
}
