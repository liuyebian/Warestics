package team.nwt.warestics.TransportationManagementSystem;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import team.nwt.warestics.MySQLConnect; 



public class TMS_Model extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String model_id=TMS.text;
    static String model_order_id;
    static String model_goods_id;
    static String model_goods_name;
    static String model_goods_number;
 
    //通过传递的sql语句来获得数据模型
//    public TMS_Model(String sql)
//    {
//    	//建立表头  
//    	ColumnNames= new Vector();
//		ColumnNames.add("商品id");
//		ColumnNames.add("商品名称");
//		ColumnNames.add("商品数量");
//		RowData=new Vector(); 
//		String sql0 = "SELECT * FROM tb_orderinformation WHERE order_id='"+model_id+"'";
//	    MySQLConnect con0 = new MySQLConnect(sql0);	 // 新建一个数据库连接						
//	    try {
//			ResultSet result0 = con0.pst.executeQuery();			// 执行sql语句，得到结果集		
//			while (result0.next()) {
//	            Vector hang=new Vector();
//	        	hang.add(result0.getInt(1));
//	        	hang.add(result0.getString(2));
//	        	hang.add(result0.getString(3));
//	        	RowData.add(hang);
//	        }
//	        result0.close();		// 关闭执行的语句连接
//	        con0.close();			// 关闭数据库连接
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    //建立构造函数初始化数据模型
    public TMS_Model()
    {
    	

		ColumnNames= new Vector();
		ColumnNames.add("商品id");
		ColumnNames.add("商品数量");
		ColumnNames.add("商品名称");
	
		RowData=new Vector(); 

		String sql1 = "SELECT order_id FROM tb_transfer WHERE transfer_id='"+model_id+"'";
    	MySQLConnect con1 = new MySQLConnect(sql1);
    	try {
			ResultSet result1 = con1.pst.executeQuery();
			if(result1.next()){
				model_order_id=result1.getString("order_id");
				System.out.println(result1.getString("order_id"));			//测试order_id
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
//    	String sql2 = "SELECT goods_id,goods_number FROM tb_orderinformation WHERE order_id='"+model_order_id+"'";
    	String sql2 = "SELECT * FROM tb_orderinformation WHERE order_id='2017062801'";
    	MySQLConnect con2 = new MySQLConnect(sql2);
    	try {
			ResultSet result2 = con2.pst.executeQuery();
			while(result2.next()){
				
				System.out.println(result2.getString("goods_id"));			//测试goods_id
				System.out.println(result2.getString("goods_number"));		//测试goods_number
				System.out.println("infomation表的"+result2.getString("order_id"));//测试orderinformation表的order_id
				
				Vector hang=new Vector();
	            hang.add(result2.getInt(1));
	        	hang.add(result2.getInt(2));
	        	hang.add(result2.getDouble(3));
	        	RowData.add(hang);
	        }
			result2.close();		// 关闭执行的语句连接
	        con2.close();			// 关闭数据库连接
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }
    

	
  //得到共有多少列
  	public int getColumnCount() {
  		
  		// TODO 自动生成的方法存根
  		return this.ColumnNames.size();
  	}

  	//得到共有多少行
  	public int getRowCount() {
  		// TODO 自动生成的方法存根
  		return this.RowData.size();
  	}

  	@Override
  	public String getColumnName(int arg0) {
  		// TODO 自动生成的方法存根
  		return (String)this.ColumnNames.get(arg0);
  	}


  	//得到某行某列的数据
  	public Object getValueAt(int row, int column) {
  		// TODO 自动生成的方法存根
  		return ((Vector)this.RowData.get(row)).get(column);
  	}

  }