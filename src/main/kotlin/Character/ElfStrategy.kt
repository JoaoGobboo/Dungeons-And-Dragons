package Character

class ElfStrategy : CharacterCreationStrategy {
    override fun apply(character: Character): Character {
        character.dexterity += 2
        character.intelligence += 1
        return character
    }
}
