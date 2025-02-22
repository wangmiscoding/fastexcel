package cn.idev.excel.read.listener;


import cn.idev.excel.context.AnalysisContext;

/**
 * validate read listener
 *
 * @author wangmeng
 */
public class ValidateReadListener<T> implements ReadListener<T> {

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        ReadListener.super.onException(exception, context);
    }

    @Override
    public void invoke(T data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
