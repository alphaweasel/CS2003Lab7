package stuff;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {

	// merge is in the form 1, 2, 1, 2, 1, 2, etc.
	// Tulsa, 74104, Ada, 74135, etc.

	public static void main(String[] args) {
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<String> list3 = new LinkedList<String>();

		// populate list 1
		String[] list1elements = { "Tulsa", "Ada", "Broken Arrow", "Owasso" };
		for (String s : list1elements)
			list1.add(s);

		// populate list 2
		String[] list2elements = { "74104", "74135", "foo", "hello world", "777" };
		for (String s : list2elements)
			list2.add(s);

		// print out the initial states of the lists
		System.out.println("List 1 initial: ");
		for (String s : list1)
			System.out.print(s + " ");
		System.out.println("\n\nList 2 initial: ");
		for (String s : list2)
			System.out.print(s + " ");
		System.out.println("\n\nList 3 initial: ");
		for (String s : list3)
			System.out.print(s + " ");

		// add "OKC" to the first list as the second element (element 1)
		list1.add(1, "OKC");

		// print out list1 after OKC is added
		System.out.println("\n\nList 1 with OKC as 2nd element: ");
		for (String s : list1)
			System.out.print(s + " ");

		// create iterators
		ListIterator<String> pointer1 = list1.listIterator();
		ListIterator<String> pointer2 = list2.listIterator();
		ListIterator<String> copyPointer = list3.listIterator();

		// set pointer1 to the first element in its list
		pointer1.next();

		// merge
		// while list2 has more elements, insert into list1 and skip forward one element
		while (pointer2.hasNext()) {
			pointer1.add(pointer2.next());
			if (pointer1.hasNext())
				pointer1.next();
		} // end while

		// print out list1 after the merge
		System.out.println("\n\nList 1 after merge: ");
		for (String s : list1)
			System.out.print(s + " ");

		// reset the pointers
		pointer1 = list1.listIterator();
		pointer2 = list2.listIterator();

		// set pointer 1 to the first element
		pointer1.next();

		// remove every second word from the first list
		while (pointer1.hasNext()) {
			pointer1.next();
			pointer1.remove();
			if (pointer1.hasNext())
				pointer1.next();
		} // end while

		// print out list1 after removing every second element
		System.out.println("\n\nList 1 after removing every second word: ");
		for (String s : list1)
			System.out.print(s + " ");

		// deep copy
		// moves pointer2 to the end of the list and copies each element into
		// the list list2deepcopy
		while (pointer2.hasNext()) {
			copyPointer.add(pointer2.next());
		} // end while

		// print out final states of all the lists
		System.out.println("\n\nList 1 final: ");
		for (String s : list1)
			System.out.print(s + " ");
		System.out.println("\n\nList 2 final: ");
		for (String s : list2)
			System.out.print(s + " ");
		System.out.println("\n\nList 3 (deep copy) final: ");
		for (String s : list3)
			System.out.print(s + " ");

	} // end method main
} // end class LinkedListExample
