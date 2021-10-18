import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Dan Nirel
 */
class ChatterBot {
    static final String REQUEST_PREFIX = "say ";
    static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
    static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

    String name;
    Random rand = new Random();
    String[] repliesToIllegalRequest;
    String[] repliesToLegalRequest;

    String getName() {
        return name;
    }

    ChatterBot(String name,
               String[] repliesToLegalRequest,
               String[] repliesToIllegalRequest) {
        this.name = name;
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }

        this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
        for(int i = 0 ; i < repliesToLegalRequest.length ; i = i+1) {
            this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
        }
    }


    String replacePlaceholderInARandomPattern(String[] possibleReplies,
                                              String placeholder,
                                              String statement) {
        int randomIndex = rand.nextInt(possibleReplies.length);
        String responsePattern = possibleReplies[randomIndex];
        return responsePattern.replaceAll(placeholder, statement);
    }

    String respondToLegalRequest(String statement) {
        //we don’t repeat the request prefix, so delete it from the reply
        String phrase = statement.replaceFirst(REQUEST_PREFIX, "");
        return replacePlaceholderInARandomPattern(repliesToLegalRequest,
                REQUESTED_PHRASE_PLACEHOLDER,
                phrase);
    }

    String respondToIllegalRequest(String statement) {
        return replacePlaceholderInARandomPattern(repliesToIllegalRequest,
                ILLEGAL_REQUEST_PLACEHOLDER,
                statement);
    }

    String replyTo(String statement) {
        if(statement.startsWith(REQUEST_PREFIX)) {
            return respondToLegalRequest(statement);
        }
        return respondToIllegalRequest(statement);
    }
}
