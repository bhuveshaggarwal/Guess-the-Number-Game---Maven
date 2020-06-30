package bhuvesh.javaspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

//    == constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

//    == fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

//    == init ==
    @PostConstruct
    public void init(){
        log.info("Game = {}", game);
    }

//    == public methods ==

    @Override
    public String getMainMessage() {
        return "Number is Between " + game.getSmallest() + " and " + game.getBiggest() +
                " Can you Guess it ?" ;
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return "You guessed it! The Number was " + game.getNumber();
        } else if(game.isGameLost()){
            return "You Lost! The Number was" + game.getNumber();
        } else if(!game.isValidNumberRange()){
            return "Invalid Number Range";
        } else if(game.getRemainingGuesses() == guessCount){
            return "What is your First Guess ?";
        } else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You Have " +game.getRemainingGuesses() + " Guess Left ";
        }
    }
}