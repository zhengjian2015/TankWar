package com.zj.tank.abstractfactory;

import com.zj.tank.Dir;
import com.zj.tank.Group;
import com.zj.tank.TankFrame;

public class RectFactory extends GameFactory  {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }
}
