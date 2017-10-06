package poc.corejava.lambda;

import java.util.ArrayList;
import java.util.List;

public class SimpleCollectionConversion {

	public static void main(String[] args) {
		Object[] arr1 = new Object[] { "Arvind", "Gurgaon" };
		Object[] arr2 = new Object[] { "Raja", "Delhi" };
		Object[] arr3 = new Object[] { "Pradeep", "Noida" };
		Object[] arr4 = new Object[] { "Saboor", "Gurgaon" };

		List<Object[]> records = new ArrayList<>();
		records.add(arr1);
		records.add(arr2);
		records.add(arr3);
		records.add(arr4);
		
		List<Person> persons = new ArrayList<>();
		records.stream().map((record) -> new Person((String)record[0], (String)record[1])).forEach((person) -> persons.add(person));
		
		System.out.println(persons);

	}

	public static class Person {
		private String name;
		private String address;

		public Person(String name, String address) {
			super();
			this.name = name;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public String getAddress() {
			return address;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", address=" + address + "]";
		}

	}

}
