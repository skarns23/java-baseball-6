package baseball;

public class Application {

    public static boolean isComputer = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Player computer = new Player(isComputer);
            System.out.println(computer.getNumberList().toString());
            Player player = new Player(!isComputer);
            System.out.println(player.getNumberList());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }
    }


}
