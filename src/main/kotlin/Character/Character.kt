package Character

class Character(
    var name: String,
    var strength: Int = 10,
    var dexterity: Int = 10,
    var constitution: Int = 10,
    var intelligence: Int = 10,
    var wisdom: Int = 10,
    var charisma: Int = 10

) {
    val healthPoints: Int
        get() = 10 + ((constitution - 10) / 2)

    // Outros métodos e atributos
}
