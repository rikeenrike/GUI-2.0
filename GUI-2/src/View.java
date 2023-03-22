import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class View extends JFrame {
      
       //SIZE
       private static final int FRAME_WIDTH=500;
       private static final int FRAME_HEIGHT=500;
       private static final int FRAME_X_ORIGIN=150;
       private static final int FRAME_Y_ORIGIN=250;

      //Declarations
      private JLabel studidviewlabel;
      private JTextField Tfstudview;
      private JButton buttonview;
      private viewbuthandler viewhandler;
      
       //Json
       static JSONObject folder;
       static JSONArray list;
       static JSONObject info;
       static JSONParser jsonParser;
       
    static void reader() throws IOException, ParseException, org.json.simple.parser.ParseException{
        FileReader reader = new FileReader("");
        if (reader.ready()) {
            Scanner collect = new Scanner(reader);
            String line = "";
            while(collect.hasNext()){
                line = line + collect.nextLine();
            }
            if (!line.equals("src\\STUDLIST.json")) {
                reader.close();
                FileReader reader2 = new FileReader("src\\STUDLIST.json");
                folder = (JSONObject) jsonParser.parse(reader2);
                list = (JSONArray) folder.get("folder");
            }
        }
        reader.close();
    }
    static void writer() throws IOException {
        FileWriter writer = new FileWriter("src\\STUDLIST.json");
        writer.write(folder.toJSONString());
        writer.close();
    }
    public void createComp(){

          studidviewlabel = new JLabel("Student ID to View: ");
          Tfstudview = new JTextField(10);
          buttonview = new JButton("View");
      }

      public void setComp(){
          Container pane = getContentPane();
          
          pane.setLayout(new GridLayout(2,2));

          pane.add(studidviewlabel);
          pane.add(Tfstudview);
          pane.add(buttonview);

          viewhandler = new viewbuthandler();
          buttonview.addActionListener(viewhandler);

      
      }
      public View(){
          //FRAME
          setTitle("View");
          setSize(FRAME_WIDTH,FRAME_HEIGHT);
          setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
          setDefaultCloseOperation(HIDE_ON_CLOSE);
          setVisible(true);
      }
      
      private class viewbuthandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                reader();
            } catch (IOException | ParseException | org.json.simple.parser.ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

        
      }
      public static void main(String[] args) {
          View view = new View();
              view.createComp();
              view.setComp();
      }

}
