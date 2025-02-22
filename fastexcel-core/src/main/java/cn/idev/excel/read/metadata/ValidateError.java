package cn.idev.excel.read.metadata;

import cn.idev.excel.exception.ExcelDataConvertException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Validation error message
 *
 * @author wangmeng
 */
@Getter
@Setter
@EqualsAndHashCode
public class ValidateError {

    /**
     * rowNum
     */
    private Integer rowNum;

    /**
     * headName
     */
    private String headName;

    /**
     * message
     */
    private String message;

    /**
     * Record whether it was caused by  {@link ExcelDataConvertException}
     */
    private boolean convertError = false;

}
