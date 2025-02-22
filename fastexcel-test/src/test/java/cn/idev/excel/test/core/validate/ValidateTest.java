package cn.idev.excel.test.core.validate;

import cn.idev.excel.FastExcel;
import cn.idev.excel.read.listener.PageReadListener;
import cn.idev.excel.test.demo.read.DemoData;
import cn.idev.excel.test.util.TestFileUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangmeng
 * @since 2025/2/22
 */
@Slf4j
public class ValidateTest {


    @Test
    public void testCheckRead() {
        String fileName = TestFileUtil.getPath() + "checkRead"  + ".xlsx";

        FastExcel.read(fileName).head(DemoData.class).registerReadListener(new PageReadListener<DemoData>(list->{
            log.info("导入数据:{}", JSON.toJSONString(list));
        })).sheet().doReadSync();

    }

    private void createExcel(){
        String fileName = TestFileUtil.getPath() + "checkRead"  + ".xlsx";
        FastExcel.write(fileName, DemoData.class).sheet().doWrite(data());
    }

    private List<DemoData> data() {
        List<DemoData> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setDoubleData((double) i * 1000);
            data.setString("文本" + i);
            data.setDate(new Date());
            list.add(data);
        }
        return list;
    }

}
