package Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaper_Scissor extends JFrame implements ActionListener {

    // Components for the GUI
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel, computerChoiceLabel, userChoiceLabel;
    private Random random;

    public RockPaper_Scissor() {
        // Set up the window
        setTitle("Rock Paper Scissors Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Creating buttons for the user's choices
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Creating labels to display results
        resultLabel = new JLabel("Choose Rock, Paper, or Scissors.");
        computerChoiceLabel = new JLabel("Computer chose: ");
        userChoiceLabel = new JLabel("You chose: ");

        // Adding buttons and labels to the frame
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(userChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);

        // Add action listeners to buttons
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Initializing random object for the computer's choice
        random = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the user's choice
        String userChoice = "";
        if (e.getSource() == rockButton) {
            userChoice = "rock";
        } else if (e.getSource() == paperButton) {
            userChoice = "paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "scissors";
        }

        // Get the computer's choice
        String[] choices = {"rock", "paper", "scissors"};
        String computerChoice = choices[random.nextInt(3)];

        // Displaying the user's and computer's choices
        userChoiceLabel.setText("You chose: " + userChoice);
        computerChoiceLabel.setText("Computer chose: " + computerChoice);

        // Determining the result
        String result;
        if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            result = "You win!";
        } else {
            result = "Computer wins!";
        }

        // Displaying the result
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        // Creating and displaying the game window
        RockPaper_Scissor game = new RockPaper_Scissor();
        game.setVisible(true);
    }
}
