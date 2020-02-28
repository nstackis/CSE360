/*
 * Nicholas Stackis
 * class id: 211
 * Assignment 2
 * Description: 
 * This file contains an assortment of methods that have to do with the array list[]
 * The methods in order are a constructor, a method that adds a value to an array, a method the removes
 * a vale from an array, a method the counts the non-zero values in the array, a method that
 * returns a string of the array, and a method that returns the index of a value in the array.
 * There is a method that appends a value to the end of the array, a method that returns the first value of the 
 * array. a method that returns that last value of the array and a method that returns the size of the array
 * There is also logic that increases or decreases the list size based on existing entries
 */
 
package assign2;

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
	{                          // The array size is increased by 50% if the array is full
		if(count<list.length)
		{
			count++;
		}
		else
		{
			list = Arrays.copyOf(list, (int)(list.length+.5*list.length));
			count++;
		}
		int[] listCopy = Arrays.copyOf(list, list.length);
		for(int loopCounter = 1; loopCounter < list.length; loopCounter++)
		{
			list[loopCounter] = listCopy[loopCounter - 1];
		}
		list[0] = value;
	}
	public void remove(int value) // This looks for an integer and then removes it if it is in the list
	{                         // The remaining values are then shifted to the left.
		int listIndex = -1;   // The array size is decreased by 25% if the array is missing more than 25% of values
		for(int loopCounter = 0; loopCounter < list.length; loopCounter++)
		{
			if(value == list[loopCounter])
			{
				listIndex = loopCounter;
			}
		}
		if(listIndex > -1)
		{
			int[] tempList = Arrays.copyOf(list, list.length);
			for(int loopCounter = listIndex; loopCounter < list.length-1; loopCounter++)
			{
				list[loopCounter] = tempList[loopCounter + 1];
			}
			list[list.length -1] = 0;
			count--;
		}
		if(count<(int)(list.length*0.75)&&(int)(list.length*.75)>1)
		{
			list = Arrays.copyOf(list, (int)(list.length*.75));
		}
	}
	public int count() // This returns the integer count which is the current number of entries in the list
	{
		return count;
	}
	public String toString() // This returns a string that contains all of the values in the list seperated by spaces
	{
		String stringList = "";
		if(count==0)
		{
			return stringList;
		}
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
	public void append(int value) //adds a value to the end of the array and increases the array size
	{                             // and apend the value to the end if the array was full
		if(count<list.length)
		{
			list[count] = value;
			count++;
		}
		else
		{
			list = Arrays.copyOf(list, (int)(list.length*1.5));
			list[count] = value;
			count++;
		}
	}
	public int first() //returns the first index of the array if it exists
	{
		if(count>0)
		{
			return list[0];
		}
		else
		{
			return -1;
		}
	}
	public int last() // returns the last index of the array if it exists
	{
		if(count>0)
		{
			return list[count-1];
		}
		else
		{
			return -1;
		}
	}
	public int size() //returns the size of the array
	{
		return list.length;
	}
}
