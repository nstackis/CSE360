/*
 * Nicholas Stackis
 * class id: 211
 * Assignment 1
 * Description: 
 * This file contains an assortment of methods that have to do with the array list[]
 * The methods in order are a constructor, a method that adds a value to an array, a method the removes
 * a vale from an array, a method the counts the non-zero values in the array, a method that
 * returns a string of the array, and a method that returns the index of a value in the array.
 */
 
package assign1;

import java.util.Arrays;

public class SimpleList 
{
	private int count;
	private int[] list;
	public SimpleList() // This is a constructor for the program. It initializes the list to a length of 10
	{                   // and it sets the value of count to 0
		count = 0;
		list = new int[10];
	}
	public void add(int value) // This adds an integer to the array and shifts the remaining values to the right
	{
		count++;
		int[] listCopy = Arrays.copyOf(list, 10);
		for(int loopCounter = 1; loopCounter < count; loopCounter++)
		{
			list[loopCounter] = listCopy[loopCounter - 1];
		}
		list[0] = value;
	}
	public void remove(int value) // This looks for an integer and then removes it if it is in the list
	{                         // The remaining values are then shifted to the left.
		int listIndex = -1;
		for(int loopCounter = 0; loopCounter < list.length; loopCounter++)
		{
			if(value == list[loopCounter])
			{
				listIndex = loopCounter;
			}
		}
		if(listIndex > -1)
		{
			count--;
			for(int loopCounter = listIndex; loopCounter < list.length - 2; loopCounter++)
			{
				list[loopCounter] = list[loopCounter + 1];
			}
			list[list.length -1] = 0;
		}
	}
	public int count() // This returns the integer count which is the current number of entries in the list
	{
		return count;
	}
	public String toString() // This returns a string that contains all of the values in the list seperated by spaces
	{
		String stringList = "";
		for(int loopCounter = 0;loopCounter < list.length; loopCounter++)
		{
			stringList = stringList +list[loopCounter];
			if((loopCounter + 1)<list.length)
			{
				stringList = stringList + " ";
			}
		}
		return stringList;
	}
	public int search(int value) // This returns the index of the integer in the list or -1 if it is not in the list
	{
		int listIndex = -1;
		for(int loopCounter = 0; loopCounter < list.length; loopCounter++)
		{
			if(value == list[loopCounter])
			{
				listIndex = loopCounter;
			}
		}
		return listIndex;
	}
}
