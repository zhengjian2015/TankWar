
public class Main{
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        //需要调repaint刷新
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
