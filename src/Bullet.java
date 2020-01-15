import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 5;

    private static int WIDTH = 20, HEIGHT = 20;

    private int x, y;

    private Dir dir;

    private boolean live = true;

    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!live) {
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        //可以这样理解把 笔粘一下红的，画出东西，再把笔恢复成原来的颜色
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
