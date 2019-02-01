package com.verificate.demo.bean;

	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Connection;
	import java.sql.Statement;

	public class MysqlInfo {
		static Connection conn = null;
        static String sql;
        static String url = "jdbc:mysql://149.129.84.241:3306/user_info?"
                + "user=root&password=abcd1234&useUnicode=true&amp&characterEncoding=utf-8";
        static String username="NULL";
        static String pwd="NULL";
        static int count=0;
        
        public int getCounts() throws SQLException, ClassNotFoundException {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            sql = "select count(*) from user  ";
            PreparedStatement stmt =  conn.prepareStatement(sql);
           ResultSet result = stmt.executeQuery(sql);   
           while(result.next()) {
               String str = result.getString(1);   
               count = Integer.valueOf(str).intValue();
        }
           return count;
           }
        
        public String getuserName(int orderid) throws SQLException {					
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            conn = DriverManager.getConnection(url);
		            sql = "select * from user where orderid = "+orderid;
		            PreparedStatement stmt =  conn.prepareStatement(sql);
		           ResultSet result = stmt.executeQuery(sql);   
		           while(result.next()) {
		               String str = result.getString(2);   
		               username=str;
		           								}     
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			return username;
		}
        
        public String getPassword(int orderid) throws SQLException {					
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            sql = "select * from user where orderid = "+orderid;
	            PreparedStatement stmt =  conn.prepareStatement(sql);
	           ResultSet result = stmt.executeQuery(sql);   
	           while(result.next()) {
	               String str = result.getString(3);   
	               pwd=str;
	           								}     
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		return pwd;
	}
		
		
        /***调试用
         * @throws ClassNotFoundException ***/
	    public static void main( String[] args ) throws SQLException, ClassNotFoundException
	    {
	    	MysqlInfo myobj = new MysqlInfo();
	    	System.out.println( myobj.getuserName(1) );
	    	System.out.println( myobj.getPassword(1) );
	    	System.out.println( myobj.getCounts() );
	       /***
	        *  try {
	            // 动态加载mysql驱动
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("成功加载MySQL驱动");
	            // Connection代表一个数据库连接， 
	            //conn = DriverManager.getConnection( URL , USER , PASS );  
	            conn = DriverManager.getConnection(url);
	         // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
	            sql = "select * from user where username = 'zhangsan5' ";//查询语句
	            //预加载方法实例化 声明 对象
	            PreparedStatement stmt =  conn.prepareStatement(sql);
	           //普通方法实例化 声明 对象 
	            //Statement stmt = conn.createStatement();
	           for(int i=1; i<=5;i++) { 
	           ResultSet result = stmt.executeQuery(sql);//执行sql并返回结果    
	           while(result.next()) {
	               //使用循环轮询可返回所有结果
	               String str = result.getString(i);   
	               System.out.println(str);
	           								}
	           }
	                System.out.println("sql completed！");        
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }**
	        */
	    }
	}
