/***
 * Player Class:
1.Player(String name): Constructor. Initializes a player with a name.
Return type: Constructor.

2.addRuns(int runs): Adds the given number of runs to the player's score.
Return type: void.

3.addBallsFaced(int balls): Increases the number of balls faced by the player.
Return type: void.

4.strikeRate(): Calculates and returns the player's strike rate based on runs and balls faced.
Return type: float.

5.getName(): Returns the player's name.
Return type: String.

Team Class:
1.Team(String name, String[] players): Constructor. Initializes a team with a name and players.
Return type: Constructor.

2.getName(): Returns the team name.
Return type: String.

3.getPlayers(): Returns the array of players.
Return type: String[].

4.getRunsScored(): Returns the total runs scored by the team.
Return type: int.

5.setRunsScored(int runsScored): Updates the total runs scored by the team.
Return type: void.

6.getWickets(): Returns the total number of wickets fallen for the team.
Return type: int.

7.setWickets(int wickets): Updates the total wickets for the team.
Return type: void.

8.resetScore(): Resets the team's runs and wickets.
Return type: void.


Game Class:
1.Game(Team team1, Team team2, int overs): Constructor. Initializes the game with two teams and the number of overs.
Return type: Constructor.

2.startInning(Team battingTeam, Team bowlingTeam, Player player): Handles an inning by managing overs, wickets, and scoring.
Return type: void.

3.startGame(Player player): Conducts the game, starting with the toss and running both innings.
Return type: void.

4.conductToss(): Simulates a toss and assigns batting/bowling to the teams.
Return type: void.

cricketScoreboard Class:
1.main(String[] args): Entry point of the program, manages team creation, and starts a match.
Return type: void.

2.findTeamByName(String name): Finds and returns a team object by name.
Return type: Team.

Owner: Abhilash Joshi;
Date: 20-9-2024;
 */

import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int runsScored;
    private int ballsFaced;

    public Player(){
    }

    public Player(String name) {
        this.name = name;
        this.runsScored = 0;
        this.ballsFaced = 0;
    }

    public void addRuns(int runs) {
        this.runsScored += runs;
    }

    public void addBallsFaced(int balls) {
        this.ballsFaced += balls;
    }

    public float strikeRate() {
        if (this.ballsFaced == 0) {
            return 0;
        }
        return (this.runsScored * 100.0f) / this.ballsFaced;
    }

    public String getName() {
        return this.name;
    }

    public int getRunsScored() {
        return this.runsScored;
    }

    public int getBallsFaced() {
        return this.ballsFaced;
    }
}


class Team {
    private String name;
    private String[] players = new String[11];
    private int runsScored = 0;
    private int wickets = 0;

    public Team(String name, String[] players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void resetScore() {
        this.runsScored = 0;
        this.wickets = 0;
    }
}

class Game {
    private Team team1;
    private Team team2;
    Team battingTeam;
    Team bowlingTeam;
    private int overs;
    private Scanner input;

    public Game(Team team1, Team team2, int overs) {
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
        this.battingTeam = team1;
        this.bowlingTeam = team2;
        this.input = new Scanner(System.in);
    }

    private Player currentPlayer;

