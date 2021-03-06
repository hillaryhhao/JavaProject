package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import team.sqjj.hospital.dao.OrderDao;
import team.sqjj.hospital.model.Order;

public class OrderDaoImpl implements OrderDao{
    private Dao dao=null;
    public 	OrderDaoImpl(){



13
        dao=new Dao();   }

    }
    @Override
    public int addOrder(int drugId,String patientId,String id,String doctorName,String department,String drugName,int quantity,String unit,int price,String code,int isPaid){
    	int i=0;
		try{
			String sql="insert into Order values("+drugId+",'"+patientId+"','"+id+"','"+doctorName+"','"+department+"','"+drugName+"',"+quantity+",'"+unit+"','"+code+"',"+isPaid+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int payOrder(String orderId){
    	int i=0;
    	int j=1;
		try{
			String sql="update Order set IsPaid "+j+" where order_Id ="+orderId+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public List<Order> getByPatientID (String patientId){
    	Order order=null;
        String sql="select *from Order where Patient_Id='"+patientId+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Order> list = null;
	    try {
	        while(rs.next()){
	        	order=new Order();
	        	order.setOrder_Id(rs.getInt("Order_Id"));
	        	order.setDrug_Id(rs.getInt("Drug_Id"));
	        	order.setPatient_Id(rs.getString("Patient_Id"));
	        	order.setId(rs.getString("Id"));
	        	order.setDoctor_Name(rs.getString("Doctor_Name"));
	        	order.setDepartment(rs.getString("Department"));
	        	order.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(order);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
    @Override
    public List<Order> getByDoctor(String id){
    	Order order=null;
        String sql="select *from Order where Id='"+id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Order> list = null;
	    try {
	        while(rs.next()){
	        	order=new Order();
	        	order.setOrder_Id(rs.getInt("Order_Id"));
	        	order.setDrug_Id(rs.getInt("Drug_Id"));
	        	order.setPatient_Id(rs.getString("Patient_Id"));
	        	order.setId(rs.getString("Id"));
	        	order.setDoctor_Name(rs.getString("Doctor_Name"));
	        	order.setDepartment(rs.getString("Department"));
	        	order.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(order);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
    @Override
    public List<Order> getByDepartment(String department){
    	Order order=null;
        String sql="select *from Order where Department='"+department+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Order> list = null;
	    try {
	        while(rs.next()){
	        	order=new Order();
	        	order.setOrder_Id(rs.getInt("Order_Id"));
	        	order.setDrug_Id(rs.getInt("Drug_Id"));
	        	order.setPatient_Id(rs.getString("Patient_Id"));
	        	order.setId(rs.getString("Id"));
	        	order.setDoctor_Name(rs.getString("Doctor_Name"));
	        	order.setDepartment(rs.getString("Department"));
	        	order.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(order);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
}
