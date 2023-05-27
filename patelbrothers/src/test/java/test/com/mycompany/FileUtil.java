/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.mycompany;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author swetu
 */
public class FileUtil {

    public static Login readForm1() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("c:\\Data\\Signin.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstsheet = workbook.getSheetAt(0);
//Row 1

        Row r1 = firstsheet.getRow(1);
        Cell c1 = r1.getCell(0);
        String username_c = c1.getStringCellValue();
        System.out.println("username_c" + username_c);

        c1 = r1.getCell(1);
        String password_c = c1.getStringCellValue();
        System.out.println("password_c" + password_c);

        Login login1 = new Login(username_c, password_c);
        return login1;
    }

    public static Login readForm2() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("c:\\Data\\Signin.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstsheet = workbook.getSheetAt(0);
//Row 2    
        Row r2 = firstsheet.getRow(2);
        Cell c2 = r2.getCell(0);
        String c_username = c2.getStringCellValue();
        System.out.println("c_username" + c_username);

        c2 = r2.getCell(1);
        String password_i = c2.getStringCellValue();
        System.out.println("password_i" + password_i);
        Login login2 = new Login(c_username, password_i);
        return login2;
    }
    
    
    public static Login readForm3() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("c:\\Data\\Signin.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstsheet = workbook.getSheetAt(0);
//Row 3  
        Row r3 = firstsheet.getRow(3);
        Cell c3 = r3.getCell(0);
        String username_i = c3.getStringCellValue();
        System.out.println("username_i" + username_i);
        
        c3 = r3.getCell(1);
        String c_password = c3.getStringCellValue();
        System.out.println("c_password" + c_password);
        Login login3 = new Login(username_i, c_password);
        return login3;
    }

 
    public static Login readForm4() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("c:\\Data\\Signin.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstsheet = workbook.getSheetAt(0);
 // Row 4
        Row r4 = firstsheet.getRow(4);
        Cell c4 = r4.getCell(0);
        String i_username = c4.getStringCellValue();
        System.out.println("i_username" + i_username);
        
        c4 = r4.getCell(1);
        String i_password = c4.getStringCellValue();
        System.out.println("i_password" + i_password);
       
        Login login4 = new Login(i_username, i_password);
        return login4;
    }
    
     public static Login readForm5() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("c:\\Data\\Signin.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstsheet = workbook.getSheetAt(0);
 // Row 5
        Row r5 = firstsheet.getRow(5);
        Cell c5 = r5.getCell(0);
        String e_username = c5.getStringCellValue();
        System.out.println("e_username" + e_username);
        
        c5 = r5.getCell(1);
        String e_password = c5.getStringCellValue();
        System.out.println("e_password" + e_password);
       
        Login login5 = new Login(e_username, e_password);
        return login5;
    }

}
