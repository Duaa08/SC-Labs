import java.util.Scanner;
public class HelloWorld {
	public static void main(String arg[]){
		String [][] info = new String[2][3];
		String Sname, Sreg, Scgpa;
		Scanner in = new Scanner(System.in);
		//String name = in.nextLine();
		//System.out.println("Welcome "+name+" to the JAVA world!");
	
		for(int i = 0; i < 2; i++){
			System.out.println("Enter the Student's name, registration number and cgpa:");
			Sname = in.nextLine();
			//Sreg = in.nextLine();
			
			
			String gp = null;
			for(int j = 0; j < 2; j++){
					Sreg = in.nextLine();
					if(Sreg == info[j][1])
				    {
						System.out.println("Registration number already exists! Enter the value again.");				
						Sreg = in.nextLine();
						info[i][1] = Sreg;
				    }
			
					else 
					{
						info[i][1] = Sreg;
				
					}
			
			}
			//while(true){
			
				Scgpa = in.nextLine();
				float c = Float.parseFloat(Scgpa);

				if(c > 4 || c < 0){				
					System.out.println("Invalid Input. Enter the value again.");
					Scgpa = in.nextLine();
					c = Float.parseFloat(Scgpa);
					gp = String.valueOf(c);
					info[i][2] = gp;
				}
				else 
				{
					//break;
					gp = String.valueOf(c);
					info[i][2] = gp;
					
				}
		
			//}
		
			
		
			info[i][0] = Sname;
			info[i][2] = gp;
			System.out.println("Student data: ");

			System.out.println("Name: " + info[i][0]);
			System.out.println("Registration number: " + info[i][1]);
			System.out.println("CGPA: " + info[i][2]);
			float sumc = 0;
			float max = 0;
			float min = 0;
			for(int g = 0; g < 2; g++){
				
				float su = Float.parseFloat(info[g][2]);
				sumc += su;
				
				for(int z = 0; z < 2; z++){
					float a = Float.parseFloat(info[g][2]);
					float b = Float.parseFloat(info[z][2]);

					if(a >= b){
						max = a;
						min = b;
					}
					else {
						max = b;
						min = a;
					}
						
					}
				}
            sumc = sumc/3;
            System.out.println("Average CGPA: " + sumc);
            System.out.println("Maximum CGPA: " + max);
            System.out.println("Minimum CGPA: " + min);
            String n1;
            n1 = in.nextLine();
            for(int k = 0; k < 2; k++){
            if(n1 == info[k][0]){
            	System.out.println("Name: " + info[k][0]);
            	System.out.println("Name: " + info[k][1]);
            	System.out.println("Name: " + info[k][2]);

            }
            else {
            	System.out.println("Student doesn't exist!");

            }
            }
			}
		}
	
}

