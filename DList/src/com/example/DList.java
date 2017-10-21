package com.example;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import DList.D_Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Implementation of a doubly-linked list
 *
 * @param <Item>
 */
public class DList<Item> implements Iterable<Item> {

    /**
     * Constructor which seeds the DList with one item
     *
     * @param item the Item to place into the new DList.
     */
    public DList(Item item) {
        super();
        addBeforeElement(item, null);
    }

    /**
     * Constructor which creates an empty DList
     */
    public DList() {
        super();
    }

    /**
     * Add an item immediately before the given element
     *
     * @param item the item to be added.
     * @param next may be null, in which case the item will be the only item on the list
     */
    public void addBefore(Item item, Item next) throws BQSException {
        if (next == null) addBeforeElement(item, null);
        else {
            D_Element first = findFirst(next);
            if (first != null)
                addBeforeElement(item, first);
            else
                throw new BQSException("item not found: " + next);
        }
    }

    /**
     * Add an item immediately before the given element
     *
     * @param item the item to be added.
     * @param prev may NOT be null
     */
    public void addAfter(Item item, @NotNull Item prev) throws BQSException {
        {
            D_Element last = findLast(prev);
            if (last != null)
                addAfterElement(item, last);
            else
                throw new BQSException("item not found: " + prev);
        }
    }

    /**
     * Remove the first element matching item from this DList
     *
     * @param item the item to be removed.
     */
    public void remove(Item item) throws BQSException {
        D_Element last = findLast(item);
        if (last != null)
            remove(last);
        else
            throw new BQSException("item not found: " + item);
    }

    /**
     * Add an item immediately before the given element
     *
     * @param item the item to be added.
     * @param next may be null, in which case the item will be the only item on the list
     */
    public void addBeforeElement(Item item, D_Element next) {
    	assert (isEmpty() != (next != null));
        if (next == null){
        	D_Element temp = new D_Element (item);
        	head = temp;
        	tail = temp;
        }
        else{
        	if(next.prev == null){
        		D_Element temp = new D_Element (item, next.prev, next);
        		head = temp;
        		next.prev = temp;
        	}
        	
        	else{
        		D_Element temp = new D_Element (item, next.prev, next);
        		D_Element t = next.prev;
        		next.prev = temp;
        		t.next = temp;
        		
        	}
        }
        count++;
    }

    /**
     * Add an item immediately before the given element
     *
     * @param item the item to be added.
     * @param prev may NOT be null
     */
    public void addAfterElement(Item item, @NotNull D_Element prev) {
    	D_Element temp = new D_Element (item, prev, prev.next);
    	if (prev.next == null){
    		prev.next = temp;
    		tail = temp;
    	}
    	else{
    		D_Element t = prev.next;
    	    prev.next = temp;
    		t.prev = temp;    
    	}
    	count++;
    }

    /**
     * Remove the element given from this DList
     *
     * @param element the element to be removed.
     */
    public void remove(D_Element element) {
    	if(element.prev == null){
    		if(element.next == null){
    			head = null;
    			tail = null;
    		}
    		else{
    			head = element.next;
    			head.prev = null;
    		}
    	else if(element.next == null){
    		tail = element.prev;
    		tail.next = null;
    	}
    	else{
    		D_Element t = element.next;
    		D_Element d = element.prev;
    		d.next = t;
    		t.prev = d;
    	}
    	}
        count--;
    }

    public D_Element findFirst(Item item) {
        if (isEmpty()) return null;
        D_Element result = head;
        while (result != null && !result.item.equals(item))
            result = result.next;
        return result;
    }

    public D_Element findLast(Item item) {
        if (isEmpty()) return null;
        D_Element result = tail;
        while (result != null && !result.item.equals(item))
            result = result.prev;
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item i : this) sb.append(i + ", ");
        return sb.toString();
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return head != null ? head.iterator() : new ArrayList<Item>().iterator();
    }

    class D_Element implements Iterable<Item> {
        D_Element(Item x, D_Element p, D_Element n) {
            item = x;
            prev = p;
            next = n;
        }

        D_Element(Item x) {
            this(x, null, null);
        }

        final Item item;
        D_Element prev;
        D_Element next;

        @NotNull
        @Override
        public Iterator<Item> iterator() {
            Collection<Item> result = new ArrayList<>();
            D_Element cursor = this;
            while (cursor != null) {
                result.add(cursor.item);
                cursor = cursor.next;
            }
            return result.iterator();
        }
    }


    @Nullable
    private D_Element head = null;
    private D_Element tail = null;
    private int count = 0;
}
