package fileupload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import common.JDBConnect;

public class MyFileDAO extends JDBConnect {
	public int insertFile(MyFileDTO dto) {
		int applyResult = 0;
		PreparedStatement psmt = null;
		try {
			String query = "insert into myfile (title, cate, ofile, sfile) values (?, ?, ?, ?)";
			psmt = getCon().prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCate());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Insert 중 예외 발생");
			System.out.println(e.getMessage());
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MyFileDAO.insertFile.finally error");
				e.getMessage();
			}
		}

		return applyResult;
	}
	
	public List<MyFileDTO> myFileList() throws SQLException{
		List<MyFileDTO> fileList = new Vector<MyFileDTO>();

		String query = "select * from myfile order by idx desc";
		Statement stmt = getCon().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		try {
			while (rs.next()) {
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setCate(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setSfile(rs.getString(5));
				dto.setPostdate(rs.getString(6));

				fileList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("select시 예외 발생");
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fileList;
	}
}
