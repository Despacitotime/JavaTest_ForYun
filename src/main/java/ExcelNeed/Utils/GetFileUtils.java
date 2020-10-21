package ExcelNeed.Utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxx
 * @date 2020/10/21 9:52
 */
public class GetFileUtils {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "GetFileUtils{" +
                "file=" + file +
                '}';
    }

    /**
     * 获取数据
     * @return
     * @throws Exception
     */
    public List<List<String>> getFile() throws Exception {
        //创建输入流,读取Excel
        InputStream is = new FileInputStream(file.getAbsolutePath());
        //jxl提供的Workbook类
        Workbook wb = Workbook.getWorkbook(is);
        //创建sheet对象，一般输入只有一个sheet；多个sheet此处暂不考虑
        Sheet sheet = wb.getSheet(0);
        //得到所有行数
        int rows = sheet.getRows();
        //查看是否读取数据
        /*System.out.println(rows);*/
        //得到所有数据
        List<List<String>> allData = new ArrayList<List<String>>();
        //从第二行开始，因为第一行是列名
        for(int j = 1;j < rows;j++){
            List<String> oneData = new ArrayList<String>();
            //得到每一行的单元格的数据
            Cell[] cells = sheet.getRow(j);
            for(int k = 0;k < cells.length;k++){
                oneData.add(cells[k].getContents().trim());
            }
            //存储每一条数据
            allData.add(oneData);
            //打印检查结果
            System.out.println(oneData);
        }
        /**下为结果示例：
         * [[3, 20, adsfsadf, 12321sa, 11111111111, 42, 男, 54, 0, xxx, 王qq]]*/
        return allData;
    }

    /**
     * 处理数据
     * @param allData
     * @return List<List<String>>*/
    public List<Map<String, Object>> dealData(List<List<String>> allData, Object object){
        // 获得该类的所有属性
        Class classes = object.getClass();
        Field[] fields = classes.getDeclaredFields();
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

        /**要求：此时表格内每一列的顺序必须和实体类的顺序一致*/
        for (int i = 0;i < allData.size();i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            for(int j = 0;j < allData.get(0).size();j++){
                map.put(fields[j].getName(),allData.get(i).get(j));
            }
            results.add(map);
        }
        /*System.out.println(results);*/
        return results;
    }

    /**
     * 写入数据*/
    public void writeExcel(List<List<String>> result,String sheetName){
        //创建一个Workbook对应的excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //在sheet表中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        /*此处应该工具化，基本语句有：
        * cell.setCellValue("");//依次写每列表头
          cell=row.createCell(1);*/
        //写入数据
        for(int i =0;i < result.size();i++){
            List<String> oneData = result.get(i);
            HSSFRow row1 = sheet.createRow(i+1);
            for (int j = 0;j < oneData.size();j++){
                row1.createCell(j).setCellValue(oneData.get(j));
            }
        }
        //将文件保存
        try {
            FileOutputStream fos = new FileOutputStream("");
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
