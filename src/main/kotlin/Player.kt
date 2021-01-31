class Player(
    val name: String,
    val hand: MutableList<Card> = mutableListOf(),
) {

    fun drawCard(deck: MutableList<Card>) = this.hand.add(deck.removeFirst())

    fun dropCard() {
        println("Enter the value of a card to drop")
        val index = readLine()!!.toInt()
        this.hand.removeIf { it.value == index }
    }

    override fun toString(): String = "${this.name} | ${this.hand}"

}