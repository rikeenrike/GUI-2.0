import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame{
    
    private static final int FRAME_WIDTH=500;
    private static final int FRAME_HEIGHT=500;
    private static final int FRAME_X_ORIGIN=150;
    private static final int FRAME_Y_ORIGIN=250;

    private JMenuBar menubar;
    private JMenu menu1, menu2, viewitem;
    private JMenuItem additem, delitem,  item4, item5, item6, item7, indiview, viewall;
    private ImageIcon addimage;
    private addmenuhandler addhandler;
    private delmenuhandler delhandler;
    private viewmenuhandler viewhandler;
    private static JLabel relayresult;
    
    public void createFrameComp(){
        relayresult = new JLabel("", SwingConstants.CENTER);
    }

    public void setFrameComp(){
        
        Container pane = getContentPane();

        pane.setLayout(new GridLayout(1,1));

        pane.add(relayresult);
    }

    public static void setresults(int x){
        relayresult.setText("sum is " + x);
    }
    private void jmenucomp(){
        menubar = new JMenuBar();
            menu1 = new JMenu("Student Management");
            menu1.setMnemonic(KeyEvent.VK_C);
            
            additem = new JMenuItem("Add Student");
            addhandler = new addmenuhandler();
            additem.addActionListener(addhandler);
            
            delitem = new JMenuItem("Delete Student");
            delhandler = new delmenuhandler();
            delitem.addActionListener(delhandler);

            
            viewitem = new JMenu("View Student");
                indiview = new JMenuItem("Individual View");
                viewhandler = new viewmenuhandler();
                indiview.addActionListener(viewhandler);
                
                viewall = new JMenuItem("View All");
            viewitem.add(indiview);
            viewitem.add(viewall);

            menu1.add(additem);
            menu1.add(delitem);
            menu1.add(viewitem);
            menubar.add(menu1);
            setJMenuBar(menubar);

 }
 public void framesettings(){
    setTitle("MY OPTIONS"); 
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    
    getContentPane().setBackground(new Color(255, 153 ,204));
 }
 
  private class addmenuhandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        App app = new App();
        app.createComp();
        app.setComp();
       
    }
}
    private class delmenuhandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Delete del = new Delete();
            del.createComp();
            del.setComp();

        }

    }
    private class viewmenuhandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            View view = new View();
            view.createComp();
            view.setComp();
        }
    }

 
 public static void main(String[] args) {
    
    menu x  = new menu();
        x.jmenucomp(); 
        x.createFrameComp();
        x.setFrameComp();
        x.framesettings();

 }
}


