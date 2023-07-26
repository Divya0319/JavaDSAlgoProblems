package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

import java.util.ArrayList;
import java.util.Collections;

public class _1_a_JobSequencingWithDeadline {

	void printJobScheduling(ArrayList<Job> arr) {

		int n = arr.size();

		Collections.sort(arr, (a, b) -> b.profit - a.profit);
		
		int mD = 0;
		for(int i = 0; i < n; i++) {
			if(arr.get(i).deadline > mD) {
				mD = arr.get(i).deadline;
			}
		}

		boolean result[] = new boolean[mD];

		char job[] = new char[mD];

		for (int i = 0; i < n; i++) {

			for (int j = arr.get(i).deadline - 1; j >= 0; j--) {
				if (result[j] == false) {
					result[j] = true;
					job[j] = arr.get(i).id;
					break;
				}
			}
		}

		for (char jb : job) {
			System.out.print(jb + " ");
		}

		System.out.println();

	}

	public static void main(String[] args) {
		ArrayList<Job> arr = new ArrayList<>();
		_1_a_JobSequencingWithDeadline mainClass = new _1_a_JobSequencingWithDeadline();
		arr.add(mainClass.new Job('a', 5, 200));
		arr.add(mainClass.new Job('b', 3, 180));
		arr.add(mainClass.new Job('c', 3, 190));
		arr.add(mainClass.new Job('d', 2, 300));
		arr.add(mainClass.new Job('e', 4, 120));
		arr.add(mainClass.new Job('f', 2, 100));

		System.out.println("Following is maximum profit sequence of jobs: ");


		mainClass.printJobScheduling(arr);
	}

	class Job {
		char id;
		int deadline, profit;

		public Job() {

		}

		public Job(char id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

	}

}
