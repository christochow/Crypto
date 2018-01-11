import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public void encrypt(File file){
        try {
            ArrayList<ArrayList<Integer>> li = new ArrayList<>();
            BufferedReader f = new BufferedReader(new FileReader(file));
            String input = f.readLine();
            ArrayList<Integer> list;
            if (input != null) {
            do {
                list = new ArrayList<>();
                if(input.length()==0){list.add(-1);}
                else {
                    for (int i = 0; i < input.length(); i++) {
                        char a = input.charAt(i);
                        int b = (int) a;
                        b = b * 20 - 3;
                        list.add(b);
                    }
                }
                li.add(list);
                input = f.readLine();
            }while (input!=null);}
            f.close();
            System.out.println(li.size());
            FileWriter wr = new FileWriter(file);
            String re="";
            for(ArrayList<Integer> k :li){
                for(int l :k){
                    re = ","+l;
                }
                wr.write(re+"\n");
            }
            wr.close();
        }catch(IOException e){
            System.out.println(e);
        }
        }
    public static void main(String[] args) {
            //String inp = JOptionPane.showInputDialog("Enter file path of file you wanted to encrypt");
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            Main main = new Main();
            main.encrypt(file);
    }
}
