package med;
import java.awt.*;

@SuppressWarnings("serial")
public class Balloon extends Component implements Runnable{

    Container parent;
    double dx, dy;

    public Balloon(Container parent) {
        super();
        this.parent = parent;
        int x = (int)Math.round(Math.random()*parent.getWidth());
        int y = (int)Math.round(Math.random()*parent.getHeight());
        setLocation(x,y);
        init();
    }

    public void init() {
        setSize(25, 25);
        Double r = getDistance(getLocation(), new Point(0,0));
        dx=4*getX()/r;
        dy=4*getY()/r;
        (new Thread(this)).start();
    }
    public double getDistance(Point p1, Point p2) {
        double r = Math.sqrt( Math.pow(p1.x - p2.x,2) + Math.pow(p1.y - p2.y,2) );
        return r;
    }

    public void reflect(Balloon c, Component parent) {
        if (c.getX() >= parent.getWidth()-c.getWidth()) {
            c.dx = -c.dx;
            c.setLocation(parent.getWidth()-c.getWidth(), c.getY());
        }
        if (c.getY() >= parent.getHeight()-c.getHeight()) {
            c.dy = -c.dy;
            c.setLocation(c.getX(),parent.getHeight()-c.getHeight());
        }
        if (c.getX()<=0) {
            c.dx = -c.dx;
            c.setLocation(0,getY());
        }
        if (c.getY()<=0) {
            c.dy = -c.dy;
            c.setLocation(getX(),0);
        }
    }

    public void cooperate(Balloon c, Balloon d) {
        if (getDistance(c.getLocation(),d.getLocation()) <= c.getWidth()) {
            c.dx = -c.dx;
            c.dy = -c.dy;
            d.dx = -d.dx;
            d.dy = -d.dy;
        }
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
    	setSize(10, 10);
    	g.setColor(Color.BLACK);
        //System.out.println(" " + getWidth() + " " +getHeight());
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void run() {
        while (true) {
            try {Thread.sleep(60);}
            catch (Exception e) {}
            for (int i = 0; i < parent.getComponentCount(); i++) {
                Balloon ball = (Balloon)parent.getComponent(i);
                if (ball!=this) {
                    cooperate(this,ball);
                }
            }
            setLocation((int)Math.round(getX()+dx),(int)Math.round(getY()+dy));
            reflect(this,parent);
            parent.repaint();
        }
    }
}
