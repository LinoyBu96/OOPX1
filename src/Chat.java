//linoy gitest no
import java.util.Scanner;

public class Chat {

    public static void main(String[] args) {

        String[][] repliesToIllegalRequest = {
                {"what ", "say I should say "},
                {"whaaat ", "say say "}};
        ChatterBot[] bots = {
                new ChatterBot("Lilo", repliesToIllegalRequest[0]),
                new ChatterBot("Stitch", repliesToIllegalRequest[1])};

        Scanner scanner = new Scanner(System.in);
        String statement = scanner.nextLine();
        while (true) {
            for (ChatterBot bot: bots) {
                statement = bot.replyTo(statement);
                System.out.print(statement);
                scanner.nextLine();
            }
        }
    };

}
