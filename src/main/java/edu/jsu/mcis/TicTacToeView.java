package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		
		System.out.print("\n  ");

		for(int i = 0; i < model.getWidth(); i++){

			System.out.print(i);

		}

		System.out.println();

        for(int i = 0; i < model.getWidth(); i++){

            System.out.print(i + " ");

            for (int j = 0; j < model.getWidth(); j++){

                System.out.print(model.getMark(i, j));

            }

System.out.println();
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		System.out.println("Enter the row and column number, seperated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
	 System.out.println("Input error, try again");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");
	     

    }
	
}
