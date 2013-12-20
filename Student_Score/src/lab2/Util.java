package lab2;
import java.io.*;
import java.util.*;

class Util {
	static Student [] readFile(String filename, Student [] stu){
		//Reads the file and builds student array.
		String s;
		int studentNum = 0;
		//Open the file using FileReader Object.
		File studentInfo = new File(filename);
		//In a loop read a line using readLine method.
		try {
			FileReader fr = new FileReader(studentInfo);
			BufferedReader br = new BufferedReader(fr);
			//to remove the header
			br.readLine();
			while ((s = br.readLine()) != null) {
				//Analyze each line using StringTokenizer Object
				StringTokenizer st = new StringTokenizer(s);
				int scores[] = new int[5];
				stu[studentNum] = new Student();
				for(int i=0; st.hasMoreTokens(); i++){
					String tmp = st.nextToken();
					int score, SID;
					//Each token is converted from String to Integer using parseInt method
					if(i == 0){
						SID = Integer.parseInt(tmp);
						stu[studentNum].setSID(SID);
					}
					else {
						score = Integer.parseInt(tmp);
						scores[i-1] = score;
					}
				}
				//Value is then saved in the right property of Student Object.
				stu[studentNum].setScores(scores);
				studentNum++;
			}
			fr.close();
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		Student [] student = new Student[studentNum]; 
		for(int i=0; i<studentNum; i++) {
			student[i] = stu[i];
		}
		return student;
	}
}
