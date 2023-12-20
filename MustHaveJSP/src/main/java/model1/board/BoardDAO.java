package model1.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class BoardDAO extends JDBConnect {
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		String query = "select count(*) from board";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		
		try {
			Statement stmt = getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch(Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return totalCount;
	}
	
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<>();
		
		String query = "select * from board ";
		if (map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%' order by num desc";
		}
		
		try {
			Statement stmt = getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
			
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return bbs;
	}
	
	public List<BoardDTO> selectListPage(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>(); // 결과(게시물 목록)을 담을 변수
		
		String query = "select * from board";
		
		if(map.get("searchWord") != null) {
			query += " where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'"; // 띄어쓰기 주의
		}

		query += " order by num asc limit ?, ?";
		
		try {
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setInt(1, (int)map.get("start"));
			psmt.setInt(2, (int)map.get("pageSize"));
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
		} catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return bbs;
	}
	
	public int insertWrite(BoardDTO dto) {
		int result = 0;
		
		try {
			String query = "insert into board (title, content, id, visitcount) values (?, ?, ?, 0)";
			
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result = psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		
		String query = "select b.*, m.name from member m inner join board b on m.id=b.id where num = ?";
		
		try {
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setString(1, num);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
			rs.close();
			psmt.close();
		} catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	public void updateVisitCount(String num) {
		String query = "update board set visitcount=visitcount+1 where num = ?";
		
		try {
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			System.out.println(e.getMessage());
		}
	}
	
	public int updateEdit(BoardDTO dto) {
//		dto는 BoardDAO에서 생성
		int result = 0;
		
		try {
			String query = "update board set title = ?, content = ? where num = ?";
			
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			result = psmt.executeUpdate(); // result는 int
			psmt.close();
		} catch(Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int deletePost(BoardDTO dto) {
		int result = 0;
		try {
			String query = "delete from board where num=?";
			
			PreparedStatement psmt = getCon().prepareStatement(query);
			psmt.setString(1, dto.getNum());
			
			result = psmt.executeUpdate();
			psmt.close();
		}catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			System.out.println(e.getMessage());
		}
		
		return result;
	}
}
