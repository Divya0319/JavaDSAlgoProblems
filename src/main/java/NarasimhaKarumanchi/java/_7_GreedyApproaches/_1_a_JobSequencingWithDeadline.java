package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

import java.util.ArrayList;
import java.util.Collections;

public class _1_a_JobSequencingWithDeadline {

	void printJobScheduling(ArrayList<Job> arr, int t) {

		int n = arr.size();

		Collections.sort(arr, (a, b) -> b.profit - a.profit);

		boolean result[] = new boolean[t];

		char job[] = new char[t];

		for (int i = 0; i < n; i++) {

			for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
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
		arr.add(mainClass.new Job('a', 2, 100));
		arr.add(mainClass.new Job('b', 1, 19));
		arr.add(mainClass.new Job('c', 2, 27));
		arr.add(mainClass.new Job('d', 1, 25));
		arr.add(mainClass.new Job('e', 3, 15));

		System.out.println("Following is maximum profit sequence of jobs: ");


		mainClass.printJobScheduling(arr, 3);
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
