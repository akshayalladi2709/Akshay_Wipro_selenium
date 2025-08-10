package day11_assignment;

import java.sql.*;

public class Mini_proj {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        st.execute("create table if not exists studs (rollno int, name varchar(50), per int, email varchar(50), city varchar(50))");
        st.execute("create table if not exists insti (inst_id int, rollno int, inst_name varchar(50))");
        st.execute("insert into studs values (1, 'Akshay', 89, 'akshay@mail.com', 'Hyd')");
      st.execute("insert into studs values (2, 'Suhas', 91, 'suhas@mail.com', 'Hyd')");    
      st.execute("insert into studs values (3, 'Uday', 75, 'uday@mail.com', 'Mumbai')");
        st.execute("insert into studs values (4, 'Meena', 92, 'meena@mail.com', 'Chennai')");
       st.execute("insert into studs values (5, 'Ravi', 78, 'ravi@mail.com', 'Bangalore')");
       st.execute("insert into studs values (6, 'Neha', 85, 'neha@mail.com', 'Pune')");
       st.execute("insert into studs values (7, 'Arjun', 88, 'arjun@mail.com', 'Hyderabad')");
       st.execute("insert into studs values (8, 'Divya', 90, 'divya@mail.com', 'Mumbai')");

        st.execute("insert into insti values (101, 1, 'Reva')");
st.execute("insert into insti values (102, 2, 'Reva')");
st.execute("insert into insti values (103, 5, 'BITS')");

        ResultSet rs = st.executeQuery("select * from studs");
        System.out.println("\nStuds Table:");
        while (rs.next()) {
            System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getInt("per") + " " + rs.getString("email") + " " + rs.getString("city"));
        }

        st.executeUpdate("update studs set per = 95 where rollno = 1");

        rs = st.executeQuery("select * from studs where per = (select max(per) from studs)");
        System.out.println("\nHigh percent:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getInt("per"));
        }

        rs = st.executeQuery("select * from studs order by name asc");
        System.out.println("\nStudents in Ascending Order:");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        rs = st.executeQuery(
        	    "select s.city, s.name from studs s " +
        	    "join (select city from studs group by city having count(*) > 1) c " +
        	    "on s.city = c.city"
        	);

        	System.out.println("\nSame City Students");
        	while (rs.next()) {
        	    System.out.println(rs.getString("city") + " - " + rs.getString("name"));
        	}

        st.execute("alter table studs add gender varchar(10)");

        st.execute("alter table studs modify gender char(1)");

        st.execute("rename table studs to studsinfos");

        st.execute("alter table studsinfos drop column gender");

        rs = st.executeQuery("select s.rollno, s.name, i.inst_name from studsinfos s inner join insti i on s.rollno = i.rollno");
        System.out.println("\nInner Join (Common Records):");
        while (rs.next()) {
            System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getString("inst_name"));
        }

        rs = st.executeQuery("select s.rollno, s.name, i.inst_name from studsinfos s left join insti i on s.rollno = i.rollno");
        System.out.println("\nLeft Join (All Students):");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getString("inst_name"));
        }

        rs = st.executeQuery("select s.name, i.inst_name from studsinfos s right join insti i on s.rollno = i.rollno");
        System.out.println("\nRight Join (All Institutes):");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getString("inst_name"));
        }

        rs = st.executeQuery(
            "(select s.name, i.inst_name from studsinfos s left join insti i on s.rollno = i.rollno) " +
            "union " +
            "(select s.name, i.inst_name from studsinfos s right join insti i on s.rollno = i.rollno)"
        );
        System.out.println("\nFull Outer Join (All Records):");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getString("inst_name"));
        }
  st.execute("delete from studsinfos where rollno = 3");
     System.out.print("one record deleted");
    st.execute("truncate table studsinfos");
     System.out.print("all records deleted");
     st.execute("drop table studsinfos");

        rs.close();
        st.close();
        con.close();
    }
}
