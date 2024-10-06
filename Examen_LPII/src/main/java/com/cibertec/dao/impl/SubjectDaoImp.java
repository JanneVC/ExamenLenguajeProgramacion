package com.cibertec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.config.Conectar;
import com.cibertec.dao.SubjectDao;

import com.cibertec.model.Subject;

public class SubjectDaoImp implements SubjectDao{
	
	private Conectar conectar;
	
	public SubjectDaoImp (){
		conectar = new Conectar();
	}
	
	@Override
	public int insertarSubject(Subject subject) {
		int valor=0;
		Connection conexion =null;
		PreparedStatement ps= null;
		
		try {
			System.out.println("Objeto: " + subject.toString());
			conexion = conectar.conectarMySql();
			String sql = "INSERT INTO SUBJECT VALUES (null,?,?)";
			ps= conexion.prepareStatement(sql);
			ps.setString(1, subject.getSubject());
			ps.setString(2, subject.getCredits());
			valor =ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al insertar Objeto: " + e.getMessage());
		} finally {
			try {
				if (ps != null) ps.close();
				if (conexion != null) conexion.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return valor;		
	}

	@Override
	public List<Subject> listarSubjects() {
		List<Subject> lista =new ArrayList<>();
		Connection conexion = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexion = conectar.conectarMySql();
			String sql = "SELECT * FROM SUBJECT";
			ps = conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setIdsubject(rs.getInt("idsubject"));
				subject.setSubject(rs.getString("Subject"));
				subject.setCredits(rs.getString("credits"));
				lista.add(subject);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar objetos: " + e.getMessage());
		} try {
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conexion != null) conexion.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return lista;
	}
	
	@Override
	public Subject listarSubjectPorId(int id) {
		
		Subject subject =null;
		Connection conexion = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexion = conectar.conectarMySql();
			String sql = "SELECT * FROM SUBJECT WHERE IDSUBJECT = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				subject=new Subject();
				subject.setIdsubject(rs.getInt("IdSubject"));
				subject.setSubject(rs.getString("Subject"));
				subject.setCredits(rs.getString("Credits"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar Empleado: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conexion != null) conexion.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return subject;
	}

	@Override
	public int actualizarSubject(Subject subject) {
		int valor=0;
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			
			System.out.println("Objeto: " + subject.toString());
			conexion = conectar.conectarMySql();
			String sql = "UPDATE SUBJECT SET SUBJECT = ?, CREDITS = ?  WHERE IDSUBJECT = ?";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, subject.getSubject());
			ps.setString(2, subject.getCredits());
			ps.setInt(4, subject.getIdsubject());
			valor = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar Objeto: " + e.getMessage());	
		}finally {
			try {
				if (ps != null) ps.close();
				if (conexion != null) conexion.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return valor;
	}

	@Override
	public int eliminarSubject(int id) {
		int valor = 0;
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			System.out.println("IdSubject: " + id);
			conexion = conectar.conectarMySql();
			String sql = "DELETE FROM SUBJECT WHERE IDSUBJECT = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			valor = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar Empleado: " + e.getMessage());	
		}finally {
			try {
				if (ps != null) ps.close();
				if (conexion != null) conexion.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return valor;
	}

}
