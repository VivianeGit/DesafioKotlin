class Curso (val nomeDoCurso: String,
             val codigoDoCurso: Int,
             var qtdMaximaAluno: Int) {
    var professorTitular: Professor? = null
    var professorAdjunto: Professor? = null
    val listaDeAluno = mutableListOf<Aluno>()

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        if (listaDeAluno.size < qtdMaximaAluno) {
           listaDeAluno.add(umAluno)
            return true
        }else
            return false
    }
    fun excluirAluno(umAluno: Aluno){
        listaDeAluno.remove(umAluno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigoDoCurso != other.codigoDoCurso) return false

        return true
    }

    override fun hashCode(): Int {
        return codigoDoCurso
    }

}