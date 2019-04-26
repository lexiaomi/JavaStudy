package com.xms.javase.day05.p;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位
 * String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，将list中所有元素分别用迭代器和增强for循环打印出来。
 * @author Administrator
 *
 */
public class TestCollection3 {
	
	public static void main(String[] args) {
		String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
		LinkedList<String> ll=new LinkedList<String>();
		
		for(int i=0;i<strs.length;i++){
			ll.add(strs[i]);
		}
		System.out.println(ll);
		
		for(int j=0;j<ll.size()-1;j++){
			for(int k=ll.size()-1;k>j;k--){
				if(ll.get(k).equals(ll.get(j))){
					ll.remove(k);
				}
			}
		}
		System.out.println("-------------------------");
		
		Iterator< String> it=ll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("------------------------");
		
		for (String str : ll) {
			System.out.println(str);
		}
		
		
		
	}
}
