package com.ge.example.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PriorityQueueImpl4<T, Integer> implements PriorityQueue<T> {

	private LinkedList<Item> list = new LinkedList<Item>();

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public T getNext() throws NoSuchElementException {
		if (list.isEmpty())
			throw new NoSuchElementException();
		return (T) list.removeFirst().value;
	}

	@Override
	public boolean add(T value, int priority) {

		if (list.isEmpty()) {
			list.add(new Item(value, priority));			
			return true;
		}

		for (int index = 0; index < list.size(); index++) {
			if (priority < list.get(index).priority) {
				list.add(index, new Item(value, priority));
				return true;
			}

		}
		list.addLast(new Item(value, priority));

		return true;
	}

	static class Item<T> {
		public Item(T value, int priority) {
			this.value = value;
			this.priority = priority;
		}

		T value = null;
		int priority = 0;
	}

}
