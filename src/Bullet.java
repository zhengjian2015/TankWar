import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 5;

    //private static int WIDTH = 20, HEIGHT = 20;

    private int x, y;

    private Dir dir;

    private boolean living = true;

    private TankFrame tf = null;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!living) {
            tf.bullets.remove(this);
        }

        switch (dir) {
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
        }

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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    //子弹和坦克碰撞
    public void collideWith(Tank tank) {
        //子弹的方块
        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //坦克的方块
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        //两个方块相交
        if(rect1.intersects(rect2)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
