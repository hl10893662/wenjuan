package com.eno.baozi.data.sync.task;

import com.eno.baozi.data.sync.schedule.CriminalInfoSyncSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;

@Service
public class CriminalInfoSyncService1 {

    private final Logger logger = LoggerFactory.getLogger(CriminalInfoSyncService1.class);

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
    @Value("${sync.target.username}")
    private String targetUsername;
    @Value("${sync.target.password}")
    private String targetPassword;
    @Value("${sync.target.driver}")
    private String targetDriver;
    static boolean simpleLock = false;
    public void sync(){
        if (simpleLock){
            logger.info("同步中，本次忽略");
            return ;
        }
        simpleLock = true;
        try{
            //执行数据获取操作
            Connection con = null;	// 创建一个数据库连接
            PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
            ResultSet result = null;	// 创建一个结果集对象
            try {
                Class.forName(sourceDriver);// 加载Oracle驱动程序
                logger.info("开始尝试连接源数据库，执行数据获取操作getdate2！");

                con = DriverManager.getConnection(sourceUrl, sourceUsername, sourcePassword);	// 获取连接
                logger.info("数据源连接成功！getdate2");
                String sql = "select no, name, crime, groupno,biggroupno, imprison_end, address, process_level,imprison_begin,imprison_date from user_info t";	// 预编译语句，“？”代表参数
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
                    logger.info("源数据库连接已关闭getdate2！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception ee){

        }finally {
            simpleLock = false;
        }

    }

    public  String importData2(ResultSet result) {

        Connection con = null;	// 创建一个数据库连接
        Statement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
        logger.info("走到这一步importData2！");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        try {
            Class.forName(targetDriver);	// 加载Oracle驱动程序
            logger.info("开始尝试连接目标数据库，执行导入操作importData2！");
            con = DriverManager.getConnection(targetUrl, targetUsername, targetPassword);	// 获取连接
            logger.info("目标数据库连接成功importData2！");

            pre = con.createStatement();
            pre.addBatch("delete from user_info");

//            String string = new String(rs.getString(i)).getBytes("utf-8"), "gbk");

            int num = 0;
            while (result.next()) {
//                String zr=result.getString("ZR");
//                String drrq=result.getString("DRRQ");
//                if("".equals(zr)){
//                    zr="2099.00.00";
//
//                }
//                if("".equals(drrq)){
//                    zr="1000.00.00";
//
//                }
                String regex = "(.{2})";
                String sql = "insert into user_info(no, name, crime, groupno,biggroupno, imprison_end, address, process_level,imprison_begin,imprison_date) "
                        + " values('"
                        + result.getString("NO")
                        + "','"
                        + result.getString("NAME")
                        + "','"
                        + result.getString("crime")
                        + "','"
                        + result.getString("groupno")
                        + "','"
                        + result.getString("biggroupno")
                        + "','"
                        + result.getString("imprison_end")
                        + "','"
                        + result.getString("address")
                        + "','"
                        + result.getString("process_level")
                        + "','"
                        + result.getString("imprison_begin")
                        + "','"
                        + result.getString("imprison_date")
                        //replaceAll(',','2099.00.00')
                        + "')";
                logger.debug(sql);
                pre.addBatch(sql);
                num = num + 1;
            }

            pre.executeBatch();
            pre.clearBatch();
            pre.close();
            logger.info("插入成功" + num + "条数据importData2");

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
                logger.info("omp数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
