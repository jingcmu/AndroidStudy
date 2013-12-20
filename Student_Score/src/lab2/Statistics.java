package lab2;

class Statistics {
	int [] lowscores = new int [5];
  	int [] highscores = new int [5];
  	float [] avgscores = new float [5];
  	void findlow(Student [] a){
      	//This method will find lowest score and store it in an array names lowscores
  		int [] scores = a[0].getScores();
  		for(int i=0; i<5; i++) {
  			lowscores[i] = scores[i];
  		}
  		for(int i=1; i<a.length; i++) {
  			scores = a[i].getScores();
  			for(int j=0; j<5; j++) {
  				if(scores[j] < lowscores[j]) {
  					lowscores[j] = scores[j];
  				}
  			}
  		}
  	}
 
  	void findhigh(Student [] a){
  		//This method will find highest score and store it in an array names highscores
  		int [] scores = a[0].getScores();
  		for(int i=0; i<5; i++) {
  			highscores[i] = scores[i];
  		}
  		for(int i=1; i<a.length; i++) {
  			scores = a[i].getScores();
  			for(int j=0; j<5; j++) {
  				if(scores[j] > highscores[j]) {
  					highscores[j] = scores[j];
  				}
  			}
  		}
  	}

  	void findavg(Student [] a){
  		//This method will find avg score for each quiz and store it in an array names avgscores
  		int [] scores = a[0].getScores();
  		float [] totalscores = {0, 0, 0, 0, 0};
  		for(int i=0; i<a.length; i++) {
  			scores = a[i].getScores();
  			for(int j=0; j<5; j++) {
  				totalscores[j] += scores[j];
  			}
  		}
  		for(int i=0; i<5; i++) {
  			avgscores[i] = totalscores[i]/a.length;
  		}
  	}
  	
  	//add methods to print values of instance variables.
  	void printscores() {
  	//print formatted string
  		System.out.printf("%-14s", "High Score");
  		for(int i=0; i<5; i++) {
  			System.out.printf("%-14d", highscores[i]);
		}
		System.out.println();
		System.out.printf("%-14s", "Low Score");
		for(int i=0; i<5; i++) {
			System.out.printf("%-14d", lowscores[i]);
		}
		System.out.println();
		System.out.printf("%-14s", "Average");
		for(int i = 0; i < 5; i++){
			System.out.printf("%-14f", avgscores[i]);
		}
		System.out.println();
  	}
}