    public void startInning(Team battingTeam, Team bowlingTeam, Player player) {
        currentPlayer = new Player(battingTeam.getPlayers()[0]);
        String striker = battingTeam.getPlayers()[0];
        String nonStriker = battingTeam.getPlayers()[1];
        int currentOver = 1;
        String lastbowler = "";
    
        do {
            System.out.println("Over " + currentOver);
            String bowler;
            do {
                System.out.println("Enter the Bowler for the Over " + currentOver + ": ");
                bowler = input.next();
    
                if (bowler.equals(lastbowler)) {
                    System.out.println("Bowler " + bowler + " cannot bowl consecutive overs. Choose a different bowler.");
                }
            } while (bowler.equals(lastbowler));
    
            lastbowler = bowler;
            int balls = 1;
    
            do {
                System.out.println("Ball " + balls);
                System.out.println("Strike: " + striker + ", Non-Strike: " + nonStriker);
                System.out.println("Enter the type of ball: ");
                System.out.println("1. Regular ball");
                System.out.println("2. Dot ball");
                System.out.println("3. No ball");
                System.out.println("4. Wide ball");
                System.out.println("5. Bye");
                System.out.println("6. Leg bye");
                System.out.println("7. Wicket");
                int ballType = input.nextInt();
    
                switch (ballType) {
                    case 1:
                        System.out.println("Enter the runs scored on this ball: ");
                        int runs = input.nextInt();
                        battingTeam.setRunsScored(battingTeam.getRunsScored() + runs);
                        currentPlayer.addRuns(runs); // Update player's runs scored
                        System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + String.format("%.2f", currentPlayer.strikeRate()) + " strike rate");
                        currentPlayer.addBallsFaced(1); // Update player's balls faced
                        System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        if (runs % 2 != 0) {
                            String temp = striker;
                            striker = nonStriker;
                            nonStriker = temp;
                        }
                        break;
                    case 2:
                        System.out.println("Dot ball, no run to " + battingTeam.getName());
                        currentPlayer.addBallsFaced(1); // Update player's balls faced
                        System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        break;
                    case 3:
                        System.out.println("No ball, 1 run to " + battingTeam.getName());
                        battingTeam.setRunsScored(battingTeam.getRunsScored() + 1);
                        currentPlayer.addRuns(1); // Update player's runs scored
                        currentPlayer.addBallsFaced(1); // Update player's balls faced
                        System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        balls--;
                        break;
                    case 4:
                        System.out.println("Wide ball, 1 run to " + battingTeam.getName());
                        battingTeam.setRunsScored(battingTeam.getRunsScored() + 1);
                        currentPlayer.addRuns(1); // Update player's runs scored
                        currentPlayer.addBallsFaced(1); // Update player's balls faced
                        System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        balls--;
                        break;
                    case 5:
                        System.out.println("Bye, is there any run? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int byeRun = input.nextInt();
                        if (byeRun == 1) {
                            System.out.println("Enter the runs scored on this ball: ");
                            int byeRuns = input.nextInt();
                            battingTeam.setRunsScored(battingTeam.getRunsScored() + byeRuns);
                            currentPlayer.addRuns(byeRuns); // Update player's runs scored
                            currentPlayer.addBallsFaced(1); // Update player's balls faced
                            System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        }
                        break;
                    case 6:
                        System.out.println("Leg bye, is there any run? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int legByeRun = input.nextInt();
                        if (legByeRun == 1) {
                            System.out.println("Enter the runs scored on this ball: ");
                            int legByeRuns = input.nextInt();
                            battingTeam.setRunsScored(battingTeam.getRunsScored() + legByeRuns);
                            currentPlayer.addRuns(legByeRuns); // Update player's runs scored
                            currentPlayer.addBallsFaced(1); // Update player's balls faced
                            System.out.println("Player " + currentPlayer.getName() + " stats: " + currentPlayer.getRunsScored() + " runs, " + currentPlayer.getBallsFaced() + " balls, " + currentPlayer.strikeRate() + " strike rate");
                        }
                        break;
                    case 7:
                        System.out.println("Enter the player who out: ");
                        String playerOut = input.next();
                        System.out.println("Enter the bowler who outs the batsman: ");
                        String bowlerOut = input.next();
                        System.out.println("Enter the type of out: ");
                        System.out.println("1. Hit Wicket");
                        System.out.println("2. Catch");
                        System.out.println("3. LBW");
                        System.out.println("4. Run-out");
                        int outType = input.nextInt();
                        battingTeam.setWickets(battingTeam.getWickets() + 1);
    
                        // Update striker and non-striker after a wicket
                        if (battingTeam.getWickets() < 11) {
                            striker = battingTeam.getPlayers()[battingTeam.getWickets()];
                            nonStriker = battingTeam.getPlayers()[(battingTeam.getWickets() + 1) % 11];
                            currentPlayer = new Player(striker); // Update current player
                        } else {
                            System.out.println("All out");
                            break;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                System.out.println("Score: " + battingTeam.getName() + " - " + battingTeam.getRunsScored() + "/" + battingTeam.getWickets());
                balls++;
            } while (balls <= 6 && battingTeam.getWickets() < 11);
            currentOver++;
        } while (currentOver <= overs && battingTeam.getWickets() < 11);
    }
    public void startGame(Player player) {
        
        conductToss();

        System.out.println("First Innings: " + battingTeam.getName() + " is batting");
        startInning(battingTeam, bowlingTeam, player);
        System.out.println("First innings over. Score: " + battingTeam.getName() + " - " + battingTeam.getRunsScored() + "/" + battingTeam.getWickets());
       
        System.out.println("Second Innings: " + bowlingTeam.getName() + " is batting");
        Team temp = battingTeam;
        battingTeam = bowlingTeam;
        bowlingTeam = temp;
        startInning(battingTeam, bowlingTeam,  player);

        System.out.println("Second innings over. Score: " + battingTeam.getName() + " - " + battingTeam.getRunsScored() + "/" + battingTeam.getWickets());
        
        if (battingTeam.getRunsScored() > bowlingTeam.getRunsScored()) {
            System.out.println(battingTeam.getName() + " wins the match!");
        } else if (battingTeam.getRunsScored() < bowlingTeam.getRunsScored()) {
            System.out.println(bowlingTeam.getName() + " wins the match!");
        } else {
            System.out.println("The match is a tie!");
        }
    }

    private void conductToss() {
        System.out.println("Conducting the toss...");
        Random random = new Random();
        int tossResult = random.nextInt(2); // 0 for team1, 1 for team2
        Team tossWinner = (tossResult == 0) ? team1 : team2;

        System.out.println("Toss winner is: " + tossWinner.getName());
        System.out.println("Select choice:");
        System.out.println("1. Bat");
        System.out.println("2. Bowl");
        int choice = input.nextInt();

        if (choice == 1) {
            battingTeam = tossWinner;
            bowlingTeam = (tossWinner == team1) ? team2 : team1;
        } else {
            bowlingTeam = tossWinner;
            battingTeam = (tossWinner == team1) ? team2 : team1;
        }
    }
}

public class cricketScoreboard {
    private static Team[] teams = new Team[4];
    private static int teamsCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player = new Player();

        int choice;
        do {
            System.out.println("Select options:");
            System.out.println("1. View Teams ");
            System.out.println("2. Add Teams ");
            System.out.println("3. Start Match");
            System.out.println("4. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(teamsCount + " teams created so far");
                    if (teamsCount > 0) {
                        for (int i = 0; i < teamsCount; i++)
                            System.out.println((i + 1) + ". " + teams[i].getName());
                    } else {
                        System.out.println("No teams created yet");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of Team " + (teamsCount + 1) + ": ");
                    String name = input.next();
                    String[] players = new String[11];
                    for (int i = 0; i < 11; i++) {
                        System.out.println("Enter the name of player " + (i + 1) + ": ");
                        players[i] = input.next();
                    }
                    teams[teamsCount] = new Team(name, players);
                    teamsCount++;
                    System.out.println("Team " + (teamsCount) + " created successfully");
                    break;
                case 3:
                    System.out.println("Enter the name of Team 1: ");
                    String team1Name = input.next();
                    Team team1 = findTeamByName(team1Name);
                    if (team1 == null) {
                        System.out.println("Team 1 does not exist.");
                        break;
                    }

                    System.out.println("Enter the name of Team 2: ");
                    String team2Name = input.next();
                    Team team2 = findTeamByName(team2Name);
                    if (team2 == null) {
                        System.out.println("Team 2 does not exist.");
                        break;
                    }

                    System.out.println("Enter the number of overs: ");
                    int overs = input.nextInt();

                    Game game = new Game(team1, team2, overs);
                    game.startGame(player);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while (choice != 4);
        input.close();
    }

    private static Team findTeamByName(String name) {
        for (int i = 0; i < teamsCount; i++) {
            if (teams[i].getName().equals(name)) {
                return teams[i];
            }
        }
        return null;
    }
}
