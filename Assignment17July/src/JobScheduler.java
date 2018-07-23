import java.util.*;

public class JobScheduler {
	private int avg_wait_time;
	private int waitTime[];
	private int turn_around_time[];
	private int completion_time[];
	private int input[][];

	public JobScheduler(int numberOfProcess) {
		avg_wait_time = 0;
		completion_time = new int[numberOfProcess];
		turn_around_time = new int[numberOfProcess];
		waitTime = new int[numberOfProcess];

		Scanner sc = new Scanner(System.in);

		input = new int[numberOfProcess][2];
		for (int p = 0; p < numberOfProcess; p++) {
			System.out.println("enter arrival time and burst time for process "
					+ p);
			for (int j = 0; j < 2; j++)
				input[p][j] = sc.nextInt();
		}
		System.out.println("------display1-----------------------------------");
		display(input, numberOfProcess);
		sort(input, numberOfProcess);
		sc.close();

	}

	public void sort(int input[][], int numberOfProcess) {
		int temp = 0;
		for (int i = 0; i <= numberOfProcess; i++) {
			for (int j = i + 1; j < numberOfProcess; j++) {
				if (input[i][0] > input[j][0]) {
					temp = input[i][0];
					input[i][0] = input[j][0];
					input[j][0] = temp;
				}
			}
		}
		System.out.println("------------------display3-----------------------");
		display(input, numberOfProcess);
		CompleteMethod(input, numberOfProcess);
		TurnMethod(input, numberOfProcess);
		WaitMethod(input, numberOfProcess);

	}

	public void CompleteMethod(int input[][], int numberOfProcess) {
		completion_time[0] = input[0][0] + input[0][1];
		for (int j = 1; j < numberOfProcess; j++) {
			if (input[j][0] < completion_time[j - 1])
				completion_time[j] = input[j][1] + completion_time[j - 1];
			else
				completion_time[j] = input[j][0] + input[j][1];
		}
		System.out.println(" Completion time for each process is");
		displayOperation(completion_time, numberOfProcess);
	}

	public void TurnMethod(int input[][], int numberOfProcess) {
		for (int i = 0; i < numberOfProcess; i++) {
			turn_around_time[i] = completion_time[i] - input[i][0];
		}
		System.out.println(" Turn around time  for each process is");
		displayOperation(turn_around_time, numberOfProcess);
	}

	public void WaitMethod(int input[][], int numberOfProcess) {
		for (int i = 0; i < numberOfProcess; i++) {
			waitTime[i] = turn_around_time[i] - input[i][1];
		}
		System.out.println(" wait around time  for each process is");

		displayOperation(waitTime, numberOfProcess);
		int avg = avg_wait(waitTime, numberOfProcess);
		System.out.println("avg_wait_time is " + avg);
		int max = maxWait(waitTime, numberOfProcess);
		System.out.println("max wait is " + max);
	}

	public int avg_wait(int waitTime[], int numberOfProcess) {
		for (int i = 0; i < numberOfProcess; i++)
			avg_wait_time = waitTime[i] + avg_wait_time;
		avg_wait_time = avg_wait_time / numberOfProcess;
		return avg_wait_time;
	}

	public int maxWait(int waitTime[], int numberOfProcess) {
		int max_wait = waitTime[0];
		for (int i = 0; i < numberOfProcess; i++) {
			if (waitTime[i] > max_wait)
				max_wait = waitTime[i];

		}
		return max_wait;

	}

	public void displayOperation(int Time[], int numberOfProcess) {
		for (int i = 0; i < numberOfProcess; i++) {
			System.out.print(Time[i] + "\t");
		}
		System.out.println();
	}

	public void display(int input[][], int numberOfProcess) {
		for (int i = 0; i < numberOfProcess; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(input[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
