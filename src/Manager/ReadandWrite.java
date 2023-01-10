package Manager;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadandWrite {
    public void writefile(List<Product> list) {
        try {
            FileWriter fw = new FileWriter("D:\\untitled4\\modul2\\thuchanhMODUL2\\src\\Product.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product p : list) {
                bw.write(p.toString());
                bw.newLine();

            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> read() {
        List<Product> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\untitled4\\modul2\\thuchanhMODUL2\\src\\Product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("----");
        }
        return list;
    }
}
