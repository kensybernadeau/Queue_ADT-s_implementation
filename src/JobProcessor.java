import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JobProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int timer=0;
		int id=1;


		LLQueue<Job> inputQueue = new LLQueue<>();
		LLQueue<Job> processingQueue = new LLQueue<>();
		ArrayList<Job> terminatedjobs =new ArrayList<>();

		@SuppressWarnings("resource")
		Scanner read;
		try {
			read = new Scanner( new File("input.txt"));
			

			while(read.hasNextLine()) {
				 String line = read.nextLine();
		            String[] lineArray = line.split(",");
               
				inputQueue.enqueue(new Job(id,Integer.parseInt(lineArray[0]),Integer.parseInt(lineArray[1])));
				id++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		while(!inputQueue.isEmpty() || !processingQueue.isEmpty()) {
			if(!processingQueue.isEmpty()) {
				processingQueue.first().isServed(1);
				if( processingQueue.first().getRemainingTime()==0) {
					processingQueue.first().setDepartureTime(timer);
					terminatedjobs.add(processingQueue.dequeue());
				}
				else {
					processingQueue.enqueue(processingQueue.dequeue());
				}
				
			}
			if(!inputQueue.isEmpty())
			if(inputQueue.first().getArrivalTime()==timer) {
				processingQueue.enqueue(inputQueue.dequeue());

			}
			timer++; 
		}
		
		double sum=0;
		int diff=0;
		System.out.println("Process\t" + "    Arrival Time\t" + "Departure Time\t" + "   Total Time");
		for(int i =0; i<terminatedjobs.size();i++) {
			diff=terminatedjobs.get(i).getDepartureTime()-terminatedjobs.get(i).getArrivalTime();
		sum+=	diff;
			System.out.println(terminatedjobs.get(i).getPid()+"\t\t" + terminatedjobs.get(i).getArrivalTime() +"\t\t" + terminatedjobs.get(i).getDepartureTime() +"\t\t"+ diff);
		}
			
		
		System.out.println("\naverage time that a process spends in the system is:"+sum/terminatedjobs.size());
	}

}
