package com.zj.tank;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 7;

    //private static int WIDTH = 20, HEIGHT = 20;

    private int x, y;

    private Dir dir;

    private boolean living = true;

    private TankFrame tf = null;

    private Group group;

    Rectangle rect = new Rectangle();

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();



    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
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


        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    //子弹和坦克碰撞
    public void collideWith(Tank tank) {
        //敌人才会碰撞
        if(this.group == tank.getGroup()) return;
        //子弹的方块
        //TODO 用一个rect来记录子弹的位置 否则垃圾收集器运行频繁 影响性能
        //-Xmx10m -Xms10m -XX:+PrintGC 后发现轻GC从三次变为了两次
        //两个方块相交 敌人才会碰撞
        if(this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            //爆炸效果
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
