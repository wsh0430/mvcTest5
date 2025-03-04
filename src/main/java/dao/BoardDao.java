package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVo;

public class BoardDao {
	
	private Connection conn = DBConnection.getConn();
	//싱글톤에서 같은 객체인지 판별(싱글톤은 객체를 하나만 생성)
//	private Connection conn2 = DBConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String sql = "";
	BoardVo vo = null;
	
	public void pstmtClose() {
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}//닫으면서 에러 날리가 없음, db객체 =  에러처리
		}
	}
	public void rsClose() {
		if(rs!=null) {
			try {
				rs.close(); 
			} catch (SQLException e) {}//닫으면서 에러 날리가 없음, db객체 =  에러처리
			finally {
				pstmtClose(); 					 //rs객체 닫으면 pstmt객체도 닫아야함 = pstmt 닫는 메소드 실행
			}
		}
	}
	
	//게시글 전체 리스트
	public List<BoardVo> getBoardList() {
		//싱글톤에서 같은 객체인지 판별
		/*
		if(conn.equals(conn2)) {
			System.out.println("conn과 conn2는 같은 객체 입니다.");
		}
		else{
			System.out.println("conn과 conn2는 ekfms 객체 입니다.");
		}
		*/
		List<BoardVo> vos = new ArrayList<BoardVo>();
		try {
			sql = "select * from boardTest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardVo vo = new BoardVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setReadNum(rs.getInt("readNum"));
				vo.setwDate(rs.getDate("wDate"));
				vos.add(vo);
				
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getBoardList) : " + e.getMessage());
		} finally {
			rsClose();
			
		}
		return vos;
	}
	
	// 게시글 등록 처리하기
	public int setBoardInput(BoardVo vo) {
		int res = 0;
		try {
			sql = "Insert into boardTest values (default,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName()); 
			pstmt.setString(2, vo.getTitle()); 
			pstmt.setString(3, vo.getContent()); 
			pstmt.setString(4, vo.getHostIp()); 
			res = pstmt.executeUpdate(); //실행횟수를 반환함
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardInput) : " + e.getMessage());
		}finally {
			pstmtClose();
			
		}
		return res;
	}
	
	//글 조회수 증가하기
	public void setReadNumUpdate(int idx) {
		try {
			sql = "select * from boardTest where idx = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setReadNumUpdate) : " + e.getMessage());
		}finally {
			pstmtClose();
			
		}
	}
	
	//글 내용 조회하기
	public BoardVo getBoardContent(int idx) {
		vo = new BoardVo();
		try {
			sql = "select * from boardTest where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//vo.setIdx(rs.getInt("idx")); //이거랑 아래랑 2가지방법 있음
				vo.setIdx(idx);
				vo.setName(rs.getString("name"));
				vo.setwDate(rs.getDate("wDate"));
				vo.setReadNum(rs.getInt("ReadNum"));
				vo.setHostIp(rs.getString("HostIp"));
				vo.setTitle(rs.getString("Title"));
				vo.setContent(rs.getString("Content"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardInput) : " + e.getMessage());
		}finally {
			rsClose(); //select이므로 rs를 닫음(나머진pstmt)
			
		}
		return vo;
	}
	public int setBoardDelete(int idx) {
		int res = 0;
		try {
			sql = "delete from boardTest where idx = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardDelete) : " + e.getMessage());
		}finally {
			rsClose(); //select이므로 rs를 닫음(나머진pstmt)
			
		}
		return res;
	}
}
