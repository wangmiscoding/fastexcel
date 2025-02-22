package cn.idev.excel.read.listener;


import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.metadata.Head;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.read.metadata.property.ExcelReadHeadProperty;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * validate read listener
 *
 * @author wangmeng
 */
public class ValidateReadListener<T> implements IgnoreExceptionReadListener<T> {


    private boolean existValidate;

    private Set<Field> fieldSet = new HashSet<>();

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
    }


    /**
     * Initialize all fields that require validation
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        ExcelReadHeadProperty excelReadHeadProperty = context.currentReadHolder().excelReadHeadProperty();
        for (Head head : excelReadHeadProperty.getHeadMap().values()) {
            Field field = head.getField();
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
            if (excelProperty != null && !excelProperty.notNull()) {
                fieldSet.add(field);
            }
        }
        if (fieldSet.isEmpty()) {
            existValidate = false;
        }
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        if(existValidate){
            for (Field field : fieldSet) {
                field.get(data);
            }

        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
