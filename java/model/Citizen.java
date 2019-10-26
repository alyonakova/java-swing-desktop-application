package model;

public class Citizen extends Shorty {
    private static int count = 1;

    public Citizen() {
        super("Shorty #" + count++ + " ");
    }

    public void tellGoodbye() {
        class UpdateMessage {
            private String message;

            public UpdateMessage(String message) {
                this.message = message + " " + "See you!";
            }

            public String getMessage() {
                return message;
            }
        }
        System.out.println(new UpdateMessage("Goodbye, my friend!").getMessage());
    }
}
