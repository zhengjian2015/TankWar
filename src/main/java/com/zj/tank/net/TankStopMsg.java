package com.zj.tank.net;

import com.zj.tank.Tank;
import com.zj.tank.TankFrame;

import java.util.UUID;

public class TankStopMsg extends Msg {
    UUID id;
    int x, y;

    public TankStopMsg(Tank t) {
        this.id = t.getId();
        this.x = t.getX();
        this.y = t.getY();
    }

    public TankStopMsg(UUID id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public TankStopMsg() {}
    /**
     * 处理业务逻辑
     */
    @Override
    public void handle() {
        //if this msg is send by myself do nothing
        if (this.id.equals(TankFrame.INSTANCE.getMainTank().getId()))
            return;

        Tank t = TankFrame.INSTANCE.findTankByUUID(this.id);

        if (t != null) {
            t.setMoving(false);
            t.setX(this.x);
            t.setY(this.y);
        }

    }

    @Override
    public byte[] toBytes() {
        return new byte[0];
    }

    @Override
    public void parse(byte[] bytes) {

    }

    @Override
    public MsgType getMsgType() {
        return null;
    }
}
