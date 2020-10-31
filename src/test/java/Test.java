import ExcelNeed.Entity.Cat;
import ExcelNeed.Entity.Cats;
import ExcelNeed.Utils.GetFileUtils;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxx
 * @date 2020/10/21 12:54
 */
public class Test {
    public static void main(String args[]){
        GetFileUtils fileUtils = new GetFileUtils();
        /**jxl读取excel文件异常：Unable to recognize OLE stream 的解决方法
         * 1.使用jxl方式读取，可能只能支持xls格式的文件，对于xlsx格式就不再支持
         * 修改文件时不要直接修改文件名，打开文件另存为xls格式*/
        fileUtils.setFile(new File("src/main/java/ExcelNeed/File/demo.xls"));

        try {
            Cat cat = new Cat();
            //通过反射机制来获取对象
            List<Map<String, Object>> maps = fileUtils.dealData(fileUtils.getFile(),cat);
            System.out.println(maps);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("cats",maps);
            Cats cats = JSON.parseObject(JSON.toJSONString(result),Cats.class);
            /**问题
             * 由excel读取的数据必须严格遵守实体类的命名，且中间不能有其他的属性，否则顺延报错
             * JSON.parseObject(JSON.toJSONString(map),Cat.class)*/
            for (Cat catsCat : cats.getCats()) {
                System.out.println(catsCat);
            }
            System.out.println(cats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
