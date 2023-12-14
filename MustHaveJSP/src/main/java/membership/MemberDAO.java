package membership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
//	public static void main(String[] args) {
//		MemberDAO md = new MemberDAO("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
//		MemberDTO member = md.getMemberDTO("musthave", "12345");
//		if (member != null) System.out.println(member);
//		else System.out.println("데이터가 없습니다.");
//	}
	
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String query = "select * from member where id=? and pass=?";
		
		try {
			psmt = getCon().prepareStatement(query); // JDBConnect private field con: getter method 이용해야함
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery(); // query 실행
			
			if (rs.next()) {
				dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
//			여기에서도 rs.close(); 등으로 쓸 수 있지만 예외 발생할 수 있기 때문에 예외처리 하는 편이 좋다.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (rs != null) rs.close(); // 왜 != null 로 쓰는지 알아야함
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
}
