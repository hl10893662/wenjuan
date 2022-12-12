package com.eno.baozi.data.sync.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;

@Service
public class CriminalInfoSyncService {

    @Value("${sync.source.url}")
    private String sourceUrl;
    @Value("${sync.source.username}")
    private String sourceUsername;
    @Value("${sync.source.password}")
    private String sourcePassword;
    @Value("${sync.source.driver}")
    private String sourceDriver;

    @Value("${sync.target.url}")
    private String targetUrl;
    @Value("${sync.target.url}")
    private String targetUsername;
    @Value("${sync.target.url}")
    private String targetPassword;
    @Value("${sync.target.url}")
    private String targetDriver;



    //SqlServer2000
//    private final static String URL_SOURCE = "jdbc:sqlserver://10.76.15.111:1433;DatabaseName=JGXT";
//    private static final String USER_SOURCE = "sa";
//    private static final String PASSWORD_SOURCE = "sa";
//    private static final String DRIVER_SOURCE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";


    //mysql
//    public static final String URL_TARGET = "jdbc:mysql://127.0.0.1/phone?useUnicode=yes&characterEncoding=GBK";
//    public static final String USER_TARGET = "root";
//    public static final String PASSWORD_TARGET = "root";
//    public static final String DRIVER_TARGET = "com.mysql.jdbc.Driver";





    public void sync(){
        timerAction();
    }
    public  void timerAction() {
        getData2();
        resetTimes();
    }

    public ResultSet getData2() {
        //执行数据获取操作
        Connection con = null;	// 创建一个数据库连接
        PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;	// 创建一个结果集对象
        try {
            Class.forName(sourceDriver);// 加载Oracle驱动程序
            System.out.println("开始尝试连接源数据库，执行数据获取操作getdate2！");

            con = DriverManager.getConnection(sourceUrl, sourceUsername, sourcePassword);	// 获取连接
            System.out.println("数据源连接成功！getdate2");
            String sql = "select t.BH,t.XM,t.SYZM,t.DB,t.ZR,t.JTDZ,t.FGDJ,t.DRRQ,t.XQ from VW_YWGK_DA_JBXX t";	// 预编译语句，“？”代表参数
            pre = con.prepareStatement(sql);	// 实例化预编译语句
            result = pre.executeQuery();	// 执行查询，注意括号中不需要再加参数
            importData2(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                //if (result != null)
                //    result.close();
                if (pre != null){
                    pre.close();
                }
                if (con != null){
                    con.close();
                }
                System.out.println("源数据库连接已关闭getdate2！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public  String importData2(ResultSet result) {

        Connection con = null;	// 创建一个数据库连接
        Statement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
        System.out.println("走到这一步importData2！");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        try {
            Class.forName(targetDriver);	// 加载Oracle驱动程序
            System.out.println("开始尝试连接目标数据库，执行导入操作importData2！");
            con = DriverManager.getConnection(targetUrl, targetUsername, targetPassword);	// 获取连接
            System.out.println("目标数据库连接成功importData2！");

            pre = con.createStatement();
            pre.addBatch("delete from user_info");

//            String string = new String(rs.getString(i)).getBytes("utf-8"), "gbk");

            int num = 0;
            while (result.next()) {
                String zr=result.getString("ZR");
                String drrq=result.getString("DRRQ");
                if("".equals(zr)){
                    zr="2099.00.00";

                }
                if("".equals(drrq)){
                    zr="1000.00.00";

                }
                String regex = "(.{2})";
                String sql = "insert into user_info(no, name, crime, groupno,biggroupno, imprison_end, address, " + " process_level,imprison_begin,imprison_date) "
                        + " values('"
                        + result.getString("BH")
                        + "','"
                        + result.getString("XM")
                        + "','"
                        + result.getString("SYZM")
                        + "','"
                        + result.getString("DB")
                        + "','"
                        + result.getString("DB")
                        + "','"
                        + zr
                        + "','"
                        + result.getString("JTDZ")
                        + "','"
                        + result.getString("FGDJ")
                        + "','"
                        + drrq
                        + "','"
                        + result.getString("XQ")
                        //replaceAll(',','2099.00.00')
                        + "')";
                System.out.println(sql);
                System.out.println("这是最新的importData2!");

                pre.addBatch(sql);

                num = num + 1;
            }

            pre.executeBatch();
            pre.clearBatch();
            pre.close();
            System.out.println("插入成功" + num + "条数据importData2");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null){
                    result.close();
                }

                if (pre != null){
                    pre.close();
                }
                if (con != null){
                    con.close();
                }
                System.out.println("omp数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }



    public void resetTimes() {
        Connection con = null;	// 创建一个数据库连接
        PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;	// 创建一个结果集对象
        try {
            Class.forName(targetDriver);// 加载Oracle驱动程序
            System.out.println("开始尝试连接目标数据库，执行resettime操作！");

            con = DriverManager.getConnection(targetUrl, targetUsername, targetPassword);	// 获取连接
            System.out.println("目标数据库连接成功！");
            String sql2 = "update user_info set imprison_end = '2099-00-00 00:00:00' where imprison_end='null' or imprison_end='0000-00-00 00:00:00' or imprison_end=','";
            String sql3 = "update user_info set imprison_begin = '1000-00-00 00:00:00' where imprison_end='null' or imprison_end='0000-00-00 00:00:00'";
            String sql4 ="update user_info set process_level='空' where process_level='null'";
            String sql11="update user_info set groupno='医院' where groupno='老残队'";
            String sql12="update user_info set biggroupno='医院' where biggroupno='老残队'";
            String sql13 = " update user_info a set a.biggroupno = (select b.department from group_info b where a.groupno = b.name )";

            pre = con.prepareStatement(sql2);
            pre.execute();
            pre = con.prepareStatement(sql3);
            pre.execute();
            pre = con.prepareStatement(sql4);
            pre.execute();
            pre = con.prepareStatement(sql11);
            pre.execute();
            pre = con.prepareStatement(sql12);
            pre.execute();
            pre = con.prepareStatement(sql13);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null){
                    result.close();
                }
                if (pre != null){
                    pre.close();
                }
                if (con != null){
                    con.close();
                }
                System.out.println("目标数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
