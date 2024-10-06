package com.cibertec.business;

import java.util.List;

import com.cibertec.model.Subject;

public interface SubjectService {

	public int registrarSubject(Subject subject);
	public List<Subject> listarSubjects();
	public int actualizarSubject(Subject empleado);
	public Subject listarSubjectPorId(int id);
	public int eliminarSubjectPorId(int id);
	
}
