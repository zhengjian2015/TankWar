import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y = 200;
    public TankFrame() {
        setSize(800,600);
        setResizable(false);
        setTitle("tank War");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    //显示的时候会调
    @Override
    public void paint(Graphics g) {
        System.out.println("panit");
        //离原点左上角 的距离
        g.fillRect(x,y,50,50);
        x += 10;
        y += 10;
    }


}
