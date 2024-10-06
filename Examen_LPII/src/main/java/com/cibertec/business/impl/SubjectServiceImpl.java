package com.cibertec.business.impl;

import java.util.List;

import com.cibertec.business.SubjectService;
import com.cibertec.dao.SubjectDao;
import com.cibertec.dao.impl.SubjectDaoImp;
import com.cibertec.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	
	private SubjectDao dao= new SubjectDaoImp();
	
	@Override
	public int registrarSubject(Subject subject) {
		return dao.insertarSubject(subject);
	}
	@Override
	public List<Subject> listarSubjects() {
		return dao.listarSubjects();
	}

	@Override
	public int actualizarSubject(Subject subject) {
		return dao.actualizarSubject(subject);

	}

	@Override
	public Subject listarSubjectPorId(int id) {
		return dao.listarSubjectPorId(id);
	}

	@Override
	public int eliminarSubjectPorId(int id) {
		return dao.eliminarSubject(id);
	}
}
