package lab2;

public class Student {
	private int SID;
	private int scores[] = new int[5];
	
	//use default access modifier
	public Student(){}
	public Student(int SID, int[] scores){
		this.SID = SID;
		for(int i=0; i<5; i++){
			this.scores[i] = scores[i];
		}
	}
	
	//write public get and set methods for SID and scores
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	//add methods to print values of instance variables.
	public void print(){
		//print formatted string
		System.out.printf("%-14s", this.SID);
		for(int i = 0; i < 5; i++){
			System.out.printf("%-14d", this.scores[i]);
		}
		System.out.println();
	}
}
