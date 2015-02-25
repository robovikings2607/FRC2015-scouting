import java.sql.SQLException;


public class testMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Team team = new Team(2607);
		System.out.println(team.getMatch(1).getStack(7).getHeight());
		System.out.println(team.getMatch(1).getStack(7).getNoodle());
		System.out.println(team.getMatch(2).getStack(1).getPoints());
		
	}

}
