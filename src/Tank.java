import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    //要想在tank内部把子弹画出来，需要有窗口的引用
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private boolean moving = false;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        //可以这样理解把 笔粘一下红的，画出东西，再把笔恢复成原来的颜色
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,50,50);
        g.setColor(c);
        move();
    }

    private void move() {
        if (moving)
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
    }

    public void fire() {
        tf.b = new Bullet(this.x,this.y,this.dir);
    }

}
