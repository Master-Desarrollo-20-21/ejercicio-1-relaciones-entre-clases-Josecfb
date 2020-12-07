class Mastermind {
	private Attempt[] attempts;
	private SecretCombination secretCombination;
	private int attemptCounter;
	private final int MAX_ATTEMPT=10;
	
	private Mastermind() {
		new Console().write("----- MASTERMIND -----");
		this.attempts=new Attempt[MAX_ATTEMPT];
		this.secretCombination=new SecretCombination();
		this.attemptCounter=0;
	}
	
	private static void play() {
		Mastermind game = new Mastermind();
		Attempt attempt;
		new Console().write(game.secretCombination.toString());
		do {
			
			attempt=new Attempt(game.secretCombination);
			game.attempts[game.attemptCounter]=attempt;
			game.attemptCounter++;
			game.showAttemps();
		}while (game.attemptCounter<10 && !attempt.isWinner()); 
		Console console=new Console();
		if (attempt.isWinner()) {
			console.write("You win");
		}else {
			console.write("Has perdio");
		}
	}
	
	private void showAttemps() {
		Console console=new Console();
		for (int i=0;i<attemptCounter;i++) {
			console.write(attempts[i].toString());	
		}
	}

	public static void main(String[] args) {
		do {
			play();
		} while (resume());
		
	}

	private static boolean resume() {
		return new Console().read("RESUME? (y/n):").equals("y");
	}

}