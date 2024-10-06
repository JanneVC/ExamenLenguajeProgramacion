package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Subject;

public interface SubjectDao {

	public int insertarSubject(Subject subject);
	public List<Subject> listarSubjects();
	public Subject listarSubjectPorId(int id);
	public int actualizarSubject(Subject subject);
	public int eliminarSubject(int id);
	
}
