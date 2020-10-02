class ProfessorTitular(
    val especialidade: String,
    nome: String,
    sobrenome: String,
    tempoDeCasa: Int,
    codigoDeProfessor: Int): Professor(nome, sobrenome, tempoDeCasa, codigoDeProfessor){
}