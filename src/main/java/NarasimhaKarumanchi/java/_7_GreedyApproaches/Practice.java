package main.java.NarasimhaKarumanchi.java._7_GreedyApproaches;

import java.util.ArrayList;
import java.util.Collections;

import main.java.NarasimhaKarumanchi.java._7_GreedyApproaches._1_a_JobSequencingWithDeadline.Job;

public class Practice {
	
	class Job {
		
		char id;
		int deadline;
		int profit;
		
		public Job() {
			
		}
		
		public Job(char id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	int jobSequencing(ArrayList<Job> jobs) {
		
		Collections.sort(jobs, (a,b) -> (b.profit - a.profit));
		
		int n = jobs.size();
		
		int mD = 0;
		for(int i = 0; i < n; i++) {
			if(jobs.get(i).deadline > mD) {
				mD = jobs.get(i).deadline;
			}
		}
		
		char[] jSeq = new char[mD];
		
		boolean result[] = new boolean[mD];
		
		int maxProfit = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = jobs.get(i).deadline - 1; j >=0; j--) {
				if(result[j] == false) {
					result[j] = true;
					jSeq[j] = jobs.get(i).id;
					maxProfit += jobs.get(i).profit;
					break;
				}
			}
		}
		
		System.out.print("Job sequence is : ");
		for(char job : jSeq) {
			System.out.print(job + " ");
		}
		
		System.out.println();
		
		return maxProfit;
		
	}
	
	public static void main(String[] args) {
		Practice p = new Practice();
		
		ArrayList<Job> jobs = new ArrayList<>();
		
		jobs.add(p.new Job('a', 5, 200));
		jobs.add(p.new Job('b', 3, 180));
		jobs.add(p.new Job('c', 3, 190));
		jobs.add(p.new Job('d', 2, 300));
		jobs.add(p.new Job('e', 4, 120));
		jobs.add(p.new Job('f', 2, 100));
		
		System.out.println("Following is maximum profit sequence of jobs: ");


		int maxProfit = p.jobSequencing(jobs);
		
		System.out.println("Maximum profit is : " + maxProfit);
	}

}
