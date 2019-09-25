package com.management.course.Util;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/12 0:51
 */
public class ExcelUtil {
    public static boolean isExcel2003(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
