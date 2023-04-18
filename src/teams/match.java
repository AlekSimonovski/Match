package teams;
import java.util.Scanner;
public class match {
	public static void main(String[] args) {
		Team1 team1 = new Team1();
		Team2 team2 = new Team2();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the two teams playing each other.");
		System.out.println("First team: (playing at home)");				//Example: Real Madrid.
		team1.name = input.nextLine();
		System.out.println("Second team: (playing away from home)");				//Example: Barcelona.
		team2.name = input.nextLine();
		System.out.println("Enter the city/venue of the first match: ");		//Santiago Bernabeu
		team1.city = input.nextLine();
		System.out.println("Enter the city/venue of the return match: ");		//Spotify Camp Nou
		team2.city = input.nextLine();
		System.out.println("Enter the amount of goals "+team1.name+" scored in the 1st leg ("+team1.city+"): ");		//Real Madrid 0
		team1.goals1 = input.nextInt();
		System.out.println("Enter the amount of goals "+team2.name+" scored in the 1st leg ("+team1.city+"): ");		//Barcelona 1
		team2.return2 = input.nextInt();
		System.out.println("Enter the amount of goals "+team1.name+" scored in the 2nd leg ("+team2.city+"): ");		//Real Madrid 4
		team1.return1 = input.nextInt();
		System.out.println("Enter the amount of goals "+team2.name+" scored in the 2nd leg ("+team2.city+"): ");		//Barcelona 0
		team2.goals2 = input.nextInt();
		int total_team1 = team1.goals1 + team1.return1;
		int total_team2 = team2.goals2 + team2.return2;
		if (total_team1 > total_team2) {
			System.out.println(team1.name+" won the tie. The score in "+team2.city+" is: "+team2.name+" "+team2.goals2+" - "+team1.return1+" "+team1.name+" ("+total_team2+" - "+total_team1+" on aggregate.)");
			System.out.println("The score in "+team1.city+" was: "+team1.name+" "+team1.goals1+" - "+team2.return2+" "+team2.name);
		System.exit(0);
		}
		if (total_team2 > total_team1) {
			System.out.println(team2.name+" won the tie. The score in "+team2.city+" is: "+team2.name+" "+team2.goals2+" - "+team1.return1+" "+team1.name+" ("+total_team2+" - "+total_team1+" on aggregate.)");
			System.out.println("The score in "+team1.city+" was: "+team1.name+" "+team1.goals1+" - "+team2.return2+" "+team2.name);
		System.exit(0);
		}
		if (total_team1 == total_team2 && team1.return1 > team2.return2) {		
			System.out.println("The tie was drawn but "+team1.name+" won on away goals. The score in "+team2.city+" is: "+team2.name+" "+team2.goals2+" - "+team1.return1+" "+team1.name+"\n Away goals: "+ team1.name+" "+team1.return1+" - "+team2.return2+" "+team2.name);
			System.out.println("The score in "+team1.city+" was: "+team1.name+" "+team1.goals1+" - "+team2.return2+" "+team2.name);
		System.exit(0);
		}
		if (total_team2 == total_team1 && team1.return1 < team2.return2) {
			System.out.println("The tie was drawn but "+team2.name+" won on away goals. The score in "+team2.city+" is: "+team2.name+" "+team2.goals2+" - "+team1.return1+" "+team1.name+"\n Away goals: "+ team2.name+" "+team2.return2+" - "+team1.return1+" "+team1.name);
			System.out.println("The score in "+team1.city+" was: "+team1.name+" "+team1.goals1+" - "+team2.return2+" "+team2.name);
		System.exit(0);
		}
		if (total_team2 == total_team1 && team1.return1 == team2.return2) {
			System.out.println("The tie was drawn and proceeds to Extra time.");
			int team1_extra;
			System.out.println("Enter the goals "+team1.name+" scores in extra time: ");
			team1_extra = input.nextInt();
			int team2_extra;
			System.out.println("Enter the goals "+team2.name+" scores in extra time: ");
			team2_extra = input.nextInt();
			int team1_aet = team1_extra + team1.return1;
			int team2_aet = team2_extra + team2.goals2;
			int team1_full = team1_aet + team1.goals1;
			int team2_full = team2_aet + team2.return2;
			if (team1_full > team2_full) {
				System.out.println(team1.name+" won the tie. The score in "+team2.city+" is: "+team2.name+" "+team2_aet+" - "+team1_aet+" "+team1.name+" ("+team2.name+" "+team2_full+" - "+team1_full+" "+team1.name+")");
			}
			if (team1_full < team2_full) {
				System.out.println(team2.name+" won the tie. The score in "+team2.city+" is: "+team2.name+" "+team2_aet+" - "+team1_aet+" "+team1.name+" ("+team2.name+" "+team2_full+" - "+team1_full+" "+team1.name+")");
			}
			if (team1_aet == team2_aet && team1.return1 == team2.goals2) {
				System.out.println("The tie was drawn and proceeds to penalties.");
				int team1_penalties;
				int team2_penalties;
				System.out.println("Enter the amount of penalties scored by "+team1.name+" :");
				team1_penalties = input.nextInt();
				System.out.println("Enter the amount of penalties scored by "+team2.name+" :");
				team2_penalties = input.nextInt();
				if (team1_penalties > team2_penalties) {
					System.out.println(team1.name+" won "+team1_penalties+" - "+team2_penalties+" on penalties. \n"+"Full time score after extra time and penalties is: "+team2.name+" "+team2_full+"("+team2_penalties+") - ("+team1_penalties+")"+team1_full+" "+team1.name); 			
					}
				if (team1_penalties < team2_penalties) {
					System.out.println(team2.name+" won "+team2_penalties+" - "+team1_penalties+" on penalties. \n"+"Full time score after extra time and penalties is: "+team2.name+" "+team2_full+"("+team2_penalties+") - ("+team1_penalties+")"+team1_full+" "+team1.name); 			
					}
				if (team1_penalties == team2_penalties) {
					System.out.println("It's not possible to draw on penalties, try again.");
				}
			}
		}
		else {
			System.out.println("Error, bad entry.");
		}		
	}
}
