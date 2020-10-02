class DigitalHouseManager () {
    var listaDeAluno = mutableListOf<Aluno>()
    var listaDeProfessor = mutableListOf<Professor>()
    var listaDeCurso = mutableListOf<Curso>()
    var listaDeMatricula = mutableListOf<Matricula>()

    fun registrarCurso(
        nome: String, codigoCurso: Int,
        quantidadeMaximaDeAlunos: Int
    ) {
        listaDeCurso.add(Curso(nome, codigoCurso, quantidadeMaximaDeAlunos))
    }

    fun excluirCurso(codigoCurso: Int) {
        var apagaCurso: Curso? = null
        listaDeCurso.forEach {
            if (codigoCurso == it.codigoDoCurso) apagaCurso = it
        }
        listaDeCurso.remove(apagaCurso)
    }

    fun registrarProfessorAdjunto(
        nome: String, sobrenome: String,
        codigoProfessor: Int, quantidadeDeHoras: Int
    ) {
        listaDeProfessor.add(
            ProfessorAdjunto(
                quantidadeDeHoras, nome,
                sobrenome, 0, codigoProfessor
            )
        )
    }

    fun registrarProfessorTitular(
        nome: String, sobrenome: String,
        codigoProfessor: Int, especialidade: String
    ) {
        listaDeProfessor.add(
            ProfessorTitular(
                especialidade, nome,
                sobrenome, 0, codigoProfessor
            )
        )
    }

    fun excluirProfessor(codigoProfessor: Int) {
        var professorApagar: Professor? = null
        listaDeProfessor.forEach {
            if (codigoProfessor == it.codigoDeProfessor) professorApagar = it
        }
        listaDeProfessor.remove(professorApagar)
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        listaDeAluno.add(Aluno(nome, sobrenome, codigoAluno))
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        var aluno: Aluno? = null
        listaDeAluno.forEach {
            if (codigoAluno == it.codigoDeAluno) aluno = it
        }
        var curso: Curso? = null
        listaDeCurso.forEach {
            if (codigoCurso == it.codigoDoCurso) curso = it
        }
        if (aluno != null && curso != null) {
            if (listaDeMatricula.size < curso!!.qtdMaximaAluno) {
                listaDeMatricula.add(Matricula(aluno!!, curso!!))
                println("A matrícula foi realizada!")
            } else
                println("Não há vagas disponíveis!")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        var titular: Professor? = null
        listaDeProfessor.forEach {
            if (codigoProfessorTitular == it.codigoDeProfessor) titular = it
        }
        var adjunto: Professor? = null
        listaDeProfessor.forEach {
            if (codigoProfessorAdjunto == it.codigoDeProfessor) adjunto = it
        }
        var curso: Curso? = null
        listaDeCurso.forEach {
            if (codigoCurso == it.codigoDoCurso) curso = it
        }


        if (curso != null) {
            if (adjunto != null) {
                curso!!.professorAdjunto = adjunto
                println("O professor adjunto foi alocado!")
            }
            if (titular != null) {
                curso!!.professorTitular = titular
                println("O professor titular foi alocado!")
            }
        }
    }
}