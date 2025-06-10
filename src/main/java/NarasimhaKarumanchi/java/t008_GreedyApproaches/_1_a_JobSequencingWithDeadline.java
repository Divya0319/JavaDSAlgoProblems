package main.java.NarasimhaKarumanchi.java.t008_GreedyApproaches;

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
		int jobProfit = 0;

		for (int i = 0; i < n; i++) {

			for (int j = arr.get(i).deadline - 1; j >= 0; j--) {
				
				// free slot found
				if (result[j] == false) {
					// mark that slot as filled
					result[j] = true;
					
					// store this job in job array at this deadline index
					job[j] = arr.get(i).id;
					jobProfit += arr.get(i).profit;
					
					// breaking because a job can be performed on a single day only
					break;
				}
			}
		}

		for (char jb : job) {
			System.out.print(jb + " ");
		}

		System.out.println("Total profit : " + jobProfit);

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

		public Job(char id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

	}

}
